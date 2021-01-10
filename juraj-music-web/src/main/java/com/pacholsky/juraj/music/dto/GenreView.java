package com.pacholsky.juraj.music.dto;

import com.pacholsky.juraj.music.dto.inner.*;
import com.pacholsky.juraj.music.entity.Song;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GenreView {

    private int id;
    private String name;
    private List<SongInGenreView> songsInGenreView = new ArrayList<>();
    private List<AlbumInGenreView> albumInGenreView = new ArrayList<>();
    private List<PerformerInGenreView> performerInGenreViews = new ArrayList<>();

}
