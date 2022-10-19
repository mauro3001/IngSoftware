package mx.com.gm.servicio;

import mx.com.gm.dao.EstudianteDao;
import mx.com.gm.domain.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EstudianteServiceImpl implements EstudianteService{

    @Autowired
    private EstudianteDao estudianteDao;

    @Override
    @Transactional(readOnly = true)
    public List<Estudiante> listarEstudiantes() {
        return (List<Estudiante>) estudianteDao.findAll();
    }

    @Override
    public Estudiante guardar(Estudiante estudiante) {
        estudianteDao.save(estudiante);
        return estudiante;
    }

    @Override
    public void eliminar(Estudiante estudiante) {
        estudianteDao.delete(estudiante);
    }

    @Override
    public Estudiante encontrarEstudiante(Estudiante estudiante) {
        return estudianteDao.findById(estudiante.getIdEstudiante()).orElse(null);
    }
}
