package hei.devweb.trophy.pojos;

/* Classe représentant l'objet Equipages - correspond à la table equipages de notre base de données */

public class Equipages {
	
	// On défini les paramètres d'un équipage

	private Integer numeroEquipage;
	private String nomEquipage;
	private String descriptionEquipage;
	private String nom1;
	private String nom2;
	private String prenom1;
	private String prenom2;
	private String mail1;
	private String mail2;
	private String classe1;
	private String classe2;
	private String photo1;
	private String photo2;
	private String photoEquipage;
	
	/* getter et setters auto-générés indispensables */
	
	public String getNom1() {
		return nom1;
	}

	public void setNom1(String nom1) {
		this.nom1 = nom1;
	}

	public String getNom2() {
		return nom2;
	}

	public void setNom2(String nom2) {
		this.nom2 = nom2;
	}

	public String getPrenom1() {
		return prenom1;
	}

	public void setPrenom1(String prenom1) {
		this.prenom1 = prenom1;
	}

	public String getPrenom2() {
		return prenom2;
	}

	public void setPrenom2(String prenom2) {
		this.prenom2 = prenom2;
	}

	public String getMail1() {
		return mail1;
	}

	public void setMail1(String mail1) {
		this.mail1 = mail1;
	}

	public String getMail2() {
		return mail2;
	}

	public void setMail2(String mail2) {
		this.mail2 = mail2;
	}

	public String getClasse1() {
		return classe1;
	}

	public void setClasse1(String classe1) {
		this.classe1 = classe1;
	}

	public String getClasse2() {
		return classe2;
	}

	public void setClasse2(String classe2) {
		this.classe2 = classe2;
	}

	public String getPhoto1() {
		return photo1;
	}

	public void setPhoto1(String photo1) {
		this.photo1 = photo1;
	}

	public String getPhoto2() {
		return photo2;
	}

	public void setPhoto2(String photo2) {
		this.photo2 = photo2;
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

	public String getPhotoEquipage() {
		return photoEquipage;
	}

	public void setPhotoEquipage(String photoEquipage) {
		this.photoEquipage = photoEquipage;
	}



	// constructeur de Equipages
	public Equipages(Integer numeroEquipage, String nomEquipage, String descriptionEquipage, String nom1, String nom2,
			String prenom1, String prenom2, String mail1, String mail2, String classe1, String classe2, String photo1,
			String photo2, String photoEquipage) {
		super();
		this.numeroEquipage = numeroEquipage;
		this.nomEquipage = nomEquipage;
		this.descriptionEquipage = descriptionEquipage;
		this.nom1 = nom1;
		this.nom2 = nom2;
		this.prenom1 = prenom1;
		this.prenom2 = prenom2;
		this.mail1 = mail1;
		this.mail2 = mail2;
		this.classe1 = classe1;
		this.classe2 = classe2;
		this.photo1 = photo1;
		this.photo2 = photo2;
		this.photoEquipage = photoEquipage;
	}
		

}
