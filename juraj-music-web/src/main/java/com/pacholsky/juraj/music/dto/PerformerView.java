package com.pacholsky.juraj.music.dto;

import com.pacholsky.juraj.music.dto.inner.AlbumInPerformerView;
import com.pacholsky.juraj.music.dto.inner.SongInAlbumView;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PerformerView {

    private List<AlbumInPerformerView> albums = new ArrayList<>();
    private List<SongInAlbumView> songs = new ArrayList<>();
    private String name;
    private int id;
    private String pictureFolder;


}
