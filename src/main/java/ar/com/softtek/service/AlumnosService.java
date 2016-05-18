package ar.com.softtek.service;

import ar.com.softtek.beans.Alumno;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface AlumnosService {
    @WebMethod
    List<Alumno> getAlumnos();
    @WebMethod
    Alumno saveAlumno(String nombre, String apellido);
    @WebMethod
    List<Alumno> getAlumnosByName(String nombre);
    @WebMethod
    void deleteAlumno(String nombre);
}
