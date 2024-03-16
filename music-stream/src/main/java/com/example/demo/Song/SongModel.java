package com.example.demo.Song;

import com.example.demo.Album.AlbumModel;
import com.example.demo.Artiste.ArtisteModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "Song")
public class SongModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer SongID;

    public String SongName;
    public String SongBitRate;
    public String SongImageCover;
    public String SongURL;


    //    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="Artiste_ArtisteID")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    public ArtisteModel artisteModel;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="Album_AlbumID")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    public AlbumModel albumModel;

    public SongModel() {
    }

    public SongModel(Integer songID, String songName, String songBitRate, ArtisteModel artisteModel, AlbumModel albumModel) {
        SongID = songID;
        SongName = songName;
        SongBitRate = songBitRate;
        this.artisteModel = artisteModel;
        this.albumModel = albumModel;
    }

    public SongModel(String songImageCover, String songURL) {
        SongImageCover = songImageCover;
        SongURL = songURL;
    }

    public String getSongImageCover() {
        return SongImageCover;
    }

    public void setSongImageCover(String songImageCover) {
        SongImageCover = songImageCover;
    }

    public String getSongURL() {
        return SongURL;
    }

    public void setSongURL(String songURL) {
        SongURL = songURL;
    }

    public Integer getSongID() {
        return SongID;
    }

    public void setSongID(Integer songID) {
        SongID = songID;
    }

    public String getSongName() {
        return SongName;
    }

    public void setSongName(String songName) {
        SongName = songName;
    }

    public String getSongBitRate() {
        return SongBitRate;
    }

    public void setSongBitRate(String songBitRate) {
        SongBitRate = songBitRate;
    }

    public ArtisteModel getArtisteModel() {
        return artisteModel;
    }

    public void setArtisteModel(ArtisteModel artisteModel) {
        this.artisteModel = artisteModel;
    }

    public AlbumModel getAlbumModel() {
        return albumModel;
    }

    public void setAlbumModel(AlbumModel albumModel) {
        this.albumModel = albumModel;
    }
}
