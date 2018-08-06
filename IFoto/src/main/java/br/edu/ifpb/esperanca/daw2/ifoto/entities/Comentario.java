package br.edu.ifpb.esperanca.daw2.ifoto.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Comentario implements Identificavel{
	
	@Id
	@GeneratedValue(generator="comentario_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="comentario_seq")
	private Long id; 
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHora;
	private String texto;
	
	@ManyToMany
	@JoinTable(name="comentario_rotulo", joinColumns=@JoinColumn(name="id_comentario"), inverseJoinColumns=@JoinColumn(name="id_rotulo"))
	private Set<Rotulo> rotulos;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDataHora() {
		return dataHora;
	}
	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Set<Rotulo> getRotulos() {
		return rotulos;
	}
	public void setRotulos(Set<Rotulo> rotulos) {
		this.rotulos = rotulos;
	}
	
	
}
