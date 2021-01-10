package com.pacholsky.juraj.music.repository;

import com.pacholsky.juraj.music.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("songRepository")
public interface SongRepository extends JpaRepository<Song , Integer> {

        Optional<Song> findByName(String name);
        List<Song> findAllByAlbumId(int id);
        List<Song> findAllByGenreId(int genreId);
        List<Song> findAllByFeaturesPerformers_id(int performerId);
        List<Song> findAllByPlaylists_id(int playlistId);

}
