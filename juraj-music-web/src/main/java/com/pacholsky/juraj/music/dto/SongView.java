package com.pacholsky.juraj.music.dto;

import lombok.Data;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Data
public class SongView {

    private String albumName;
    private String name;
    private List<String> performerNames = new ArrayList<>();
    private int id;
    private Time lenght;
    private int albumId;
    private int performerId;
    private String albumPicture;


}
