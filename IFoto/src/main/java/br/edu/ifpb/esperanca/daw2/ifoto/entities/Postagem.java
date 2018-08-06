package br.edu.ifpb.esperanca.daw2.ifoto.entities;

import java.awt.Image;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Postagem implements Identificavel {

	@Id
	@GeneratedValue(generator="postagem_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="postagem_seq")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	
	@Lob
	private byte[] conteudo;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHora;
	
	@ManyToMany
	@JoinTable(name="comentario_rotulo", joinColumns=@JoinColumn(name="id_comentario"), inverseJoinColumns=@JoinColumn(name="id_rotulo"))
	private Set<Rotulo> rotulos;
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public byte[] getConteudo() {
		return conteudo;
	}
	public void setConteudo(byte[] conteudo) {
		this.conteudo = conteudo;
	}
	public Date getDataHora() {
		return dataHora;
	}
	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
	public Set<Rotulo> getRotulos() {
		return rotulos;
	}
	public void setRotulos(Set<Rotulo> rotulos) {
		this.rotulos = rotulos;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	
}
