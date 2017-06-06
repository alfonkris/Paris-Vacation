package com.example.user.myrestaurant;

/**
 * Created by alfonkris on 05/06/17.
 */

public class Info {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    String title;
    String subtitle;
    String description;
    int image;
    String location;

    public Info(String title, String subtitle, String description, int image, String location){
        this.title=title;
        this.subtitle=subtitle;
        this.description=description;
        this.image=image;
        this.location=location;
    }

    public Info(){

    }
}

