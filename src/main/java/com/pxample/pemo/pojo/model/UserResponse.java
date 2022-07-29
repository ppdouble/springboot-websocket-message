package com.pxample.pemo.pojo.model;


// It is a message wrapper.

public class UserResponse {

    private String content;

    public UserResponse() {}

    public UserResponse(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}