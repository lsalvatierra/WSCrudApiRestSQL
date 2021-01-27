package edu.pe.idat.exception;

import java.util.Date;

public class DetalleError {
	private Date fechaerror;
	private String mensaje;
	private String detalle;
	public Date getFechaerror() {
		return fechaerror;
	}
	public String getMensaje() {
		return mensaje;
	}
	public String getDetalle() {
		return detalle;
	}
	public DetalleError(Date fechaerror, String mensaje, String detalle) {
		super();
		this.fechaerror = fechaerror;
		this.mensaje = mensaje;
		this.detalle = detalle;
	}
	
	

}
