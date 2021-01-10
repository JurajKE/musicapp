package com.pacholsky.juraj.music.repository;

import com.pacholsky.juraj.music.entity.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("playlistRepository")
public interface PlaylistRepository extends JpaRepository<Playlist , Integer> {

    Optional<Playlist> findByName(String name);
    List<Playlist> findByUsers_id(int userId);
    List<Playlist> findBySongs_id(int songId);

}
