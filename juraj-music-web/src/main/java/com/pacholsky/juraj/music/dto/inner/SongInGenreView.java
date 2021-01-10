package com.pacholsky.juraj.music.dto.inner;

import lombok.Data;

@Data
public class SongInGenreView {

    private int id;
    private String name;
    private String performerName;
    private String songPictureFolder;

}
