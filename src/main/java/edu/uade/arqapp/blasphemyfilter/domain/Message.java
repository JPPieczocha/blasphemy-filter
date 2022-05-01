package edu.uade.arqapp.blasphemyfilter.domain;

public class Message {
    

    private Integer clientId;
    private Integer userId;
    private String message;
    private Boolean blasphemy;

    public Message() {
    }

    public Message(Message message) {
        this.clientId = message.getClientId();
        this.userId = message.getUserId();
        this.message = message.getMessage();
    }

    public Integer getClientId() {
        return clientId;
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

    public Boolean hasBlasphemy() {
        return blasphemy;
    }

    public void setBlasphemy(Boolean blasphemy) {
        this.blasphemy = blasphemy;
    }

    

}
