package com.ejb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the publicaciones database table.
 * 
 */
@Entity
@NamedQuery(name="Publicaciones.findAll", query="SELECT p FROM Publicaciones p")
public class Publicaciones implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String anio;

	private String editorial;

	@Column(name="tipo_publicacion")
	private String tipoPublicacion;

	private String titulo;

	//bi-directional many-to-one association to Datos_informativos
	@OneToMany(mappedBy="publicacione")
	private List<Datos_informativos> datosInformativos;

	public Publicaciones() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAnio() {
		return this.anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getEditorial() {
		return this.editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getTipoPublicacion() {
		return this.tipoPublicacion;
	}

	public void setTipoPublicacion(String tipoPublicacion) {
		this.tipoPublicacion = tipoPublicacion;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Datos_informativos> getDatosInformativos() {
		return this.datosInformativos;
	}

	public void setDatosInformativos(List<Datos_informativos> datosInformativos) {
		this.datosInformativos = datosInformativos;
	}

	public Datos_informativos addDatosInformativo(Datos_informativos datosInformativo) {
		getDatosInformativos().add(datosInformativo);
		datosInformativo.setPublicacione(this);

		return datosInformativo;
	}

	public Datos_informativos removeDatosInformativo(Datos_informativos datosInformativo) {
		getDatosInformativos().remove(datosInformativo);
		datosInformativo.setPublicacione(null);

		return datosInformativo;
	}

}