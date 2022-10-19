package mx.com.gm.servicio;

import mx.com.gm.domain.Estudiante;

import java.util.List;

public interface EstudianteService {

    public List<Estudiante> listarEstudiantes();

    public Estudiante guardar(Estudiante estudiante);

    public void eliminar(Estudiante estudiante);

    public Estudiante encontrarEstudiante(Estudiante estudiante);
}
