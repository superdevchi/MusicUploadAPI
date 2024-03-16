package com.example.demo.Song;

import com.example.demo.Album.AlbumModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@Service
public class SongService {

    @Autowired
    SongRepository songRepository;

    @Autowired
    AWSuploadService awSuploadService;

    private String uploadfilepath = "C:\\Users\\23490\\Desktop\\uploadedMusic";

    public SongModel CreateSong (SongModel songModel){
        return songRepository.save(songModel);
    }

    public String CreatedSucessful(){
        return "sucess";
    }

    public List<SongModel> ListSongs(){
        return songRepository.findAll();
    }

    public void uploadLocal(MultipartFile File) throws IOException {

//        try {
//            byte[] data = File.getBytes();
//            Path path = Path.of(uploadfilepath, File.getOriginalFilename());
//            Files.write(path,data);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        awSuploadService.uploadFile(File);
    }

    public Optional<SongModel> getSONG(Integer id){
        return songRepository.findById(id);
    }

}
