package com.devsagi.photoGrid.model;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document //identifica que é gerenciado pelo spring
public class Polaroid {
	
	
	@Id //faz com que o id seja gerado automatico 
	private String id;
	private String titulo;
	private String texto;
	private String img;
	
	
	public Polaroid(String id, String titulo, String texto, String img) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.texto = texto;
		this.img = img;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getTexto() {
		return texto;
	}


	public void setTexto(String texto) {
		this.texto = texto;
	}


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id, img, texto, titulo);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Polaroid other = (Polaroid) obj;
		return Objects.equals(id, other.id) && Objects.equals(img, other.img) && Objects.equals(texto, other.texto)
				&& Objects.equals(titulo, other.titulo);
	}


	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}


	@Override
	public String toString() {
		return "Polaroid [id=" + id + ", titulo=" + titulo + ", texto=" + texto + ", img=" + img + "]";
	}


	
	
	
	

}
