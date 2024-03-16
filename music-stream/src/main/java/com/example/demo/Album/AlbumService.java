package com.example.demo.Album;

import com.example.demo.Artiste.ArtisteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {

    @Autowired
    AlbumRepository albumRepository;

    public AlbumModel CreateAlbum(AlbumModel albumModel){
        return albumRepository.save(albumModel);
    }

    public List<AlbumModel> ListAlbum(){
        return albumRepository.findAll();
    }

    public Optional<AlbumModel> getALBUM(Integer id){
        return albumRepository.findById(id);
    }

}
