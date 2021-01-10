package com.pacholsky.juraj.music.modelmapper;

import com.pacholsky.juraj.music.dto.PerformerTrendsView;
import com.pacholsky.juraj.music.dto.PerformerView;
import com.pacholsky.juraj.music.dto.inner.AlbumInPerformerView;
import com.pacholsky.juraj.music.dto.inner.PerformersInAlbumView;
import com.pacholsky.juraj.music.dto.inner.SongInAlbumView;
import com.pacholsky.juraj.music.entity.Album;
import com.pacholsky.juraj.music.entity.Performer;
import com.pacholsky.juraj.music.entity.Song;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Component
public class PerformerTrendsModelMapper extends AbstractModelMapper<PerformerTrendsView, Performer>{

    public PerformerTrendsModelMapper() {
        super.modelMapper.createTypeMap(Performer.class, PerformerTrendsView.class)
                .setPostConverter(converter -> {

                    Performer performer = converter.getSource();
                    PerformerTrendsView performerView = converter.getDestination();
                    List<SongInAlbumView> songs = new ArrayList<>();

                    for (Album album : performer.getAlbums()) {

                        for (Song song : album.getSong()) {
                            SongInAlbumView songInAlbumView = new SongInAlbumView();

                            songInAlbumView.setId(song.getId());
                            songInAlbumView.setName(song.getName());

                            songInAlbumView.getPerformerNames().add(this.getViewFotPerformer(song.getAlbum().getPerformer()));

                            for (Performer performers : song.getFeaturesPerformers()) {
                                songInAlbumView.getPerformerNames().add(this.getViewFotPerformer(performers));
                            }
                            songs.add(songInAlbumView);

                        }


                        Collections.shuffle(songs);
                        performerView.setSongs(songs.subList(0, Math.min(songs.size(), 5)));

                    }
                    return performerView;

                });
    }





    @Override
    public Class<PerformerTrendsView> getClassMethod() {
        return PerformerTrendsView.class;
    }

        private PerformersInAlbumView getViewFotPerformer(Performer performer){

            PerformersInAlbumView performersInAlbumView = new PerformersInAlbumView();
            performersInAlbumView.setId(performer.getId());
            performersInAlbumView.setName(performer.getName());
            return performersInAlbumView;

        }

}
