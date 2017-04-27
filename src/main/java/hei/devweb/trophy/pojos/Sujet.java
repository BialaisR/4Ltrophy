package hei.devweb.trophy.pojos;

public class Sujet {

	private Integer idSujet;
	private String nomSujet;
	private String identifiantCreateur;
	private String dateLastPost;
	private Integer nbMessages;
	private String identifiantLastPost;
	
	public Sujet(Integer idSujet, String nomSujet, String identifiantCreateur, String dateLastPost,
			Integer nbMessages, String identifiantLastPost) {
		super();
		this.idSujet = idSujet;
		this.nomSujet = nomSujet;
		this.identifiantCreateur = identifiantCreateur;
		this.dateLastPost = dateLastPost;
		this.nbMessages = nbMessages;
		this.identifiantLastPost = identifiantLastPost;
	}

	public Integer getIdSujet() {
		return idSujet;
	}

	public void setIdSujet(Integer idSujet) {
		this.idSujet = idSujet;
	}

	public String getIdentifiantCreateur() {
		return identifiantCreateur;
	}

	public void setIdentifiantCreateur(String identifiantCreateur) {
		this.identifiantCreateur = identifiantCreateur;
	}

	public String getDateLastPost() {
		return dateLastPost;
	}

	public void setDateLastPost(String dateLastPost) {
		this.dateLastPost = dateLastPost;
	}

	public Integer getNbMessages() {
		return nbMessages;
	}

	public void setNbMessages(Integer nbMessages) {
		this.nbMessages = nbMessages;
	}

	public String getIdentifiantLastPost() {
		return identifiantLastPost;
	}

	public void setIdentifiantLastPost(String identifiantLastPost) {
		this.identifiantLastPost = identifiantLastPost;
	}

	public String getNomSujet() {
		return nomSujet;
	}

	public void setNomSujet(String nomSujet) {
		this.nomSujet = nomSujet;
	}

}
