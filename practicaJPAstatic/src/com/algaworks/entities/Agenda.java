package com.algaworks.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Agenda {
	
	@Id
	@Column(name="CODIGO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "AGENDA_SEQ")
	@SequenceGenerator(name = "AGENDA_SEQ", sequenceName = "AGENDA_SEQ", allocationSize=1)
	private int codigo;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="TELEFONO")
	private String telefono;
	
	@Column(name="FECHA_REGISTRO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRegistro;

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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
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
		Agenda other = (Agenda) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	
	
}
