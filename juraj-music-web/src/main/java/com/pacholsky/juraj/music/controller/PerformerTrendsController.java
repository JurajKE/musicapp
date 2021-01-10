package com.pacholsky.juraj.music.controller;

import com.pacholsky.juraj.music.entity.Performer;
import com.pacholsky.juraj.music.service.PerformerService;
import com.pacholsky.juraj.music.service.PerformerTrendsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/performer/trends")
public class PerformerTrendsController extends AbstractController<Performer, PerformerTrendsService>{


    @Override
    public Class<Performer> getClassMethod() {
        return Performer.class;
    }
}
