package hei.devweb.trophy.pojos;

/* Classe représentant l'objet utilisateur - correspond à la table utilisateur de notre base de données */

public class Utilisateur {
	
	// on définit les 7 paramètres d'un utilisateur

	private Integer idUser;
	private String nom;
	private String prenom;
	private String mail;
	private String photo;
	private String classe;
	private String identif;
	
	// constructeur d'utilisateur

	public Utilisateur(int idUser, String nom, String prenom, String mail,
		 String photo, String classe, String identif) {
		super();
		this.idUser = idUser;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;

		this.classe=classe;
		this.photo = photo;
		this.identif=identif;
	}
	
	/* getter et setters auto-générés indispensables */

	public Integer getIdUser() {
		return idUser;
	}


	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	

}
