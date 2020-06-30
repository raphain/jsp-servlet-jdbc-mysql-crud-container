package net.javaguides.usermanagement.model;

import java.sql.Date;
public class Movimentacao {
	
	private int idmovimentacao;
	private String navio;
	private String tipo_mov;
	private Date dt_inicio;
	private Date dt_fim;
	
	
	
	
	
	public Movimentacao(String navio,String tipo_mov, Date dt_inicio, Date dt_fim) {
		super();
		this.navio = navio;
		this.tipo_mov = tipo_mov;
		this.dt_inicio = dt_inicio;
		this.dt_fim = dt_fim;
	}
	public Movimentacao() {
		super();
	}
	public Movimentacao(int idmovimentacao, String navio, String tipo_mov, Date dt_inicio, Date dt_fim) {
		super();
		this.idmovimentacao = idmovimentacao;
		this.navio = navio;
		this.tipo_mov = tipo_mov;
		this.dt_inicio = dt_inicio;
		this.dt_fim = dt_fim;
	}
	
	
	public String getNavio() {
		return navio;
	}
	public void setNavio(String navio) {
		this.navio = navio;
	}
	public int getIdmovimentacao() {
		return idmovimentacao;
	}
	public void setIdmovimentacao(int idmovimentacao) {
		this.idmovimentacao = idmovimentacao;
	}
	public String getTipo_mov() {
		return tipo_mov;
	}
	public void setTipo_mov(String tipo_mov) {
		this.tipo_mov = tipo_mov;
	}
	public Date getDt_inicio() {
		return dt_inicio;
	}
	public void setDt_inicio(Date dt_inicio) {
		this.dt_inicio = dt_inicio;
	}
	public Date getDt_fim() {
		return dt_fim;
	}
	public void setDt_fim(Date dt_fim) {
		this.dt_fim = dt_fim;
	}
	
	
	

}
