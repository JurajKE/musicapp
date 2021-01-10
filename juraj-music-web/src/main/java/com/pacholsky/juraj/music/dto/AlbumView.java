package com.pacholsky.juraj.music.dto;

import com.pacholsky.juraj.music.dto.inner.PerformersInAlbumView;
import com.pacholsky.juraj.music.dto.inner.SongInAlbumView;
import lombok.Data;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

@Data
public class AlbumView {

    private int id;
    private String name;
    private String performerName;
    private int performerId;
    private int albumId;
    private List<SongInAlbumView> songs = new ArrayList<>();
    private Date releaseDate;
    private List<PerformersInAlbumView> performersInAlbumView = new ArrayList<>();
    private String picture;
    private String performerPicture;

}
