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
    <title>Informaci&oacute;n del Alumno</title>
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
                    <div align="left">Detalles del alumno</div>
                    <div align="right"><a href="home" ><input type="button" id="listarAlumno" class="btn btn-primary" value="Home"/></a></div>
                </h3>
            </div>
            <div class="panel-body">
                <form:form id="formularioRegsitroAlumno" cssClass="form-horizontal" modelAttribute="alumno" method="post" action="guardarAlumno">
    
                    <div class="form-group">
                        <div class="control-label col-xs-3"> <form:label path="nombre" >Nombre</form:label> </div>
                        <div class="col-xs-6">
                            <form:hidden path="legajo" value="${objetoAlumno.legajo}"/>
                            <form:input cssClass="form-control" path="nombre" value="${objetoAlumno.nombre}"/>
                        </div>
                    </div>
    
                    <div class="form-group">
                        <form:label path="apellido" cssClass="control-label col-xs-3">Apellido</form:label>
                        <div class="col-xs-6">
                            <form:input cssClass="form-control" path="apellido" value="${objetoAlumno.apellido}"/>
                        </div>
                    </div>
    
                    <div class="form-group">
                        <div class="control-label col-xs-3"><form:label path="carrera">Carrera</form:label></div>
                        <div class="col-xs-6">
                            <form:input cssClass="form-control" path="carrera" value="${objetoAlumno.carrera}"/>
                        </div>
                    </div>
    
                    <div class="form-group">
                        <div class="row">
                            <div class="col-xs-4">
                            </div>
                            <div class="col-xs-4">
                                <input type="submit" id="guardarAlumno" class="btn btn-primary" value="Guardar" onclick="return submitFormularioAlumno();"/>
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
		function submitFormularioAlumno() {				
			
		    // consigue los valores del alumno del formulario
		    var nombre = $('#nombre').val().trim();
		    var apellido = $('#apellido').val().trim();
		    var carrera = $('#carrera').val().trim();
		    
		    if(nombre.length ==0) {
		        alert('Por favor entre el nombre del alumno');
		        $('#nombre').focus();
		        return false;
		    }
		    if(apellido.length ==0) {
		        alert('Por favor entre el apellido del alumno');
		        $('#apellido').focus();
		        return false;
		    }
		    if(carrera.length ==0) {
		        alert('Por favor entre la carrera del alumno');
		        $('#carrera').focus();
		        return false;
		    }
		    return true;
		};	
	</script>

</body>
</html>