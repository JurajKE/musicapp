package com.pacholsky.juraj.music.service;

import com.pacholsky.juraj.music.entity.Song;
import com.pacholsky.juraj.music.repository.SongRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("SongService")
@Transactional
public class SongService extends AbstractService<Song, SongRepository> {


    public List<Song> getByAlbumId(int albumId){
        return super.repository.findAllByAlbumId(albumId);
    }

    public Song getByName(String name){
        return super.repository.findByName(name).orElseThrow();
    }

    public List<Song> getByGenreId(int genreId){
        return super.repository.findAllByGenreId(genreId);
    }

    public List<Song> getByPerformerId(int performerId){
        return super.repository.findAllByFeaturesPerformers_id(performerId);
    }

    public List<Song> getByPlaylistId(int playlistId){
        return super.repository.findAllByPlaylists_id(playlistId);
    }

}
