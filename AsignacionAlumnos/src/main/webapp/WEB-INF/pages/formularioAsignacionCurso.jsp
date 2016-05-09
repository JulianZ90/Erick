<%--
  User: Erik Alvarez
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
<title>Cursos</title>
<script src="<c:url value="/resources/js/funciones.js" />"></script>
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
						<b>Cursos del Alumno</b>
					</div>
					<div align="right">
						<a href="home"><input type="button" id="listarAlumno"
							class="btn btn-primary" value="Home" /></a>
					</div>
				</h3>
			</div>
			<div class="panel-body">
				<table class="table table-hover table-bordered">
					<thead style="background-color: #bce8f1;">
						<tr>
							<th>N&uacute;mero</th>
							<th>Nombre</th>
							<th>Descripci&oacute;n</th>
							<th>Capacidad</th>
						</tr>
					</thead>
					</thead>
					<tbody>
						<tr>
							<th><c:out value="${mapaObjetos.curso.nroCurso}" /></th>
							<th><c:out value="${mapaObjetos.curso.nombreCurso}" /></th>
							<th><c:out value="${mapaObjetos.curso.descripcionCurso}" /></th>
							<th><c:out value="${mapaObjetos.curso.capacidad}" /></th>
						</tr>
					</tbody>
				</table>
				<h2 class="panel-title">
					<strong>Alumnos Asignados al Curso</strong>
				</h2>
				<table class="table table-hover table-bordered">
					<thead style="background-color: #bce8f1;">
						<tr>
							<th>Legajo</th>
							<th>Nombre</th>
							<th>Apellido</th>
							<th>Carrera</th>
							<th>Desasignar</th>
						</tr>
					</thead>
					<c:if test="${empty mapaObjetos.listaDeAlumnosAsignados}">
						<tbody>
							<tr>
								<th colspan=5><h4>Este Curso no tiene asignado a
										ning&uacute;n alumno</h4></th>
							</tr>
						</tbody>
					</c:if>
					<c:if test="${not empty mapaObjetos.listaDeAlumnosAsignados}">

						<tbody>
							<c:forEach items="${mapaObjetos.listaDeAlumnosAsignados}"
								var="alumAsig">
								<tr>
									<th><c:out value="${alumAsig.legajo}" /></th>
									<th><c:out value="${alumAsig.nombre}" /></th>
									<th><c:out value="${alumAsig.apellido}" /></th>
									<th><c:out value="${alumAsig.carrera}" /></th>
									<th><a
										href="desAsignarAlumnoDelCurso?nroCurso=<c:out value='${mapaObjetos.curso.nroCurso}'/>
										&legajo=<c:out value='${alumAsig.legajo}'/>">
										<div class="btn btn-danger btn-block" style="color: #FFF">
												<strong>-</strong>
											</div>
											</a>
									</th>
								</tr>
							</c:forEach>
						</tbody>
					</c:if>
				</table>
				<h2 class="panel-title">
					<strong>Todos los Alumnos</strong>
				</h2>
				<table class="table table-hover table-bordered">
					<thead style="background-color: #bce8f1;">
						<tr>
							<th>Legajo</th>
							<th>Nombre</th>
							<th>Apellido</th>
							<th>Carrera</th>
							<th>Asignar</th>
						</tr>
					</thead>
					<c:if test="${empty mapaObjetos.listaDeAlumnosSinAsignar}">
						<tbody>
							<tr>
								<th colspan=5><h4>Este curso no tiene alumno</h4></th>
							</tr>
						</tbody>
					</c:if>
					<c:if test="${not empty mapaObjetos.listaDeAlumnosSinAsignar}">
						<tbody>
							<c:forEach items="${mapaObjetos.listaDeAlumnosSinAsignar}"
								var="alum">
								<tr>
									<th><c:out value="${alum.legajo}" /></th>
									<th><c:out value="${alum.nombre}" /></th>
									<th><c:out value="${alum.apellido}" /></th>
									<th><c:out value="${alum.carrera}" /></th>
									<th><a
										href="asignarAlumnoAlCurso?nroCurso=<c:out value='${mapaObjetos.curso.nroCurso}'/>
										&legajo=<c:out value='${alum.legajo}'/>"><div
												class="btn btn-success btn-block" style="color: #FFF">
												<strong>+</strong>
											</div></a></th>
								</tr>
							</c:forEach>
						</tbody>
					</c:if>
				</table>

			</div>
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