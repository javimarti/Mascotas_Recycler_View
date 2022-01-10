package com.example.myapplication;

import android.media.Image;

import java.io.Serializable;

public class MascotasDto implements Serializable {

    public  MascotasDto(int petImg,String petName,int boneImg,String votes,int boneLikeImg){
        this.petImg=petImg;
       this.boneImg=boneImg;
        this.petName=petName;
        this.votes=votes;
        this.boneLikeImg=boneLikeImg;
    }
    private   int petImg;
    private   int boneImg;
    private   String petName;
    private String votes;
    private int boneLikeImg;

    public int getPetImg() {
        return petImg;
    }

    public void setPetImg(int petImg) {
        this.petImg = petImg;
    }

    public int getBoneImg() {
        return boneImg;
    }

    public void setBoneImg(int boneImg) {
        this.boneImg = boneImg;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }



    public int getBoneLikeImg() {
        return boneLikeImg;
    }

    public void setBoneLikeImg(int boneLikeImg) {
        this.boneLikeImg = boneLikeImg;
    }

    public String getVotes() {
        return votes;
    }

    public void setVotes(String votes) {
        this.votes = votes;
    }
}
