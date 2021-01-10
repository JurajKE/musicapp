package com.pacholsky.juraj.music.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name="playlist")
@SequenceGenerator(name = "Playlist_Seq" , sequenceName = "Playlist_Seq" , initialValue = 1, allocationSize = 1)
@AllArgsConstructor
@NoArgsConstructor
public class Playlist implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =  "Playlist_Seq")
    private int id;
    private String name;
    private Date createTimestamp;

    @ManyToMany()
    @JsonIgnoreProperties({"playlistList"})
    @JoinTable(name = "user_follows_playlist" , joinColumns = {@JoinColumn(name = "playlist_id")} , inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private List<User> users = new ArrayList<>();

    @ManyToOne()
    @JsonIgnoreProperties({"playlists"})
    private User user;

    @ManyToMany()
    @JsonIgnoreProperties({"playlists"})
    @JoinTable(name = "playlist_contains_song" , joinColumns = {@JoinColumn(name = "playlist_id")} , inverseJoinColumns = {@JoinColumn(name = "song_id")})
    private List<Song> songs = new ArrayList<>();

}
