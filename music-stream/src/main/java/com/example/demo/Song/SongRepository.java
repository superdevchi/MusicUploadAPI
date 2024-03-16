package com.example.demo.Song;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<SongModel, Integer> {
}
