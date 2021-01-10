package com.pacholsky.juraj.music.controller;

import com.pacholsky.juraj.music.entity.Performer;
import com.pacholsky.juraj.music.service.PerformerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/performer")
public class PerformerController extends AbstractController<Performer, PerformerService>{


    @GetMapping("/name")
    public Performer getByName(@RequestParam("name") String name){
        log.info("Going to get Performer by name [{}]" , name );
        return super.service.getAllByName(name);
    }


    @GetMapping("/albumid")
    public Performer getByAlbumId(@RequestParam("albumid") int albumId){
        log.info("Going to get Performer by album id [{}]" , albumId );
        return super.service.getByAlbumId(albumId);
    }

    @GetMapping("/songid")
    public List<Performer> getBySongId(@RequestParam("songid") int songId){
        log.info("Going to get all Performers by song id [{}]" , songId );
        return super.service.getBySongId(songId);
    }

    @Override
    public Class<Performer> getClassMethod() {
        return Performer.class;
    }
}
