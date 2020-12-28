from app import app
from flask import request
from flask import jsonify
from flaskext.mysql import MySQL
from app.modelos.Model import Model

model=Model(app)




@app.route('/getsilabos', methods=['GET'])
def get_silabos():
    return model.getSilabos()

@app.route('/addDocente', methods=['POST'])
def Add_docentes ():
    return model.addDocente()

@app.route('/searchDocente/<dni>', methods=['GET'])
def Search_docentes (dni):
    return model.searchDocente(dni)


@app.route('/deleteDocente/<dni>', methods=['GET'])
def DeleteDocentes (dni):
    return model.deleteDocente(dni)

@app.route('/updateDocente', methods=['POST'])
def UpdateDocentes ():
    return model.updateDocente()

@app.route('/searchCurs/<cod>', methods=['GET'])
def SearchCurso (cod):
    return model.searchCurs(cod)