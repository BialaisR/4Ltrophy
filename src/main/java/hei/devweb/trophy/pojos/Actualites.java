package hei.devweb.trophy.pojos;

public class Actualites {

	private Integer idActu;
	private String titreActu;
	private String actu;


	public Actualites(Integer idActu, String titreActu, String actu) {
		super();
		this.idActu = idActu;
		this.actu = actu;
		this.titreActu = titreActu;
	}

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
