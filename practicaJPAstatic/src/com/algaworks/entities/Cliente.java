package com.algaworks.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Cliente {
	
	@Id
	@Column(name="CODIGO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "CLIENTE_SEQ")
	@SequenceGenerator(name = "CLIENTE_SEQ", sequenceName = "CLIENTE_SEQ", allocationSize=1)
	private int codigo;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="EDAD")
	private Integer edad;
	
	@Column(name="SEXO")
	private String sexo;
	
	@Column(name="PROFESION")
	private String profesion;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getProfesion() {
		return profesion;
	}
	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	
	
}
