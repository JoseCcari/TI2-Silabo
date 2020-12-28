
DROP TABLE IF EXISTS Curso;		
CREATE TABLE Curso (
cur_ide INT NOT NULL AUTO_INCREMENT ,
cur_cod VARCHAR (20),
cur_nom varchar(50),
cur_sem INT,
cur_dur INT,
cur_hor_teo INT,
cur_hor_prac INT,
cur_hor_lab INT,
cur_credi INT,
cur_fund varchar(5000),
PRIMARY KEY (cur_ide)
);


DROP TABLE IF EXISTS Silabo;
CREATE TABLE Silabo (
  sil_ide INT NOT NULL AUTO_INCREMENT,
  sil_per varchar(10),
  sil_inf_espe varchar(4000),
  sil_comp_asig varchar(5000),

  sil_eva_apre varchar(3000),
  sil_req_apro varchar(2000),
  cur_ide INT,
  PRIMARY KEY (sil_ide)
);

DROP TABLE IF EXISTS Programacion_actividades;
CREATE TABLE Programacion_actividades(
  prog_ide INT NOT NULL,
  prog_act_met varchar(1000),
  prog_act_med varchar(1000),
  prog_act_form varchar(1000),
  prog_act_inv varchar(1000),
  sil_ide INT,
  PRIMARY KEY (prog_ide)
);



DROP TABLE IF EXISTS Cronograma_evaluacion;
CREATE TABLE Cronograma_evaluacion (
  cro_ide INT NOT NULL,
  cro_eva INT NOT NULL,
  cro_fecha DATE,
  cro_exa_teo INT,
  cro_eva_con INT,
  sil_ide INT,
  PRIMARY KEY (cro_ide)
);




DROP TABLE IF EXISTS Docente;
CREATE TABLE Docente (
doc_ide INT NOT NULL AUTO_INCREMENT,
doc_dni INT NOT NULL,
doc_nom varchar (100),
doc_ape_pat varchar(100),
doc_ape_mat varchar(100),
doc_grad_aca varchar(100),
doc_del_date date ,
dep_aca_ide INT,
PRIMARY KEY (doc_ide)
);

DROP TABLE IF EXISTS Sil_docente;
CREATE TABLE Sil_docente (
sil_docente_ide INT NOT NULL,
doc_ide INT,
sil_ide INT,
PRIMARY KEY (sil_docente_ide)
);


DROP TABLE IF EXISTS Departamento_academico ;
CREATE TABLE Departamento_academico  (
dep_aca_ide INT  NOT NULL AUTO_INCREMENT,
dep_aca_nom varchar (100),
PRIMARY KEY (dep_aca_ide)
);


DROP TABLE IF EXISTS Unidad_academica;
CREATE TABLE Unidad_academica (
uni_aca_ide INT NOT NULL,
uni_nom varchar(100),
sil_ide INT,
PRIMARY KEY (uni_aca_ide)
);






DROP TABLE IF EXISTS Capitulo;		
CREATE TABLE Capitulo (
  cap_ide INT NOT NULL,
  cap_nom varchar(100),
  uni_aca_ide INT,
  PRIMARY KEY (cap_ide)
);


DROP TABLE IF EXISTS Tema;
CREATE TABLE Tema (
  tem_ide INT NOT NULL,
  tem_nom varchar(100),
  tem_sem varchar(10),
  tem_porcen varchar(100),
  cap_ide INT,
  PRIMARY KEY (tem_ide)
);



DROP TABLE IF EXISTS Bibliografia;
CREATE TABLE Bibliografia (
  bib_ide INT NOT NULL,
  bib_nom  varchar(50),
  bib_edi varchar(50),
  bib_editorial varchar(50),
  bib_año varchar(50),
  PRIMARY KEY (bib_ide)
);


DROP TABLE IF EXISTS Bibliografia_silabo;
CREATE TABLE Bibliografia_silabo (
  bib_sil_ide INT NOT NULL,
  bib_sil_prio BOOLEAN,
  bib_ide INT,
  sil_ide INT,
  PRIMARY KEY (bib_sil_ide)
);



DROP TABLE IF EXISTS Autor;
CREATE TABLE Autor (
  aut_ide INT NOT NULL,
  aut_nom INT,
  aut_ape INT,
  PRIMARY KEY (aut_ide)
);





DROP TABLE IF EXISTS Autor_bibliografia;
CREATE TABLE Autor_bibliografia (
  aut_bib_ide INT NOT NULL,
  bib_ide INT,
  aut_ide INT,
  PRIMARY KEY (aut_bib_ide)
);

   
DROP TABLE IF EXISTS Prerequisitos;
CREATE TABLE Prerequisitos(
  pre_ide INT NOT NULL,
  curs_ide INT,
  pre_cur_ide INT,
  PRIMARY KEY (pre_ide)
);


ALTER TABLE Cronograma_evaluacion ADD FOREIGN KEY (sil_ide) REFERENCES Silabo (sil_ide);

ALTER TABLE Unidad_academica ADD FOREIGN KEY (sil_ide) REFERENCES Silabo (sil_ide);
ALTER TABLE Silabo ADD FOREIGN KEY (cur_ide) REFERENCES Curso (cur_ide);
ALTER TABLE Capitulo ADD FOREIGN KEY (uni_aca_ide) REFERENCES Unidad_academica (uni_aca_ide);
ALTER TABLE Tema ADD FOREIGN KEY (cap_ide) REFERENCES Capitulo (cap_ide);
ALTER TABLE Programacion_actividades ADD FOREIGN KEY (sil_ide) REFERENCES Silabo(sil_ide);
ALTER TABLE Bibliografia_silabo ADD FOREIGN KEY (bib_ide) REFERENCES Bibliografia (bib_ide);
ALTER TABLE Bibliografia_silabo ADD FOREIGN KEY (sil_ide) REFERENCES Silabo (sil_ide);
ALTER TABLE Autor_bibliografia ADD FOREIGN KEY (bib_ide) REFERENCES Bibliografia (bib_ide);
ALTER TABLE Autor_bibliografia ADD FOREIGN KEY (aut_ide) REFERENCES Autor (aut_ide);
ALTER TABLE Prerequisitos ADD FOREIGN KEY (curs_ide) REFERENCES Curso (cur_ide);

ALTER TABLE Sil_docente ADD FOREIGN KEY (sil_ide) REFERENCES Silabo (sil_ide);
ALTER TABLE Sil_docente ADD FOREIGN KEY (doc_ide) REFERENCES Docente (doc_ide);

ALTER TABLE Docente ADD FOREIGN KEY (dep_aca_ide) REFERENCES Departamento_academico  (dep_aca_ide);
-- INSERT INTO Silabo (sil_ide,sil_sem,sil_inst_eva,sil_per_aca,sil_fun,sil_sum,sil_req_apro) VALUES
-- ('','','','','','','');
-- INSERT INTO Cronograma (cro_ide,cro_eva,cro_fecha,cro_exa_teo,cro_eva_cont,est_eva_ide) VALUES
-- ('','','','','','');
-- INSERT INTO Estrategia_evaluacion (est_eva_ide,est_eva_eva_cont,est_eva_eva_per,est_eva_tip_eva,est_eva_inst_eva,sil_ide) VALUES
-- ('','','','','','');
-- INSERT INTO Unidad_academica (uni_aca_ide,uni_nom,sil_ide) VALUES
-- ('','','');
-- INSERT INTO Curso (cur_sem,cur_credi,cur_hor_teo,cur_hor_prac,cur_hor_lab,cur_nom,cur_sum,cur_hor_tot,cur_fund,cur_cod,cur_sem_anual,cur_dur,sil_ide) VALUES
-- ('','','','','','','','','','','','','');
-- INSERT INTO Capitulo (cap_ide,cap_nom,uni_aca_ide) VALUES
-- ('','','');
-- INSERT INTO Tema (tem_ide,tem_nom,tem_sem,tem_porcen,cap_ide) VALUES
-- ('','','','','');
-- INSERT INTO Silabo_estrategia_aprendizaje (sil_est_apre_ide,est_apre_ide,sil_ide) VALUES
-- ('','','');
-- INSERT INTO Estrategia_aprendizaje (est_apre_ide,est_apre_tip,est_apre_desc) VALUES
-- ('','','');
-- INSERT INTO Bibliografia (bib_ide,bib_nom,bib_edi,bib_editorial,bib_año) VALUES
-- ('','','','','');
-- INSERT INTO Bibliografia_silabo (bib_sil_ide,bib_ide,sil_ide) VALUES
-- ('','','');
-- INSERT INTO Resultado (res_ide) VALUES
-- ('');
-- INSERT INTO Resultado_silabo (res_sil_ide,res_ide,sil_ide) VALUES
-- ('','','');
-- INSERT INTO Autor (aut_ide,aut_nom,aut_ape) VALUES
-- ('','','');
-- INSERT INTO Autor_bibliografia (aut_bib_ide,bib_ide,aut_ide) VALUES
-- ('','','');




--- Scripts ADD 
--Docente 
-- Agregar Docente
-- Agrega un nuevo registro a la tabla Docente, se envian todos los datos de la tabla excepto el doc_ide
@set dep1 = select id from DepartamentoAcad where name = 'Ciencia de la computacion'
INSERT INTO Docente (doc_dni , doc_nom , doc_ape_mat , doc_ape_pat , doc_grad_aca , dep_aca_ide ) VALUES ();


--Buscar de Docente
-- Busca un docente de la tabla Docentes a partir de su   y retorna todos los datos.

SELECT * FROM doc_dni , doc_nom , doc_ape_mat , doc_ape_pat , doc_grad_aca , dep_aca_ide WHERE doc_dni = $ingresa;

-- Modificar Docente
-- Recibe todos los datos del registro y los modifica en la Base de Datos.

UPDATE Docente SET doc_dni = $post , doc_nom = $post, doc_ape_mat = $post, doc_ape_pat = $post, doc_grad_aca = $post, dep_aca_ide = $post WHERE doc_ide = $s ;

UPDATE Docente SET fechaDelete=now() WHERE id= %s

-- Quitar Docente
-- Elimina un docente de la base de datos.

DELETE FROM Docente Where doc_dni = $post ;


-- Buscar Curso
-- Busca un curso por su cur_cod y retorna sus valores.

SELECT cur_cod , cur_nom , cur_sem , cur_dur , cur_hor_teo , cur_hor_prac , cur_hor_lab , cur_credi , cur_fund WHERE cur_cod = $post ;
-- ALTER TABLE Curso ADD cur_ide INT NOT NULL AUTO_INCREMENT PRIMARY KEY;



-- INSERT INTO Departamento_academico (cur_nom) VALUES (nombre );
-- insertions of departaments_academics 
--INSERT INTO Docente (doc_ide,doc_dni , doc_nom , doc_ape_mat , doc_ape_pat , doc_grad_aca , dep_aca_ide ) VALUES (1,1234,"Luis","Ramos","Montoya","Licenciado",10)
INSERT INTO Curso(cur_ide,cur_cod , cur_nom , cur_sem , cur_dur , cur_hor_teo , cur_hor_prac , cur_hor_lab , cur_credi , cur_fund) VALUES ()

INSERT INTO Departamento_academico (dep_aca_ide,dep_aca_nom) VALUES (1,'Ingeniería Geofísica');
INSERT INTO Departamento_academico (dep_aca_nom) VALUES ('Ingeniería Geológica');
INSERT INTO Departamento_academico (dep_aca_nom) VALUES ('Ingeniería de Minas');

INSERT INTO Departamento_academico (dep_aca_nom) VALUES ('Ingeniería Electrónica');
INSERT INTO Departamento_academico (dep_aca_nom) VALUES ('Ingeniería Industrial');
INSERT INTO Departamento_academico (dep_aca_nom) VALUES ('Ingeniería Mecánica');
INSERT INTO Departamento_academico (dep_aca_nom) VALUES ('Ingeniería Eléctrica');
INSERT INTO Departamento_academico (dep_aca_nom) VALUES ('Ingeniería de Sistemas');
INSERT INTO Departamento_academico (dep_aca_nom) VALUES ('Ciencia de la Computación');
INSERT INTO Departamento_academico (dep_aca_nom) VALUES ('Ingeniería de Telecomunicaciones');

INSERT INTO Departamento_academico (dep_aca_nom) VALUES ('Administración');
INSERT INTO Departamento_academico (dep_aca_nom) VALUES ('Marketing');
INSERT INTO Departamento_academico (dep_aca_nom) VALUES ('Banca y Seguro');
INSERT INTO Departamento_academico (dep_aca_nom) VALUES ('Gestión');

INSERT INTO Departamento_academico (dep_aca_nom) VALUES ('Biología');
INSERT INTO Departamento_academico (dep_aca_nom) VALUES ('Ciencias de la Nutrición');
INSERT INTO Departamento_academico (dep_aca_nom) VALUES ('Ingeniería Pesquera');

INSERT INTO Departamento_academico (dep_aca_nom) VALUES ('Física');
INSERT INTO Departamento_academico (dep_aca_nom) VALUES ('Matemática');
INSERT INTO Departamento_academico (dep_aca_nom) VALUES ('Química');

INSERT INTO Departamento_academico (dep_aca_nom) VALUES ('Ingeniería Civil');
INSERT INTO Departamento_academico (dep_aca_nom) VALUES ('Ingeniería Sanitaria');

INSERT INTO Departamento_academico (dep_aca_nom) VALUES ('Derecho');

INSERT INTO Departamento_academico (dep_aca_nom) VALUES ('Enfermería');

INSERT INTO Departamento_academico (dep_aca_nom) VALUES ('Contabilidad');
INSERT INTO Departamento_academico (dep_aca_nom) VALUES ('Finanzas');

INSERT INTO Departamento_academico (dep_aca_nom) VALUES ('Educación');

INSERT INTO Departamento_academico (dep_aca_nom) VALUES ('Ingeniería Metalúrgica');
INSERT INTO Departamento_academico (dep_aca_nom) VALUES ('Ingeniería Química');
INSERT INTO Departamento_academico (dep_aca_nom) VALUES ('Ingeniería de Industria Alimentaria');
INSERT INTO Departamento_academico (dep_aca_nom) VALUES ('Ingeniería de Materiales');
INSERT INTO Departamento_academico (dep_aca_nom) VALUES ('Ingeniería Ambiental');

INSERT INTO Departamento_academico (dep_aca_nom) VALUES ('Medicina');

INSERT INTO Departamento_academico (dep_aca_nom) VALUES ('Psicología');
INSERT INTO Departamento_academico (dep_aca_nom) VALUES ('Relaciones Industriales');
INSERT INTO Departamento_academico (dep_aca_nom) VALUES ('Ciencias de la Comunicación');

INSERT INTO Departamento_academico (dep_aca_nom) VALUES ('Artes con mención en música');
INSERT INTO Departamento_academico (dep_aca_nom) VALUES ('Artes con mención en plásticas');
INSERT INTO Departamento_academico (dep_aca_nom) VALUES ('Filosofía');
INSERT INTO Departamento_academico (dep_aca_nom) VALUES ('Literatura y Lingüística');

INSERT INTO Departamento_academico (dep_aca_nom) VALUES ('Agronomía');
INSERT INTO Departamento_academico (dep_aca_nom) VALUES ('Arquitectura');

INSERT INTO Departamento_academico (dep_aca_nom) VALUES ('Historia');
INSERT INTO Departamento_academico (dep_aca_nom) VALUES ('Sociología');
INSERT INTO Departamento_academico (dep_aca_nom) VALUES ('Trabajo Social');
INSERT INTO Departamento_academico (dep_aca_nom) VALUES ('Antropología');
INSERT INTO Departamento_academico (dep_aca_nom) VALUES ('Turismo y Hotelería');

INSERT INTO Departamento_academico (dep_aca_nom) VALUES ('Economía');