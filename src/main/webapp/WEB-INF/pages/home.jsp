<%--
  User: Ranga Reddy
  Date: 1/27/2015
  Time: 9:52 PM
  --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Lista de Alumnos</title>
	<script src="<c:url value="/js/funciones.js" />"></script>    <!-- Bootstrap CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <style type="text/css">
        .myrow-container {
            margin: 20px;
        }
    </style>
</head>
<body class=".container-fluid">
<div class="container myrow-container">
    <div class="panel panel-success">
        <div class="panel-heading">
            <h3 class="panel-title">
                <div align="left"><b>Asignaci&oacute;n de Alumnos</b> </div>
                <div align="right"><a href="anadirAlumno" >A&ntilde;adir nuevo alumno</a></div>
            	<div align="right"><a href="anadirCurso">A&ntilde;adir nuevo curso</a></div>
            </h3>
        </div>
        <div class="panel-body">
            	<form action="buscarAlumno">
            		<div class="row">
					  <div class="col-md-4">Buscar Alumno:<input type='text' name='nombreBusqueda' id='nombreBusqueda'/> </div>
					  <div class="col-md-4"><input id="busquedaAlumnoInput" class="btn btn-success" type='submit' value='Buscar' onclick="return comprobarBusquedaAlumno();"/></div>
					  <a href="getAllAlumnos"><input type="button" id="listarAlumno" class="btn btn-primary" value="Listar Alumnos"/></a>
					</div>
            	</form>  
            	<form action="buscarCurso">
            		<div class="row">
					  <div class="col-md-4">Buscar Cursos:&nbsp;<input type='text' name='nombreCursoBusqueda' id='nombreCursoBusqueda'/> </div>
					  <div class="col-md-4"><input class="btn btn-success" type='submit' value='Buscar' onclick="return comprobarBusquedaCurso();"/></div>
					  <a href="getAllCursos"><input type="button" id="listarCursos" class="btn btn-primary" value=" Listar Cursos "/></a>
					</div>
            	</form>           	

        </div>
    </div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>    
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    
    <%-- <script src="<c:url value="/resources/js/jquery-2.1.3.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
     --%>

</body>
</html>