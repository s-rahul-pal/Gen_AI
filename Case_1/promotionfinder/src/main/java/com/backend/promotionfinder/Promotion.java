package com.backend.promotionfinder;

import java.util.List;

public class Promotion {
    private String id;
    private String promotionName;
    private String country;
    private List<String> termsOfUse;
    private List<String> locations;

    // Constructor
    

    // Getters and Setters
    public String getId() {
        return id;
    }

    public Promotion(String id, String promotionName, String country, List<String> terms, List<String> location) {
        this.id = id;
        this.promotionName = promotionName;
        this.country = country;
        this.termsOfUse = terms;
        this.locations = location;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<String> getTerms() {
        return termsOfUse;
    }

    public void setTerms(List<String> terms) {
        this.termsOfUse = terms;
    }

    public List<String> getLocation() {
        return locations;
    }

    public void setLocation(List<String> location) {
        this.locations = location;
    }



}