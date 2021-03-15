package com.example.android.sild;

import android.location.Location;
import android.media.Image;

public abstract class Product {
    String barcode;
    Location location;
    Image image;
    int thumpup;
    int thumpdown;

    public Product(String bar, Location loc, Image img){
        barcode = bar;
        location = loc;
        img = image;
    }

    public String getBarcode() {
        return barcode;
    }

    public Location getLocation() {
        return location;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}