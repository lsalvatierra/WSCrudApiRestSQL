package edu.pe.idat.repository;

import org.springframework.stereotype.Repository;

import edu.pe.idat.model.Curso;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CursoRepository  extends JpaRepository<Curso, Long> {
	//Una clase de repositorio contendrá los métodos para 
	//realizar operaciones de base de datos.
}
