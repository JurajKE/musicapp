package com.pacholsky.juraj.music.service.view;

import com.pacholsky.juraj.music.dto.PerformerTrendsView;
import com.pacholsky.juraj.music.dto.PerformerView;
import com.pacholsky.juraj.music.entity.Performer;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service("performerTrendsViewService")
public class PerformerTrendsViewService extends AbstractViewService<Performer, PerformerTrendsView>{

    @Override
    public Class<PerformerTrendsView> getClassMethod() {
        return PerformerTrendsView.class;
    }
}
