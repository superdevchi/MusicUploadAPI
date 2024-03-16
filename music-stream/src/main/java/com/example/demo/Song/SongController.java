package com.example.demo.Song;

import com.example.demo.Album.AlbumRepository;
import com.example.demo.Artiste.ArtisteModel;
import com.example.demo.Artiste.ArtisteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("Songs")
public class SongController {
    @Autowired
    SongService songService;

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    ArtisteRepository artisteRepository;


    @PostMapping("/{Artiste_ID}/{Album_ID}/create")
    public Optional<SongModel> create(@PathVariable Integer Artiste_ID, @PathVariable Integer Album_ID , @ModelAttribute  SongModel songModel, @PathVariable("file") MultipartFile File, @PathVariable("file") MultipartFile Image){



        // check if ArtisteID Exist
        String songModel1 = artisteRepository.findById(Artiste_ID).map(artisteModel -> {
            songModel.setArtisteModel(artisteModel);
           albumRepository.findById(Album_ID).map(albumModel -> {
               songModel.setAlbumModel(albumModel);
               try {
                   songService.uploadLocal(File);
                   songService.awSuploadService.uploadFileImage(Image);

                   String ImageUrl = songService.awSuploadService.GETURLIMAGE();
                   String url = songService.awSuploadService.GETURL();

                   songModel.setSongURL(url);
                   songModel.setSongImageCover(ImageUrl);




               } catch (IOException e) {
                   throw new RuntimeException(e);
               }
               return songService.CreateSong(songModel);
           }).orElseThrow();
            return  songService.CreatedSucessful();
        }).orElseThrow();

        Integer SONGID = songModel.getSongID();
        return songService.getSONG(SONGID);
    }

    @GetMapping("/List")
    public List<SongModel> list(){
        return songService.ListSongs();
    }


    //upload songfile
    @PostMapping("/upload")
    public void upload(@PathVariable("file") MultipartFile File){
        try {
            songService.uploadLocal(File);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
