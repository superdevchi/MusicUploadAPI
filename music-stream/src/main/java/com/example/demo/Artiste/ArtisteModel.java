package com.example.demo.Artiste;

import jakarta.persistence.*;

@Entity
@Table(name ="Artiste")
public class ArtisteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ArtisteID;

    private String ArtisteName;
    private String ArtisteCountry;
    private String ArtisteCategory;

    @GeneratedValue(strategy = GenerationType.UUID)
    private Integer ArtistePin;



    public ArtisteModel() {
    }

    public ArtisteModel(Integer artisteID, String artisteName, String artisteCountry, String artisteCategory) {
        ArtisteID = artisteID;
        ArtisteName = artisteName;
        ArtisteCountry = artisteCountry;
        ArtisteCategory = artisteCategory;
    }

    public ArtisteModel(Integer artisteID) {
        ArtisteID = artisteID;
    }

    public Integer getArtistePin() {
        return ArtistePin;
    }

    public void setArtistePin(Integer artistePin) {
        ArtistePin = artistePin;
    }

    public Integer getArtisteID() {
        return ArtisteID;
    }

    public void setArtisteID(Integer artisteID) {
        ArtisteID = artisteID;
    }

    public String getArtisteName() {
        return ArtisteName;
    }

    public void setArtisteName(String artisteName) {
        ArtisteName = artisteName;
    }

    public String getArtisteCountry() {
        return ArtisteCountry;
    }

    public void setArtisteCountry(String artisteCountry) {
        ArtisteCountry = artisteCountry;
    }

    public String getArtisteCategory() {
        return ArtisteCategory;
    }

    public void setArtisteCategory(String artisteCategory) {
        ArtisteCategory = artisteCategory;
    }
}
