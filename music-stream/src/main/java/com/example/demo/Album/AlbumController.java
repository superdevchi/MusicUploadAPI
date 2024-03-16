package com.example.demo.Album;

import com.example.demo.Artiste.ArtisteModel;
import com.example.demo.Artiste.ArtisteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("Album")
public class AlbumController {

    @Autowired AlbumService service;

    @Autowired
    ArtisteRepository artisteRepository;

    @PostMapping("/{Artiste_ID}/create")
    public Optional<AlbumModel> CreateUser(@PathVariable Integer Artiste_ID, @RequestBody AlbumModel albumModel){
        // check if artiste exist
        AlbumModel albumModel1 = artisteRepository.findById(Artiste_ID).map(artisteModel -> {
            albumModel.setArtisteModel(artisteModel);
            return service.CreateAlbum(albumModel);
        }).orElseThrow();

        Integer id = albumModel.getAlbumID();

        return service.getALBUM(id);
    }

    @GetMapping("/list")
    public List<AlbumModel> ListAlbum(){
        return service.ListAlbum();
    }
}
