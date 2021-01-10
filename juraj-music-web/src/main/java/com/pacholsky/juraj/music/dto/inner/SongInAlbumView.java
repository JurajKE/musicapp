package com.pacholsky.juraj.music.dto.inner;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SongInAlbumView {

    private String name;
    private int id;
    private List<PerformersInAlbumView> performerNames = new ArrayList<>();

}
