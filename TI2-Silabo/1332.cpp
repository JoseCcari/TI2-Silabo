#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#define MAX_TAM 1000

struct regNo    {   struct regNo *esq;
                    int num;
                    struct regNo *dir;
                };
typedef struct regNo TArvore;

TArvore * FuncPai(TArvore *r, int n)
{   if(r == NULL)
        return NULL;
    else if (n == r->num){
        return r;
    }
    else if(n < r->num)
    {       if(r->esq == NULL)
                return r;
            else
                return FuncPai(r->esq, n);
    }
        else
        {
            if(r->dir == NULL)
                return r;
            else
                return FuncPai(r->dir, n);
        }
}


int main()
{   TArvore *raiz, *pai, *aux, *fila[MAX_TAM];
    int nVal, Ncasos, nC, cont, noh, contA, contB;

    scanf("%d", &Ncasos);

    for(nC=1; nC<=Ncasos; nC++)
    {
		for(cont=0;cont<MAX_TAM;cont++)
			fila[cont] = NULL;

        raiz = NULL;

        scanf("%d", &nVal);
        for(cont=0; cont<nVal; cont++)
        {
            scanf("%d", &noh);

            aux = (TArvore *) malloc(sizeof(TArvore));
            aux->num = noh;
            aux->esq = aux->dir = NULL;

            pai = FuncPai(raiz, noh);
            if(pai == NULL)
                raiz = aux;
            else if (pai->num != noh){
                if (noh < pai->num)
                    pai->esq = aux;

                else
                    pai->dir = aux;
            }
        }

        printf("Case %d:\n", nC);

        aux = raiz;
        contA = 1;
        contB  = 1;
        fila[0] = aux;
        while(aux != NULL){
            printf("%d", aux->num);

            if(aux->esq != NULL){
                fila[contA] = aux->esq;
                contA++;
            }

            if(aux->dir != NULL){
                fila[contA] = aux->dir;
                contA++;
            }

            if(fila[contB]!=NULL)
                printf(" ");

            aux = fila[contB];
            contB++;
        }

        printf("\n\n");
    }

    return 0;

}

#include <bits/stdc++.h>
#define INF 999999
using namespace std;
typedef pair<int, int> ii;
int v[255][255];
int caminho[255];
int n, m, c, k1;
void floydwarshall()
{
    for (int k = c ; k < n ; ++k)
        for (int i = 0 ; i < n ; ++i)
            for (int j = 0 ; j < n ; ++j)
                v[i][j] = min(v[i][j], v[i][k] + v[k][j]);
}
int main()
{
    
    int u, w, p;
    int v1, v2;
    ios_base :: sync_with_stdio(0); cin.tie(0);
    while (1)
    {
        cin >> n >> m >> c >> k1;
        if (!n) return 0;
        
        memset(v, INF, sizeof v);
        memset(caminho, 0, sizeof caminho);
        
        for (int i = 0 ; i < m ; ++i)
        {
            cin >> u >> w >> p;
            v[u][w] = v[w][u] = p;
        }
        int sum = 0;
        for (int i = c - 2 ; i >= 0; --i)
        {
            sum += v[i][i + 1];
            
            caminho[i] = sum;
        }
        floydwarshall();
        int ans = v[k1][c - 1];
        for (int i = 0 ; i < c - 1; ++i)
        {
            ans = min(v[k1][i] + caminho[i], ans);
        }
        cout << ans << endl;
    }
}