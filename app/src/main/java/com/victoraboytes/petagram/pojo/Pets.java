package com.victoraboytes.petagram.pojo;

/**
 * Created by victoraboytes on 21/01/2018.
 */

public class Pets {
    private String name, likes;
    private int photo;

    public Pets(int photo, String likes, String name) {
        this.name   = name;
        this.photo  = photo;
        this.likes  = likes;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
