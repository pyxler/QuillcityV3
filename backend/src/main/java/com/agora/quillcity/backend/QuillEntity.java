package com.agora.quillcity.backend;

import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * Created by Paul on 2015-02-21.
 */
public class QuillEntity {

    @Persistent @PrimaryKey private Integer id;
    @Persistent private String author;
    @Persistent private boolean anonymous;
    @Persistent private String poem;
    @Persistent private int likes;
    @Persistent private int dislikes;
    @Persistent private int neutrals;
    @Persistent private double mLat;
    @Persistent private double mLong;

    //mock constructor
    public QuillEntity(String author, String poem){
        author = author;
        this.poem = poem;
        likes = 0;
        dislikes = 0;
        neutrals = 0;
    }

    public void Liked(){
        likes++;
    }

    public void Disliked(){
        dislikes++;
    }

    public void Neutraled(){
        neutrals++;
    }

    public String getAuthor(){
        return author;
    }

    public boolean isAnonymous(){
        return anonymous;
    }

    public String getPoem(){
        return poem;
    }

    public double getLat(){
        return mLat;
    }

    public double getLong(){
        return mLong;
    }

}
