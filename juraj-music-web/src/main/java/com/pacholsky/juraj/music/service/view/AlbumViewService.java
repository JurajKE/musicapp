package com.pacholsky.juraj.music.service.view;

import com.pacholsky.juraj.music.dto.AlbumView;
import com.pacholsky.juraj.music.entity.Album;
import com.pacholsky.juraj.music.exception.ErrorCode;
import com.pacholsky.juraj.music.exception.MusicException;
import com.pacholsky.juraj.music.modelmapper.AlbumModelMapper;
import com.pacholsky.juraj.music.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service("albumViewService")
public class AlbumViewService extends AbstractViewService<Album, AlbumView>{

    @Override
    public Class<AlbumView> getClassMethod() {
        return AlbumView.class;
    }



}
