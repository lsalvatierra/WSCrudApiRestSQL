package edu.pe.idat.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
/*
 * MANEJAR LAS EXCEPCIONES
 * La anotación @ControllerAdvice aparece en la versión 3.2 de Spring 
 * y consiste en una especialización de la anotación @Component 
 * que permite declarar métodos relacionados con el manejo de excepciones 
 * que serán compartidos entre múltiples controladores, 
 * evitando así la duplicidad de código o la generación de jerarquías 
 * para que los controladores traten de manera homogénea las excepciones.
 * */
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		DetalleError errorDetails = new DetalleError(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
		DetalleError errorDetails = new DetalleError(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
