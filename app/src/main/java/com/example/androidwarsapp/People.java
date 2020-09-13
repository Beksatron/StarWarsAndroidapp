package com.example.androidwarsapp;

import java.io.Serializable;

public class People implements Serializable {

    private static final long serialVersionUID = 1L;

    private String mName;
    private String mHeight;
    private String mMass;
    private String mMovie;
    private String mEpisodeId;

    public People(String name, String mass, String height, String movie) {
        mName = name;
        mMass = mass;
        mHeight = height;
        mMovie = movie;
    }

    public People(String name, String height, String mass) {
        mName = name;
        mHeight = height;
        mMass = mass;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getMass() {
        return mMass;
    }

    public void setMass(String mass) {
        mMass = mass;
    }

    public String getHeight() {
        return mHeight;
    }

    public void setHeight(String height) {
        mHeight = height;
    }

    public String getMovie() {
        return mMovie;
    }

    public void setMovie(String movie) {
        mMovie = movie;
    }

    public String getEpisodeId() {
        return mEpisodeId;
    }

    public void setEpisodeId(String episodeId) {
        mEpisodeId = episodeId;
    }

    @Override
    public String toString() {
        return "Person{" +
                "mName='" + mName + '\'' +
                ", mHeight='" + mHeight + '\'' +
                ", mMass='" + mMass + '\'' +
                ", mMovie='" + mMovie + '\'' +
                ", mEpisodeId='" + mEpisodeId + '\'' +
                '}';
    }

}
