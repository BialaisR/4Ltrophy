package hei.devweb.trophy.pojos;

/* Classe représentant l'objet Album - correspond à la table album de notre base de données */

public class Album {
	
	/* On défini les deux paramètres d'un album */

	private Integer idAlbum;
	private String nomAlbum;



	// contructeur de album
	
	public Album(Integer idAlbum, String nomAlbum) {
		super();
		this.idAlbum = idAlbum;
		this.nomAlbum = nomAlbum;
	}
	
	/* getter et setters auto-générés indispensables */
	
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
