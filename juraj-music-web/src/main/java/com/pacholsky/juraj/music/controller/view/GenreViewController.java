package com.pacholsky.juraj.music.controller.view;

import com.pacholsky.juraj.music.dto.AlbumView;
import com.pacholsky.juraj.music.dto.GenreView;
import com.pacholsky.juraj.music.service.view.AlbumViewService;
import com.pacholsky.juraj.music.service.view.GenreViewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/genre-view")
public class GenreViewController {

    @Autowired
    private GenreViewService genreViewService;

    @GetMapping("/{id}")
    public GenreView getById(@PathVariable("id") int id){
        log.info("Going to get [{}] by id [{}] " , GenreView.class.getSimpleName() , id);
        return genreViewService.getById(id);
    }

    @GetMapping("/all")
    public List<GenreView> getAll(){
        log.info("Going to get [{}] by id [{}] " , GenreView.class.getSimpleName());
        return genreViewService.getAll();
    }
    


}
