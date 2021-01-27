package edu.pe.idat.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pe.idat.exception.ResourceNotFoundException;
import edu.pe.idat.model.Curso;
import edu.pe.idat.repository.CursoRepository;


@RestController
@RequestMapping("/api/v1")
public class CursoController {
	// El contenedor Spring (contexto de aplicación) administrará 
	// automáticamente el proceso de creación de instancias y objetos por nosotros. 
	@Autowired
	private CursoRepository cursoRepository;

	@GetMapping("/obtenerTodosCursos")
	public List<Curso> obtenerTodosCursos() {
		return cursoRepository.findAll();
	}

    @PutMapping("/crearCurso")
    public Curso crearCurso(@Valid @RequestBody Curso curso) {
        return cursoRepository.save(curso);
    }

    @GetMapping("/obtenerCurso/{id}")
    public ResponseEntity<Curso> obtenerCursoPorId(@PathVariable(value = "id") long idCurso)
        throws ResourceNotFoundException {
        Curso employee = cursoRepository.findById(idCurso)
        		.orElseThrow(() -> new ResourceNotFoundException("Curso not found for this id :: " + idCurso));
        return ResponseEntity.ok().body(employee);
    }
    

    
    @DeleteMapping("/eliminarCurso/{id}")
    public Map<String, Boolean> eliminarCurso(@PathVariable(value = "id") long idCurso)
         throws ResourceNotFoundException {
        Curso curso = cursoRepository.findById(idCurso)
        		.orElseThrow(() -> new ResourceNotFoundException("Curso not found for this id :: " + idCurso));
        cursoRepository.delete(curso);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
	
}
