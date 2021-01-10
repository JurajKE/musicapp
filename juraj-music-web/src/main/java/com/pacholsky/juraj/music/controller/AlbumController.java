package com.pacholsky.juraj.music.controller;

import com.pacholsky.juraj.music.entity.Album;
import com.pacholsky.juraj.music.service.AlbumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/album")
public class AlbumController extends AbstractController<Album , AlbumService>{


    @GetMapping("/perfomerid")
    public List<Album> getByPerfomerId(@RequestParam("performerid") int id){
        log.info("Going to get all Albums by performer id [{}]" , id );
        return super.service.getByPerfomerId(id);
    }

    @GetMapping("/name")
    public Album getByName(@RequestParam("name") String name){
        log.info("Going to get Album by name [{}]" , name );
        return super.service.getByName(name);
    }

    @GetMapping("/publisherid")
    public List<Album> getByPublisherId(@RequestParam("publisherid") int id){
        log.info("Going to get all Albums by publisher id [{}]" , id );
        return super.service.getByPublisherId(id);
    }

    @GetMapping("/songid")
    public Album getBySongId(@RequestParam("songid") int songId){
        log.info("Going to get Album by song id [{}]" , songId );
        return super.service.getBySongId(songId);
    }

    @Override
    public Class<Album> getClassMethod() {
        return Album.class;
    }
}
