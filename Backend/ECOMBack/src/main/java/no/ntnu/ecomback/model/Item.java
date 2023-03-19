package no.ntnu.ecomback.model;

import jakarta.persistence.*;

/**
 * The Item class represents an item (advert) published in the e-commerce application.
 */
@Entity
@Table
public class Item {

    /**
     * The Id of the item
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * The seller of the item
     */
    @ManyToOne
    private User seller;

    /**
     * A brief description of the item
     */
    @Column
    private String briefDescription;

    /**
     * The full description of the item
     */
    @Column
    private String fullDescription;

    /**
     * The category of item
     */
    private Category category;

    /**
     * The location of the item
     */
    @Embedded
    private Location location;

    /**
     * The price of the item
     */
    @Column
    private int price;

    /**
     * Instantiates a new Item.
     */
    public Item() {

    }

    /**
     * Instantiates a new Item.
     * @param briefDescription the brief description
     * @param fullDescription  the full description
     * @param category         the category
     * @param location         the location
     * @param price            the price
     */
    public Item(User seller, String briefDescription, String fullDescription, Category category, Location location, int price) {
        this.seller = seller;
        this.briefDescription = briefDescription;
        this.fullDescription = fullDescription;
        this.category = category;
        this.location = location;
        this.price = price;
    }

    /**
     * Gets id.
     * @return the id
     */
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets seller.
     * @return the seller
     */
    public User getSeller() {
        return seller;
    }

    /**
     * Sets seller
     * @param seller the seller of the item
     */
    public void setSeller(User seller) {
        this.seller = seller;
    }

    /**
     * Gets brief description.
     * @return the brief description
     */
    public String getBriefDescription() {
        return briefDescription;
    }

    /**
     * Sets brief description.
     * @param briefDescription the brief description
     */
    public void setBriefDescription(String briefDescription) {
        this.briefDescription = briefDescription;
    }

    /**
     * Gets full description.
     * @return the full description
     */
    public String getFullDescription() {
        return fullDescription;
    }

    /**
     * Sets full description.
     * @param fullDescription the full description
     */
    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    /**
     * Gets category.
     * @return the category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Sets category.
     * @param category the category
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Gets location.
     * @return the location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Sets location.
     * @param location the location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * Gets price.
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets price.
     * @param price the price
     */
    public void setPrice(int price) {
        this.price = price;
    }
}