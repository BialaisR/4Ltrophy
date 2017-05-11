package hei.devweb.trophy.pojos;

/* Classe représentant l'objet message - correspond à la table message de notre base de données */

public class Message {
	
	// On défini les 4 paramètres d'un message

	private Integer idMessage;
	private String texteMessage;
	private String datePost;
	private Integer idSujet;
	
	// constructeur de message

	public Message(Integer idMessage, String texteMessage, String datePost, Integer idSujet) {
		super();
		this.idMessage = idMessage;
		this.texteMessage = texteMessage;
		this.datePost = datePost;
		this.idSujet = idSujet;
	}
	
	/* getter et setters auto-générés indispensables */

	public Integer getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(Integer idMessage) {
		this.idMessage = idMessage;
	}

	public String getTexteMessage() {
		return texteMessage;
	}

	public void setTexteMessage(String texteMessage) {
		this.texteMessage = texteMessage;
	}

	public String getDatePost() {
		return datePost;
	}

	public void setDatePost(String datePost) {
		this.datePost = datePost;
	}
	
	public Integer getIdSujet(){
		return idSujet;
	}
	
	public void setIdSujet(Integer idSujet){
		this.idSujet= idSujet;
	}

}
