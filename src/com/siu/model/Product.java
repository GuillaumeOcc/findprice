package com.siu.model;

import android.widget.ImageView;

/**
 * Created with IntelliJ IDEA.
 * User: Asus
 * Date: 23/07/12
 * Time: 15:30
 * To change this template use File | Settings | File Templates.
 */
public class Product {

      String tableauProduct[] = {"book", "music", "high-tech", "computer", "videogame", "toy", "kitchen" ,"beauty", "clothe"
      , "watch", "sport", "craft"};



    private Category category;

    private String name;
    private Float price;
    private ImageView imageProduct;


    public ImageView getImageProduct() {
        return imageProduct;
    }

    public void setImageProduct(ImageView imageProduct) {
        this.imageProduct = imageProduct;
    }


    public Product(Category category, String name, Float price) {
        this.category = category;
        this.name = name;
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
