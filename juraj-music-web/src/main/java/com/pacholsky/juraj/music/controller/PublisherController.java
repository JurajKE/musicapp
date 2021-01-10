package com.pacholsky.juraj.music.controller;

import com.pacholsky.juraj.music.entity.Publisher;
import com.pacholsky.juraj.music.service.PublisherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/publisher")
public class PublisherController extends AbstractController<Publisher,PublisherService>{

    @GetMapping("/name")
    public Publisher getByName(@RequestParam("name") String name){
        log.info("Going to get Publisher by name [{}]" , name );
        return super.service.getByName(name);
    }

    @GetMapping("/albumid")
    public Publisher getByAlbumId(@RequestParam("albumid") int albumId){
        log.info("Going to get Publisher by album id [{}]" , albumId );
        return super.service.getByAlbumId(albumId);
    }

    @Override
    public Class<Publisher> getClassMethod() {
        return Publisher.class;
    }
}
