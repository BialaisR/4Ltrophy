package hei.devweb.trophy.pojos;

public class Album {

	private Integer idAlbum;
	private String nomAlbum;

	public Album(Integer idAlbum, String nomAlbum) {
		super();
		this.idAlbum = idAlbum;
		this.nomAlbum = nomAlbum;
	}

	public Integer getIdAlbum() {
		return idAlbum;
	}

	public void setIdAlbum(Integer idAlbum) {
		this.idAlbum = idAlbum;
	}

	public String getNomAlbum() {
		return nomAlbum;
	}

	public void setNomAlbum(String nomAlbum) {
		this.nomAlbum = nomAlbum;
	}
}
