package com.pacholsky.juraj.music.controller;

import com.pacholsky.juraj.music.entity.Playlist;
import com.pacholsky.juraj.music.service.PlaylistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/playlist")
public class PlaylistController extends AbstractController<Playlist, PlaylistService>{

    @GetMapping("/name")
    public Playlist getByName(@RequestParam("name") String name){
        log.info("Going to get Playlist by name [{}]" , name );
        return super.service.getByName(name);
    }

    @GetMapping("/userid")
    public List<Playlist> getByUserId(@RequestParam("userid") int userId){
        log.info("Going to get all Playlist by user id [{}]" , userId );
        return super.service.getByUserId(userId);
    }

    @GetMapping("/songid")
    public List<Playlist> getBySongId(@RequestParam("songId") int songId){
        log.info("Going to get all Playlist by song id [{}]" , songId );
        return super.service.getBySongId(songId);
    }

    @Override
    public Class<Playlist> getClassMethod() {
        return Playlist.class;
    }
}
