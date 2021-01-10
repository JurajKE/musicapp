package com.pacholsky.juraj.music.controller.view;

import com.pacholsky.juraj.music.dto.AlbumView;
import com.pacholsky.juraj.music.service.view.AlbumViewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/album-view")
public class AlbumViewController {

    @Autowired
    private AlbumViewService albumViewService;

    @GetMapping("/{id}")
    public AlbumView getById(@PathVariable("id") int id){
        log.info("Going to get [{}] by id [{}] " , AlbumView.class.getSimpleName() , id);
        return albumViewService.getById(id);
    }

}
