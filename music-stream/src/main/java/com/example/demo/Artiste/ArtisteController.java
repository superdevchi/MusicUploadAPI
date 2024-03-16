package com.example.demo.Artiste;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("Artiste")
public class ArtisteController {

    @Autowired ArtisteService artisteService;

    @PostMapping("/create")
    public Optional<ArtisteModel> Create(@RequestBody ArtisteModel artisteModel){
        artisteService.CreateArtiste(artisteModel);
        Integer id = artisteModel.getArtisteID();
        return artisteService.getARTISTE(id) ;
    }

    @GetMapping("/ListArtiste")
    public List<ArtisteModel> ListArtiste(){
        return artisteService.ListArtiste();
    }
}
