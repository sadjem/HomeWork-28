package com.lepet.model;

public class Image {
    private String image;
    private String aboutImage;
    private int id;

    public Image(String image, String aboutImage, int id) {
        this.image = image;
        this.aboutImage = aboutImage;
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAboutImage() {
        return aboutImage;
    }

    public void setAboutImage(String aboutImage) {
        this.aboutImage = aboutImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Image{" +
                "image='" + image + '\'' +
                ", aboutImage='" + aboutImage + '\'' +
                ", id=" + id +
                '}';
    }
}
