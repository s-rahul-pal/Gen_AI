package com.backend.promotionfinder;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import java.util.List;

@Entity
public class Promotion {

    @Id
    private Long id;

    @Column(name = "promotionname")
    private String promotionName;
    
    private String country;

    @ElementCollection
    @CollectionTable(name = "termsofuse", joinColumns = @JoinColumn(name = "promotionid"))
    @Column(name = "term")
    private List<String> termsOfUse;

    @ElementCollection
    @CollectionTable(name = "locations", joinColumns = @JoinColumn(name = "promotionid"))
    @Column(name = "location")
    private List<String> locations;

    // Constructor
    public Promotion(String promotionName, String country, List<String> termsOfUse, List<String> locations) {
        this.promotionName = promotionName;
        this.country = country;
        this.termsOfUse = termsOfUse;
        this.locations = locations;
    }
    
    
    

    public Promotion() {
	}




	// Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<String> getTermsOfUse() {
        return termsOfUse;
    }

    public void setTermsOfUse(List<String> termsOfUse) {
        this.termsOfUse = termsOfUse;
    }

    public List<String> getLocations() {
        return locations;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }
}
