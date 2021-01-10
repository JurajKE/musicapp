package com.pacholsky.juraj.music.service.view;

import com.pacholsky.juraj.music.dto.PerformerView;
import com.pacholsky.juraj.music.entity.Performer;
import com.pacholsky.juraj.music.exception.ErrorCode;
import com.pacholsky.juraj.music.exception.MusicException;
import com.pacholsky.juraj.music.modelmapper.PerformerModelMapper;
import com.pacholsky.juraj.music.repository.PerformerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service("performerViewService")
public class PerformerViewService extends AbstractViewService<Performer, PerformerView>{

    @Override
    public Class<PerformerView> getClassMethod() {
        return PerformerView.class;
    }


}
