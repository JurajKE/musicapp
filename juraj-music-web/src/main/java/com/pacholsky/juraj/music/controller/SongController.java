package com.pacholsky.juraj.music.controller;

import com.pacholsky.juraj.music.entity.Song;
import com.pacholsky.juraj.music.service.SongService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/song")
public class SongController extends AbstractController<Song, SongService>{

    @GetMapping("/albumid")
    public List<Song>getByAlbumId(@RequestParam("id") int albumId){
        log.info("Going to get all Songs by album id [{}]" , albumId );
        return super.service.getByAlbumId(albumId);
    }

    @GetMapping("/name")
    public Song getByName(@RequestParam("name") String name){
        log.info("Going to get Song by name [{}]" , name );
        return super.service.getByName(name);
    }


    @GetMapping("/genre")
    public List<Song> getByGenreId(@RequestParam("genreid") int genreId){
        log.info("Going to get all Songs by genre id [{}]" , genreId );
        return super.service.getByGenreId(genreId);
    }

    @GetMapping("/performerid")
    public List<Song> getByPerformerId(@RequestParam("performerid") int performerId){
        log.info("Going to get all Songs by performer id [{}]" , performerId );
        return super.service.getByPerformerId(performerId);
    }

    @GetMapping("/playlistid")
    public List<Song> getByPlaylistId(@RequestParam("playlistid") int playlistId){
        log.info("Going to get all Songs by playlist id [{}]" , playlistId );
        return super.service.getByPlaylistId(playlistId);
    }

    @Override
    public Class<Song> getClassMethod() {
        return Song.class;
    }
}
