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
<title>Lista de Alumnos</title>
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
						<b>Listar Alumnos</b>
					</div>
					<div align="right">
						<a href="home"><input type="button" id="listarAlumno"
							class="btn btn-primary" value="Home" /></a>
					</div>
					<div align="right">
						<a href="anadirAlumno">A&ntilde;adir nuevo alumno</a>
					</div>
				</h3>
			</div>
			<div class="panel-body">
				<c:if test="${empty listaDeAlumnos}">
                No se encuentran alumnos regsitrados
            </c:if>
				<c:if test="${not empty listaDeAlumnos}">

					<form action="buscarAlumno">
						<div class="row">
							<div class="col-md-4">
								Buscar Alumno: <input type='text' name='nombreBusqueda'
									id='nombreBusqueda' />
							</div>
							<div class="col-md-4">
								<input class="btn btn-success" type='submit' value='Buscar' />
							</div>
						</div>
					</form>

					<table class="table table-hover table-bordered">
						<thead style="background-color: #bce8f1;">
							<tr>
								<th>Legajo</th>
								<th>Nombre</th>
								<th>Apellido</th>
								<th>Carrera</th>
								<th>Editar</th>
								<th>Eliminar</th>
								<th>Ver Cursos Asignados</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listaDeAlumnos}" var="alum">
								<tr>
									<th><c:out value="${alum.legajo}" /></th>
									<th><c:out value="${alum.nombre}" /></th>
									<th><c:out value="${alum.apellido}" /></th>
									<th><c:out value="${alum.carrera}" /></th>
									<th><a
										href="actualizarAlumno?legajo=<c:out value='${alum.legajo}'/>">Editar</a></th>
									<th><a
										href="eliminarAlumno?legajo=<c:out value='${alum.legajo}'/>">Eliminar</a></th>
									<th><a
										href="pantallaCursoAlumno?legajo=<c:out value='${alum.legajo}'/>">Mis
											Cursos</a></th>
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