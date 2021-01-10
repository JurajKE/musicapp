package com.pacholsky.juraj.music.controller.view;

import com.pacholsky.juraj.music.dto.PerformerView;
import com.pacholsky.juraj.music.service.view.PerformerViewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/performer-view")
public class PerformerViewController {

    @Autowired
    private PerformerViewService performerViewService;

    @GetMapping("/{id}")
    public PerformerView getById(@PathVariable("id") int id){
        log.info("Going to get [{}] by id [{}] " , PerformerView.class.getSimpleName(), id);
        return performerViewService.getById(id);
    }

}
