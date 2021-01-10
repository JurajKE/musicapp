package com.pacholsky.juraj.music.controller;

import com.pacholsky.juraj.music.entity.Genre;
import com.pacholsky.juraj.music.service.GenreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/genre")
public class GenreController extends AbstractController<Genre , GenreService>{


    @GetMapping("/name")
    public Genre getByName(@RequestParam("name") String name){
        log.info("Going to get Genre by name [{}]" , name );
        return super.service.getByName(name);
    }

    @GetMapping("/songid")
    public Genre getBySongId(@RequestParam("songid") int songs){
        log.info("Going to get Genre by song id [{}]" , songs );
        return super.service.getBySongId(songs);
    }

    @Override
    public Class<Genre> getClassMethod() {
        return Genre.class;
    }
}
