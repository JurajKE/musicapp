package com.pacholsky.juraj.music.service;

import com.pacholsky.juraj.music.entity.Performer;
import com.pacholsky.juraj.music.repository.PerformerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("PerformerTrendsService")
@Transactional
public class PerformerTrendsService extends AbstractService<Performer, PerformerRepository>{

    public Performer getById(int number){
        return super.repository.findById(number).orElseThrow();
    }

}
