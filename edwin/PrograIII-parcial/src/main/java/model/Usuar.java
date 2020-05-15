package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuar database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuar u")
public class Usuar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String contrasenia;

	private String nombre;

	public Usuar() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContrasenia() {
		return this.contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}