package com.book.onlinestore.dto;

import java.io.Serializable;

public class UserDtoResponse implements Serializable {
    private Long Id;
    private String username;


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}