package com.example.fouractivityapp;

public class UserProfile {

    String name;
    String like;
    String beenTo;
    String wantToGo;
    String interests;
    String fave1;
    String fave2;
    String fave3;
    String fave4;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getBeenTo() {
        return beenTo;
    }

    public void setBeenTo(String beenTo) {
        this.beenTo = beenTo;
    }

    public String getWantToGo() {
        return wantToGo;
    }

    public void setWantToGo(String wantToGo) {
        this.wantToGo = wantToGo;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getFave1() {
        return fave1;
    }

    public void setFave1(String fave1) {
        this.fave1 = fave1;
    }

    public String getFave2() {
        return fave2;
    }

    public void setFave2(String fave2) {
        this.fave2 = fave2;
    }

    public String getFave3() {
        return fave3;
    }

    public void setFave3(String fave3) {
        this.fave3 = fave3;
    }

    public String getFave4() {
        return fave4;
    }

    public void setFave4(String fave4) {
        this.fave4 = fave4;
    }

    public UserProfile(String name, String like, String beenTo, String wantToGo, String interests, String fave1, String fave2, String fave3, String fave4) {
        this.name = name;
        this.like = like;
        this.beenTo = beenTo;
        this.wantToGo = wantToGo;
        this.interests = interests;
        this.fave1 = fave1;
        this.fave2 = fave2;
        this.fave3 = fave3;
        this.fave4 = fave4;
    }
}
