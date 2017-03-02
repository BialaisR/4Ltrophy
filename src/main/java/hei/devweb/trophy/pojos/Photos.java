package hei.devweb.trophy.pojos;

public class Photos {

	private Integer idPhoto;
	private String photo;
	private Integer idAlbum;

	public Photos(Integer idPhoto, String photo, Integer idAlbum) {
		super();
		this.idPhoto = idPhoto;
		this.photo = photo;
		this.idAlbum = idAlbum;
	}

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
