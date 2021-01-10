package com.pacholsky.juraj.music.dto.inner;

import lombok.Data;

import java.sql.Date;

@Data
public class AlbumInPerformerView {

    private int albumId;
    private String name;
    private Date albumDate;
    private String picture;


}
