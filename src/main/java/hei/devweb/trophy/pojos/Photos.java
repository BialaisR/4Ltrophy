package hei.devweb.trophy.pojos;

/* Classe représentant l'objet photos - correspond à la table photos de notre base de données */

public class Photos {
	
	// on définit les 3 paramètres d'une photo

	private Integer idPhoto;
	private String photo;
	private Integer idAlbum;
	
	// constructeur de photos

	public Photos(Integer idPhoto, String photo, Integer idAlbum) {
		super();
		this.idPhoto = idPhoto;
		this.photo = photo;
		this.idAlbum = idAlbum;
	}
	
	/* getter et setters auto-générés indispensables */

	public Integer getIdPhoto() {
		return idPhoto;
	}

	public void setIdPhoto(Integer idPhoto) {
		this.idPhoto = idPhoto;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Integer getIdAlbum() {
		return idAlbum;
	}

	public void setIdAlbum(Integer idAlbum) {
		this.idAlbum = idAlbum;
	}

}
