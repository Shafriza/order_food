package org.shafriza.miniproject;

public class  Card {
    private int img;
    private String title;
    private String description;
    private int  price;


    public Card(int img, String title, String description, int price) {
        this.img = img;
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
