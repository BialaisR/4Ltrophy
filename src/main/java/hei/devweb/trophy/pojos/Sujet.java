package hei.devweb.trophy.pojos;

import java.time.LocalDate;

public class Sujet {

	private Integer idSujet;
	private String identifiantCreateur;
	private LocalDate dateLastPost;
	private Integer nbMessages;
	private String identifiantLastPost;

	public Sujet(Integer idSujet, String identifiantCreateur, LocalDate dateLastPost, Integer nbMessages,
			String identifiantLastPost) {
		super();
		this.idSujet = idSujet;
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

	public LocalDate getDateLastPost() {
		return dateLastPost;
	}

	public void setDateLastPost(LocalDate dateLastPost) {
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

}
