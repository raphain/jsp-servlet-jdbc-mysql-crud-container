package net.javaguides.usermanagement.model;

public class Container {
	private int idcontainer;
	private String cliente;
	private String numero;
	private String tipo;
	private String status;
	private String categoria;
	
	
	
	public Container() {
		super();
	}



	public Container(int idcontainer, String cliente, String numero, String tipo, String status, String categoria) {
		super();
		this.idcontainer = idcontainer;
		this.cliente = cliente;
		this.numero = numero;
		this.tipo = tipo;
		this.status = status;
		this.categoria = categoria;
	}
	
	
	
	public Container(String cliente, String numero, String tipo, String status, String categoria) {
		super();
		this.cliente = cliente;
		this.numero = numero;
		this.tipo = tipo;
		this.status = status;
		this.categoria = categoria;
	}



	public int getIdcontainer() {
		return idcontainer;
	}



	public void setIdcontainer(int idcontainer) {
		this.idcontainer = idcontainer;
	}



	public String getCliente() {
		return cliente;
	}



	public void setCliente(String cliente) {
		this.cliente = cliente;
	}



	public String getNumero() {
		return numero;
	}



	public void setNumero(String numero) {
		this.numero = numero;
	}



	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getCategoria() {
		return categoria;
	}



	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}



	
	
	
	
}
