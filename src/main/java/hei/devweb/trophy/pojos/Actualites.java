package hei.devweb.trophy.pojos;

/* Classe représentant l'objet Actualités - correspond à la table actualités de notre base de données*/

public class Actualites {

/* On défini les trois paramètres d'une actualités */
	
	private Integer idActu;
	private String titreActu;
	private String actu;


// contructeur de Actualités
	public Actualites(Integer idActu, String titreActu, String actu) {
		super();
		this.idActu = idActu;
		this.actu = actu;
		this.titreActu = titreActu;
	}

/* getter et setters auto-générés indispensables */
	
	public Integer getIdActu() {
		return idActu;
	}

	public void setIdActu(Integer idActu) {
		this.idActu = idActu;
	}

	public String getActu() {
		return actu;
	}

	public void setActu(String actu) {
		this.actu = actu;
	}

	public String getTitreActu() {
		return titreActu;
	}

	public void setTitreActu(String titreActu) {
		this.titreActu = titreActu;
	}

}
