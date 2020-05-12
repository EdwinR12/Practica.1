package com.Edwin.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the logueo database table.
 * 
 */
@Entity
@NamedQuery(name="Logueo.findAll", query="SELECT l FROM Logueo l")
public class Logueo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idlogueo;

	private String apellidos_Usuario;

	private String corre_Usuario;

	private String nombres_Usuario;

	private String password;

	private String usuario;

	//bi-directional many-to-one association to TbHistorial
	@OneToMany(mappedBy="logueo")
	private List<TbHistorial> tbHistorials;

	public Logueo() {
	}

	public int getIdlogueo() {
		return this.idlogueo;
	}

	public void setIdlogueo(int idlogueo) {
		this.idlogueo = idlogueo;
	}

	public String getApellidos_Usuario() {
		return this.apellidos_Usuario;
	}

	public void setApellidos_Usuario(String apellidos_Usuario) {
		this.apellidos_Usuario = apellidos_Usuario;
	}

	public String getCorre_Usuario() {
		return this.corre_Usuario;
	}

	public void setCorre_Usuario(String corre_Usuario) {
		this.corre_Usuario = corre_Usuario;
	}

	public String getNombres_Usuario() {
		return this.nombres_Usuario;
	}

	public void setNombres_Usuario(String nombres_Usuario) {
		this.nombres_Usuario = nombres_Usuario;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public List<TbHistorial> getTbHistorials() {
		return this.tbHistorials;
	}

	public void setTbHistorials(List<TbHistorial> tbHistorials) {
		this.tbHistorials = tbHistorials;
	}

	public TbHistorial addTbHistorial(TbHistorial tbHistorial) {
		getTbHistorials().add(tbHistorial);
		tbHistorial.setLogueo(this);

		return tbHistorial;
	}

	public TbHistorial removeTbHistorial(TbHistorial tbHistorial) {
		getTbHistorials().remove(tbHistorial);
		tbHistorial.setLogueo(null);

		return tbHistorial;
	}

}