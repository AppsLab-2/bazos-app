package com.appslab.bazosapp.models;

import javax.persistence.*;




@Entity
@Table(name ="Items")
public class Items {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    long numberOfItem;
    String category;
    float price;
    String description;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users users;

    public Items(long numberOfItem,String category, float price, String description){
    this.category=category;
    this.price=price;
    this.description=description;
    this.numberOfItem=numberOfItem;
    }

    public long getNumberOfItem() {
        return numberOfItem;
    }

    public void setNumberOfItem(long numberOfItem) {
        this.numberOfItem = numberOfItem;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Users  getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
