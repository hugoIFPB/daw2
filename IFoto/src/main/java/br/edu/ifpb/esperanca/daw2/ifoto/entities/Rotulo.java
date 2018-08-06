package br.edu.ifpb.esperanca.daw2.ifoto.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Rotulo implements Identificavel {

	@Id
	@GeneratedValue(generator="rotulo_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="rotulo_seq")
	private Long id;
	
	private String valor;
	
	public String getValor() {
		return valor;
	}
	
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
}
