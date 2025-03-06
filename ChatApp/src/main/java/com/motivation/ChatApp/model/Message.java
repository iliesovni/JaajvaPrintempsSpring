package com.motivation.ChatApp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pseudo;
    private String content;

    public Message(String pseudo, String content) {
        this.pseudo = pseudo;
        this.content = content;
    }
    
    public Message() {
        this.pseudo = null;
        this.content = null;
    }

    public Message(Long id, String pseudo, String content) {
        this.id = id;
        this.pseudo = pseudo;
        this.content = content;
    }
    
    public String getPseudo() {
        return pseudo;
    }

    public String getContent() {
        return content;
    }
}