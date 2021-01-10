package com.pacholsky.juraj.music.controller.view;

import com.pacholsky.juraj.music.dto.PlaylistView;
import com.pacholsky.juraj.music.service.view.PlaylistViewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/playlist-view")
public class PlaylistViewController {

    @Autowired
    private PlaylistViewService playlistViewService;

    @GetMapping("/{id}")
    public PlaylistView getById(@PathVariable("id") int id){
        log.info("Going to get [{}] by id [{}] " , PlaylistView.class.getSimpleName(), id);
        return playlistViewService.getById(id);
    }

}
