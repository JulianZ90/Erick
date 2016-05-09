
		function comprobarBusquedaAlumno() {				
			
		    var nombre = $('#busquedaAlumnoInput').val().trim();
		   
		    
		    if(nombre.length ==0) {
		        alert('Por favor ingrse un nombre de alumno para hacer la busqueda');
		        $('#busquedaAlumnoInput').focus();
		        return false;
		    }
		    return true;
		};	