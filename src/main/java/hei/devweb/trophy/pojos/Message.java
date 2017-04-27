package hei.devweb.trophy.pojos;

public class Message {

	private Integer idMessage;
	private String texteMessage;
	private String datePost;
	private Integer idSujet;

	public Message(Integer idMessage, String texteMessage, String datePost, Integer idSujet) {
		super();
		this.idMessage = idMessage;
		this.texteMessage = texteMessage;
		this.datePost = datePost;
		this.idSujet = idSujet;
	}

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
