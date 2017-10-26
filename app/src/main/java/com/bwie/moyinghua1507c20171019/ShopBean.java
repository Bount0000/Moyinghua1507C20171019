package com.bwie.moyinghua1507c20171019;

/**
 * Created by Mo on 2017/10/19.
 */

public class ShopBean {
    private int img;
    private String title;
    private double price;
    private boolean isSelect;

    public ShopBean(int img, String title, double price, boolean isSelect) {
        this.img = img;
        this.title = title;
        this.price = price;
        this.isSelect = isSelect;
    }

    @Override
    public String toString() {
        return "ShopBean{" +
                "img=" + img +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", isSelect=" + isSelect +
                '}';
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }
}
