package com.pacholsky.juraj.music.controller.view;

import com.pacholsky.juraj.music.dto.PerformerTrendsView;
import com.pacholsky.juraj.music.dto.PerformerView;
import com.pacholsky.juraj.music.service.view.PerformerTrendsViewService;
import com.pacholsky.juraj.music.service.view.PerformerViewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/performertrendsview")
public class PerformerViewTrendsController {

    @Autowired
    private PerformerTrendsViewService performerTrendsViewService;

    @GetMapping("/{id}")
    public PerformerTrendsView getById(@PathVariable("id") int id){
        log.info("Going to get [{}] by id [{}] " , PerformerTrendsView.class.getSimpleName(), id);
        return performerTrendsViewService.getById(id);
    }
}
