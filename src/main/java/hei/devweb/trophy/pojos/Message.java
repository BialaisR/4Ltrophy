package hei.devweb.trophy.pojos;

import java.time.LocalDate;

public class Message {

	private Integer idMessage;
	private String texteMessage;
	private LocalDate datePost;

	public Message(Integer idMessage, String texteMessage, LocalDate datePost) {
		super();
		this.idMessage = idMessage;
		this.texteMessage = texteMessage;
		this.datePost = datePost;
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

	public LocalDate getDatePost() {
		return datePost;
	}

	public void setDatePost(LocalDate datePost) {
		this.datePost = datePost;
	}

}
