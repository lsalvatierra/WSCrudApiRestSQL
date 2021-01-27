package edu.pe.idat.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception {
/*
 * Spring Boot proporciona una buena implementación predeterminada 
 * para el manejo de excepciones para servicios RESTful. 
 * Veamos rápidamente las funciones predeterminadas de manejo de 
 * excepciones proporcionadas por Spring Boot.
 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String message){
    	super(message);
    }
}
