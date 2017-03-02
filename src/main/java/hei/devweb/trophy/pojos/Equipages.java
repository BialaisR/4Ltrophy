package hei.devweb.trophy.pojos;

import com.mysql.jdbc.Blob;

public class Equipages {

	private Integer numeroEquipage;
	private String nomEquipage;
	private String descriptionEquipage;
	private Blob photoEquipage;

	public Equipages(Integer numeroEquipage, String nomEquipage, String descriptionEquipage, Blob photoEquipage) {
		super();
		this.numeroEquipage = numeroEquipage;
		this.nomEquipage = nomEquipage;
		this.descriptionEquipage = descriptionEquipage;
		this.photoEquipage = photoEquipage;
	}

	public Integer getNumeroEquipage() {
		return numeroEquipage;
	}

	public void setNumeroEquipage(Integer numeroEquipage) {
		this.numeroEquipage = numeroEquipage;
	}

	public String getNomEquipage() {
		return nomEquipage;
	}

	public void setNomEquipage(String nomEquipage) {
		this.nomEquipage = nomEquipage;
	}

	public String getDescriptionEquipage() {
		return descriptionEquipage;
	}

	public void setDescriptionEquipage(String descriptionEquipage) {
		this.descriptionEquipage = descriptionEquipage;
	}

	public Blob getPhotoEquipage() {
		return photoEquipage;
	}

	public void setPhotoEquipage(Blob photoEquipage) {
		this.photoEquipage = photoEquipage;
	}

}
