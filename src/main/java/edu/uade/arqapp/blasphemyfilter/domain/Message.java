package edu.uade.arqapp.blasphemyfilter.domain;

public class Message {
    

    private Integer userId;
    private String message;

    public Message() {
    }

    public Message(Message message) {
        this.userId = message.getUserId();
        this.message = message.getMessage();
    }
    
    public Message(Integer userId, String message) {
        this.userId = userId;
        this.message = message;
    }

    public Integer getUserId() {
        return userId;
    }
    
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    

}
