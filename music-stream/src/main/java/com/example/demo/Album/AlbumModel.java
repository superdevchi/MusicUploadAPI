package com.example.demo.Album;

import com.example.demo.Artiste.ArtisteModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "Album")
public class AlbumModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer AlbumID;

    public String AlbumName;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="Artiste_ArtisteID")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    public ArtisteModel artisteModel;

    public AlbumModel() {
    }

    public AlbumModel(Integer albumID, String albumName, ArtisteModel artisteModel) {
        AlbumID = albumID;
        AlbumName = albumName;
        this.artisteModel = artisteModel;
    }

    public Integer getAlbumID() {
        return AlbumID;
    }

    public void setAlbumID(Integer albumID) {
        AlbumID = albumID;
    }

    public String getAlbumName() {
        return AlbumName;
    }

    public void setAlbumName(String albumName) {
        AlbumName = albumName;
    }

    public ArtisteModel getArtisteModel() {
        return artisteModel;
    }

    public void setArtisteModel(ArtisteModel artisteModel) {
        this.artisteModel = artisteModel;
    }
}
