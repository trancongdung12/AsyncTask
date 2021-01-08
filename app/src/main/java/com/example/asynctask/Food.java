package com.example.asynctask;

public class Food {


    private String image;
    private String name;
    private String description;
    private String rate;
    private String minute;
    private String kilometer;


    public Food(String image, String name, String description, String rate, String minute, String kilometer) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.rate = rate;
        this.minute = minute;
        this.kilometer = kilometer;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }

    public void setKilometer(String kilometer) {
        this.kilometer = kilometer;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getRate() {
        return rate;
    }

    public String getMinute() {
        return minute;
    }

    public String getKilometer() {
        return kilometer;
    }
}
