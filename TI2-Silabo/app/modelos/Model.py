#from app import app
#from app.controladores.controlador import tasks
from flask import jsonify, request
from flaskext.mysql import MySQL

class Model:

    def __init__(self,app):
        self.mysql=MySQL()
        app.config['MYSQL_DATABASE_USER']='root'
        app.config['MYSQL_DATABASE_PASSWORD']='unsa12345'
        app.config['MYSQL_DATABASE_DB']='Silabos'
        app.config['MYSQL_DATABASE_HOST']='127.0.0.1'
        self.mysql.init_app(app)

        self.con=self.mysql.connect()
        self.cursor=self.con.cursor()

    def getSilabos(self):
        silabos = []
        self.cursor.execute("SELECT * from Silabo")
        tmp = self.cursor.fetchall()
        for silabo in tmp:
            s = {}
            s["id"] = silabo[0]
            s["sem"] = silabo[1]
            silabos.append(s)

        return jsonify(silabos)
    
    
    def addDocente(self):
        print(request.json)
        query = f'INSERT INTO Docente (doc_dni , doc_nom , doc_ape_pat , doc_ape_mat , doc_grad_aca , dep_aca_ide ) VALUES ({request.json["dni"]},"{request.json["name"]}","{request.json["lastname1"]}","{request.json["lastname2"]}","{request.json["gradoacademico"]}",{request.json["depAcademico"]})'
        print (query)
        self.cursor.execute(query)
        self.con.commit()
        return "Insert Succesful"

    def searchDocente(self, dni):
        Docentes = []
        query = "SELECT doc_ide ,doc_dni , doc_nom , doc_ape_pat , doc_ape_mat , doc_grad_aca , dep_aca_ide FROM Docente WHERE doc_dni = %s AND doc_del_date is null "
        self.cursor.execute(query, (dni,))
        data = self.cursor.fetchall()
        
        for dnis in data:
            s = {}
            s["doc_ide"] = dnis[0]
            s["doc_dni"] = dnis[1]
            s["doc_nom"] = dnis[2]
            s["doc_ape_mat"] = dnis[3]
            s["doc_ape_pat"] = dnis[4]
            s["doc_grad_aca"] = dnis[5]
            s["dep_aca_ide"] = dnis[6]
            
            Docentes.append(s)
        
        return jsonify(Docentes[0])


    def deleteDocente(self,dni):
        query = "UPDATE Docente SET doc_del_date=now() WHERE doc_dni= %s"
        self.cursor.execute(query, (dni,))
        self.con.commit()
        return "Docente Eliminado"

    def updateDocente(self ):
        newdata = request.json
        print ("BODY JSON: ",newdata)
        t = newdata["doc_ide"]
        #query = "UPDATE Docente SET doc_dni = %s , doc_nom = %s, doc_ape_pat = %s, doc_ape_mat = %s, doc_grad_aca = %s, dep_aca_ide = %s WHERE doc_ide = %s " , ( newdata["doc_dni"],newdata["doc_nom"] ,newdata["doc_ape_pat"],newdata["doc_ape_mat"],newdata["doc_grad_aca"],newdata["dep_aca_ide"],newdata["doc_ide"] )
        query = "UPDATE Docente SET doc_dni = %s , doc_nom = %s, doc_ape_pat = %s, doc_ape_mat = %s, doc_grad_aca = %s, dep_aca_ide = %s WHERE doc_ide = %s" 
        
        #print (query)

        self.cursor.execute(query,( newdata["doc_dni"],newdata["doc_nom"] ,newdata["doc_ape_pat"],newdata["doc_ape_mat"],newdata["doc_grad_aca"],newdata["dep_aca_ide"],newdata["doc_ide"]))
        self.con.commit()
        return "Docente Actualizado"
        
  

    def searchCurs(self, cod):
        Cursos = []
        query = "SELECT cur_cod , cur_nom , cur_sem , cur_dur , cur_hor_teo , cur_hor_prac , cur_hor_lab , cur_credi , cur_fund FROM Curso WHERE cur_cod = %s "
        
        self.cursor.execute(query, (cod,))
        data = self.cursor.fetchall()

        for codi in data:
            s = {}
            s["cur_cod"] = codi[0]
            s["cur_nom"] = codi[1]
            s["cur_sem"] = codi[2]
            s["cur_dur"] = codi[3]
            s["cur_hor_teo"] = codi[4]
            s["cur_hor_prac"] = codi[5]
            s["cur_hor_lab"] = codi[6]
            s["cur_credi"] = codi[7]
            s["cur_fund"] = codi[8]
            
            Cursos.append(s)

        return jsonify(Cursos[0])
    