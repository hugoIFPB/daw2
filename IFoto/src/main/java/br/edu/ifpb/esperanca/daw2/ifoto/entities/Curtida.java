package br.edu.ifpb.esperanca.daw2.ifoto.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Curtida implements Identificavel{

	@Id
	@GeneratedValue(generator="curtida_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="curtida_seq")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="id_postagem")
	private Postagem curtida;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	
	public Postagem getCurtida() {
		return curtida;
	}
	public void setCurtida(Postagem curtida) {
		this.curtida = curtida;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
}
