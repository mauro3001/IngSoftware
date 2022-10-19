package mx.com.gm.dao;

import mx.com.gm.domain.Estudiante;
import org.springframework.data.repository.CrudRepository;

public interface EstudianteDao extends CrudRepository<Estudiante, Long> {

}
