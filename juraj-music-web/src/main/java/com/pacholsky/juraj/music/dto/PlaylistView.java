package com.pacholsky.juraj.music.dto;

import com.pacholsky.juraj.music.dto.inner.SongInAlbumView;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PlaylistView {

    private String name;
    private List<SongInAlbumView> songs = new ArrayList<>();
    private int id;


}
