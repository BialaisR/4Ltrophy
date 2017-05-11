package hei.devweb.trophy.pojos;

/* Classe représentant l'objet Equipages - correspond à la table equipages de notre base de données */

public class Equipages {
	
	// On défini les 6 paramètres d'un équipage

	private Integer numeroEquipage;
	private String nomEquipage;
	private String descriptionEquipage;
	private String identifParticipant1;
	private String identifParticipant2;
	private String photoEquipage;
	
	// constructeur de Equipages

	public Equipages(Integer numeroEquipage, String nomEquipage, String identifParticipant1, String identifParticipant2, String descriptionEquipage, String photoEquipage) {
		super();
		this.numeroEquipage = numeroEquipage;
		this.nomEquipage = nomEquipage;
		this.descriptionEquipage = descriptionEquipage;
		this.identifParticipant1 = identifParticipant1;
		this.identifParticipant2 = identifParticipant2;
		this.photoEquipage = photoEquipage;
	}
	
	/* getter et setters auto-générés indispensables */

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

	public String getPhotoEquipage() {
		return photoEquipage;
	}

	public void setPhotoEquipage(String photoEquipage) {
		this.photoEquipage = photoEquipage;
	}

	public String getIdentifParticipant2() {
		return identifParticipant2;
	}

	public void setIdentifParticipant2(String identifParticipant2) {
		this.identifParticipant2 = identifParticipant2;
	}

	public String getIdentifParticipant1() {
		return identifParticipant1;
	}

	public void setIdentifParticipant1(String identifParticipant1) {
		this.identifParticipant1 = identifParticipant1;
	}

}
