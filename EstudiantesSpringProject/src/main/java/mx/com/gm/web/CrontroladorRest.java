package mx.com.gm.web;


import mx.com.gm.domain.Estudiante;
import mx.com.gm.servicio.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/estudiantes")
public class CrontroladorRest {

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping(value = "/lista")
    public List<Estudiante> listarEstudiantes(){
        return estudianteService.listarEstudiantes();
    }

    @PostMapping(value = "/guardar")
    public ResponseEntity<Estudiante> guardar(@RequestBody Estudiante estudiante){
        Estudiante obj = estudianteService.guardar(estudiante);
        return new ResponseEntity<Estudiante>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/encontrar/{idEstudiante}")
    public Estudiante encontrarEstudiante(@PathVariable Estudiante idEstudiante){
        return estudianteService.encontrarEstudiante(idEstudiante);
    }
    @GetMapping(value = "/eliminar/{idEstudiante}")
    public ResponseEntity<Estudiante> eliminar(@PathVariable Estudiante idEstudiante){
        Estudiante estudiante = estudianteService.encontrarEstudiante(idEstudiante);
        if(estudiante != null){
            estudianteService.eliminar(idEstudiante);
        }else {
            return new ResponseEntity<Estudiante>(estudiante, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<Estudiante>(estudiante, HttpStatus.OK);
    }


}
