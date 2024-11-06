package br.edu.ifsc.fln.domain;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
//@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(of = {"id"})
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@EqualsAndHashCode.Include
	private int id;
	
	private String descricao;
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getDescricao() {
//		return descricao;
//	}
//	public void setDescricao(String descricao) {
//		this.descricao = descricao;
//	}
//	@Override
//	public int hashCode() {
//		return Objects.hash(id);
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Categoria other = (Categoria) obj;
//		return id == other.id;
//	}
//	
	
}
