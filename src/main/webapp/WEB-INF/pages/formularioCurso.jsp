<%--
  User: Ranga Reddy
  Date: 1/27/2015
  Time: 9:48 PM
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="Ranga Reddy">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Informaci&oacute;n del Curso</title>
    <script src="<c:url value="/resources/js/funciones.js" />"></script>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <style type="text/css">
        .myrow-container{
            margin: 20px;
        }
    </style>
</head>
<body class=".container-fluid">
    <div class="container myrow-container">
        <div class="panel panel-success">
            <div class="panel-heading">
                <h3 class="panel-title">
                    <div align="left">Detalles del Curso</div>
                    <div align="right"><a href="home" ><input type="button" id="listarAlumno" class="btn btn-primary" value="Home"/></a></div>
                </h3>
            </div>
            <div class="panel-body">
                <form:form id="formularioRegsitroCurso" cssClass="form-horizontal" modelAttribute="curso" method="post" action="guardarCurso">
    
                    <div class="form-group">
                        <div class="control-label col-xs-3"> <form:label path="nombreCurso" >Nombre del Curso</form:label> </div>
                        <div class="col-xs-6">
                            <form:hidden path="nroCurso" value="${objetoCurso.nroCurso}"/>
                            <form:input cssClass="form-control" path="nombreCurso" value="${objetoCurso.nombreCurso}"/>
                        </div>
                    </div>
    
                    <div class="form-group">
                        <form:label path="descripcionCurso" cssClass="control-label col-xs-3">Descripci&oacute;n</form:label>
                        <div class="col-xs-6">
                            <form:input cssClass="form-control" path="descripcionCurso" value="${objetoCurso.descripcionCurso}"/>
                        </div>
                    </div>
    
                    <div class="form-group">
                        <div class="control-label col-xs-3"><form:label path="capacidad">Capacidad</form:label></div>
                        <div class="col-xs-6">
                            <form:input cssClass="form-control" path="capacidad" value="${objetoCurso.capacidad}"/>
                        </div>
                    </div>
    
                    <div class="form-group">
                        <div class="row">
                            <div class="col-xs-4">
                            </div>
                            <div class="col-xs-4">
                                <input type="submit" id="guardarCurso" class="btn btn-primary" value="Guardar" onclick="return submitFormularioCurso();"/>
                            </div>
                            <div class="col-xs-4">
                            </div>
                        </div>
                    </div>
    
                </form:form>
            </div>
        </div>
    </div>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	
	<script type="text/javascript">
		function submitFormularioCurso() {				
			
		    // consigue los valores del curso del formulario
		    var nombre = $('#nombreCurso').val().trim();
		    var descripcion = $('#descripcionCurso').val().trim();
		    var capacidad = $('#capacidad').val();
		    
		    if(nombre.length ==0) {
		        alert('Por favor entre el nombre del curso');
		        $('#nombre').focus();
		        return false;
		    }
		    if(isNaN(capacidad)||capacidad <= 0) {
		        alert('Por favor entre un valor correecto para la capacidad del curso');
		        $('#capacidad').focus();
		        return false;
		    }
		    return true;
		};	
	</script>

</body>
</html>