package com.example.demo.Album;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<AlbumModel, Integer> {
}
