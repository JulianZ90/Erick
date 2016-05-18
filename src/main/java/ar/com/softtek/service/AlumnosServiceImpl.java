package ar.com.softtek.service;

import ar.com.softtek.beans.Alumno;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService
public class AlumnosServiceImpl implements AlumnosService {

    private List<Alumno> alumnos = new ArrayList<Alumno>();

    public List<Alumno> getAlumnos(){
        return alumnos;
    }

    public List<Alumno> getAlumnosByName(@WebParam(name="nombre",partName = "nombre")String nombre){
        List<Alumno> result = new ArrayList<Alumno>();
        for (Alumno alumno:alumnos) {
            if(alumno.getNombre().equals(nombre))
                result.add(alumno);
        }
        return result;
    }

    public Alumno saveAlumno(@WebParam(name="nombre")String nombre, @WebParam(name="apellido") String apellido){
        Alumno alumno = new Alumno();
        alumno.setNombre(nombre);
        alumno.setApellido(apellido);
        alumnos.add(alumno);
        return alumno;
    }
}
