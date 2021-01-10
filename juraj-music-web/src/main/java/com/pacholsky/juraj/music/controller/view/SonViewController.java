package com.pacholsky.juraj.music.controller.view;

import com.pacholsky.juraj.music.dto.SongView;
import com.pacholsky.juraj.music.service.view.SongViewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/song-view")
public class SonViewController {
    @Autowired
    private SongViewService songViewService;

    @GetMapping("/{id}")
    public SongView getById(@PathVariable("id") int id){
        log.info("Going to get [{}] by id [{}] " , SongView.class.getSimpleName(), id);
        return songViewService.getById(id);


    }


}
