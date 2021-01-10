package com.pacholsky.juraj.music.repository;

import com.pacholsky.juraj.music.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("albumRepository")
public interface AlbumRepository extends JpaRepository<Album, Integer> {

      Optional<Album> findByName(String name);
      List<Album> findAllByPerformerId(int idPerformer);
      List<Album> findAllByPublisherId(int idPublisher);
      Optional<Album> findBySong(int songId);

}
