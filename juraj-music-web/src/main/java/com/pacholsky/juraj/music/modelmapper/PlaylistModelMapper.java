package com.pacholsky.juraj.music.modelmapper;

import com.pacholsky.juraj.music.dto.PerformerView;
import com.pacholsky.juraj.music.dto.PlaylistView;
import com.pacholsky.juraj.music.dto.inner.PerformersInAlbumView;
import com.pacholsky.juraj.music.dto.inner.SongInAlbumView;
import com.pacholsky.juraj.music.entity.Performer;
import com.pacholsky.juraj.music.entity.Playlist;
import com.pacholsky.juraj.music.entity.Song;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PlaylistModelMapper extends AbstractModelMapper<PlaylistView, Playlist>{


//    private final ModelMapper modelMapper = new ModelMapper();

    public PlaylistModelMapper() {
        super.modelMapper.createTypeMap(Playlist.class, PlaylistView.class)
                .setPostConverter(converter -> {

                    Playlist playlist = converter.getSource();
                    PlaylistView playlistView = converter.getDestination();

                    for (Song song : playlist.getSongs()) {
                        SongInAlbumView songInAlbumView = new SongInAlbumView();
                        songInAlbumView.setName(song.getName());
                        songInAlbumView.setId(song.getId());
                        songInAlbumView.getPerformerNames().add(this.getViewFotPerformer(song.getAlbum().getPerformer()));

                        for (Performer performer : song.getFeaturesPerformers()){
                            songInAlbumView.getPerformerNames().add(this.getViewFotPerformer(performer));
                        }
                        playlistView.getSongs().add(songInAlbumView);
                    }
                    return playlistView;

                });
    }

    private PerformersInAlbumView getViewFotPerformer(Performer performer){

        PerformersInAlbumView performersInAlbumView = new PerformersInAlbumView();
        performersInAlbumView.setId(performer.getId());
        performersInAlbumView.setName(performer.getName());
        return performersInAlbumView;

    }

    @Override
    public Class<PlaylistView> getClassMethod() {
        return PlaylistView.class;
    }

//    public PlaylistView map(Playlist playlist) {
//        return this.modelMapper.map(playlist, PlaylistView.class);
//    }

}
