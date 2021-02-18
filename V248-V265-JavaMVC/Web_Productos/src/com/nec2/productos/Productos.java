package com.nec2.productos;



public class Productos {
	
	public Productos(String codArt, String seccion, String numArt, String precio, String fecha, String importado, String paisOrigen) {
		
		this.codArt = codArt;
		this.seccion = seccion;
		this.numArt = numArt;
		this.precio = precio;
		this.fecha = fecha;
		this.paisOrigen = paisOrigen;
	}

	public Productos(String seccion, String numArt, String precio, String fecha, String importado, String paisOrigen) {

		this.seccion = seccion;
		this.numArt = numArt;
		this.precio = precio;
		this.fecha = fecha;
		this.importado=importado;
		this.paisOrigen = paisOrigen;
	}


	public String getCodArt() {
		return codArt;
	}

	public void setCodArt(String codArt) {
		this.codArt = codArt;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public String getNumArt() {
		return numArt;
	}

	public void setNumArt(String numArt) {
		this.numArt = numArt;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public String getImportado() {
		return importado;
	}

	public void setImportado(String importado) {
		this.importado = importado;
	}

	public String getPaisOrigen() {
		return paisOrigen;
	}

	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}
	
	

	@Override
	public String toString() {
		return "Productos [codArt=" + codArt + ", seccion=" + seccion + ", numArt=" + numArt + ", precio=" + precio
				+ ", fecha=" + fecha + ", paisOrigen=" + paisOrigen + "]";
	}

	private String codArt;
	
	private String seccion;
	
	private String numArt;
	
	private String precio;
	
	private String fecha;
	
	private String importado;
	
	private String paisOrigen;

}
