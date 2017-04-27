package hei.devweb.trophy.pojos;

public class Utilisateur {

	private String identifiant;
	private String motDePasse;
	private String nom;
	private String prenom;
	private String mail;
	private Integer nbMessagesForum;
	private String dateInscription;
	private Boolean participant;
	private String photo;
	private String classe;
	private Boolean admin;

	public Utilisateur(String identifiant, String motDePasse, String nom, String prenom, String mail,
			Integer nbMessagesForum, String dateInscription, Boolean participant, String photo, String classe,
			Boolean admin) {
		super();
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.nbMessagesForum = nbMessagesForum;
		this.dateInscription = dateInscription;
		this.participant = participant;
		this.photo = photo;
		this.classe = classe;
		this.admin = admin;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
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

	public Integer getNbMessagesForum() {
		return nbMessagesForum;
	}

	public void setNbMessagesForum(Integer nbMessagesForum) {
		this.nbMessagesForum = nbMessagesForum;
	}

	public String getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(String dateInscription) {
		this.dateInscription = dateInscription;
	}

	public Boolean getParticipant() {
		return participant;
	}

	public void setParticipant(Boolean participant) {
		this.participant = participant;
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

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

}
