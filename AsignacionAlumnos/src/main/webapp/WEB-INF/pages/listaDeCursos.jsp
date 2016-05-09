<%--
  User: Ranga Reddy
  Date: 1/27/2015
  Time: 9:52 PM
  --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Cursos</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
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
					<div align="left">
						<b>Listar Cursos</b>
					</div>
					<div align="right">
						<a href="home"><input type="button" id="listarAlumno"
							class="btn btn-primary" value="Home" /></a>
					</div>
					<div align="right">
						<a href="anadirCurso">A&ntilde;adir nuevo curso</a>
					</div>
				</h3>
			</div>
			<div class="panel-body">
				<c:if test="${empty listaDeCursos}">
                No se encuentran cursos regsitrados
            </c:if>
				<c:if test="${not empty listaDeCursos}">

					<form action="buscarCurso">
						<div class="row">
							<div class="col-md-4">
								Buscar Curso: <input type='text' name='nombreCursoBusqueda'
									id='nombreCursoBusqueda' />
							</div>
							<div class="col-md-4">
								<input class="btn btn-success" type='submit' value='Buscar' />
							</div>
						</div>
					</form>

					<table class="table table-hover table-bordered">
						<thead style="background-color: #bce8f1;">
							<tr>
								<th>N&uacute;mero</th>
								<th>Nombre</th>
								<th>Descripci&oacute;n</th>
								<th>Capacidad</th>
								<th>Editar</th>
								<th>Eliminar</th>
								<th>Ver Alumnos  Inscriptos</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listaDeCursos}" var="cur">
								<tr>
									<th><c:out value="${cur.nroCurso}" /></th>
									<th><c:out value="${cur.nombreCurso}" /></th>
									<th><c:out value="${cur.descripcionCurso}" /></th>
									<th><c:out value="${cur.capacidad}" /></th>
									<th><a
										href="actualizarCurso?nroCurso=<c:out value='${cur.nroCurso}'/>">Editar</a></th>
									<th><a
										href="eliminarCurso?nroCurso=<c:out value='${cur.nroCurso}'/>">Eliminar</a></th>
									<th><a
										href="pantallaAlumnosEnCursos?nroCurso=<c:out value='${cur.nroCurso}'/>">Alumnos inscriptos</a></th>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>
			</div>
		</div>
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
		<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

		<%-- <script src="<c:url value="/resources/js/jquery-2.1.3.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
     --%>
</body>
</html>