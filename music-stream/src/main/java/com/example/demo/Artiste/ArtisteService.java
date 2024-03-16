package com.example.demo.Artiste;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtisteService {

    @Autowired
    ArtisteRepository artisteRepository;

    public ArtisteModel CreateArtiste(ArtisteModel artisteModel){
        return artisteRepository.save(artisteModel);
    }

    public List<ArtisteModel> ListArtiste(){
        return artisteRepository.findAll();
    }

    public Optional<ArtisteModel> getARTISTE(Integer id){
        return artisteRepository.findById(id);
    }
}
