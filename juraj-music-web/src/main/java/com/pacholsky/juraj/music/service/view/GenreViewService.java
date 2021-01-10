package com.pacholsky.juraj.music.service.view;

import com.pacholsky.juraj.music.dto.AlbumView;
import com.pacholsky.juraj.music.dto.GenreView;
import com.pacholsky.juraj.music.entity.Album;
import com.pacholsky.juraj.music.entity.Genre;
import com.pacholsky.juraj.music.exception.ErrorCode;
import com.pacholsky.juraj.music.exception.MusicException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service("genreViewService")
public class GenreViewService extends AbstractViewService<Genre, GenreView>{


    @Override
    public Class<GenreView> getClassMethod() {
        return GenreView.class;
    }




}
