package com.pacholsky.juraj.music.service.view;

import com.pacholsky.juraj.music.dto.PerformerView;
import com.pacholsky.juraj.music.dto.PlaylistView;
import com.pacholsky.juraj.music.entity.Playlist;
import com.pacholsky.juraj.music.exception.ErrorCode;
import com.pacholsky.juraj.music.exception.MusicException;
import com.pacholsky.juraj.music.modelmapper.PerformerModelMapper;
import com.pacholsky.juraj.music.modelmapper.PlaylistModelMapper;
import com.pacholsky.juraj.music.repository.PerformerRepository;
import com.pacholsky.juraj.music.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service("playlistViewService")
public class PlaylistViewService extends AbstractViewService<Playlist, PlaylistView>{

    @Override
    public Class<PlaylistView> getClassMethod() {
        return PlaylistView.class;
    }


}
