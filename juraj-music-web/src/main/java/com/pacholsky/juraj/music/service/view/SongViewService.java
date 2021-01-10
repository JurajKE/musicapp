package com.pacholsky.juraj.music.service.view;

import com.pacholsky.juraj.music.dto.PlaylistView;
import com.pacholsky.juraj.music.dto.SongView;
import com.pacholsky.juraj.music.entity.Song;
import com.pacholsky.juraj.music.exception.ErrorCode;
import com.pacholsky.juraj.music.exception.MusicException;
import com.pacholsky.juraj.music.modelmapper.PlaylistModelMapper;
import com.pacholsky.juraj.music.modelmapper.SongModelMapper;
import com.pacholsky.juraj.music.repository.PlaylistRepository;
import com.pacholsky.juraj.music.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service("songViewService")
public class SongViewService extends AbstractViewService<Song, SongView>{

    @Override
    public Class<SongView> getClassMethod() {
        return SongView.class;
    }


}
