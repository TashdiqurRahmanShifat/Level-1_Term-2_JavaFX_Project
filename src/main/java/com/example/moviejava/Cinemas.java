package com.example.moviejava;

import java.io.Serializable;

public class Cinemas implements Serializable {
    private String name;
    private int year;
    private String Genre1;
    private String Genre2;
    private String Genre3;
    private int duration;
    private String Productioncompany;
    private int budget;
    private int revenue;
    private String thumbnaillink;
    private String youtubelink;

    public Cinemas(){}
    Cinemas(String name, int year, String Genre1, String Genre2, String Genre3, int duration, String Productioncompany, int budget, int revenue,String thumbnaillink,String youtubelink) {
        this.name = name;
        this.year = year;
        this.Genre1 = Genre1;
        this.Genre2 = Genre2;
        this.Genre3 = Genre3;
        this.duration = duration;
        this.Productioncompany = Productioncompany;
        this.budget = budget;
        this.revenue = revenue;
        this.thumbnaillink=thumbnaillink;
        this.youtubelink=youtubelink;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setGenre1(String genre1) {
        Genre1 = genre1;
    }

    public void setGenre2(String genre2) {
        Genre2 = genre2;
    }

    public void setGenre3(String genre3) {
        Genre3 = genre3;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setProductioncompany(String Productioncompany) {
        this.Productioncompany = Productioncompany;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public void setThumbnaillink(String thumbnaillink) {
        this.thumbnaillink = thumbnaillink;
    }

    public void setYoutubelink(String youtubelink) {
        this.youtubelink = youtubelink;
    }

    public String getYoutubelink() {
        return youtubelink;
    }

    public String getThumbnaillink() {
        return thumbnaillink;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getGenre1() {
        return Genre1;
    }

    public String getGenre2() {
        return Genre2;
    }

    public String getGenre3() {
        return Genre3;
    }

    public int getDuration() {
        return duration;
    }

    public String getProductioncompany() {
        return Productioncompany;
    }

    public int  getBudget() {
        return budget;
    }

    public int getRevenue() {
        return revenue;
    }
}
