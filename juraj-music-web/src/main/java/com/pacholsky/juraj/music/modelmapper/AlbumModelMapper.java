package com.pacholsky.juraj.music.modelmapper;

import com.pacholsky.juraj.music.dto.AlbumView;
import com.pacholsky.juraj.music.dto.inner.PerformersInAlbumView;
import com.pacholsky.juraj.music.dto.inner.SongInAlbumView;
import com.pacholsky.juraj.music.entity.Album;
import com.pacholsky.juraj.music.entity.Performer;
import com.pacholsky.juraj.music.entity.Song;
import org.springframework.stereotype.Component;

@Component
public class AlbumModelMapper extends AbstractModelMapper<AlbumView, Album>{

    public AlbumModelMapper() {
        super.modelMapper.createTypeMap(Album.class, AlbumView.class)
                .addMapping(album -> album.getPerformer().getName(), AlbumView::setPerformerName)
                .addMapping(album -> album.getPerformer().getId() , AlbumView::setPerformerId)
                .addMapping(album -> album.getPerformer().getPictureFolder() , AlbumView::setPerformerPicture)
                .addMapping(Album::getId, AlbumView::setAlbumId)
                .addMapping(Album::getPicture, AlbumView::setPicture)
                .setPostConverter(converter -> {
                    Album album = converter.getSource();
                    AlbumView albumView = converter.getDestination();

                    for (Song song : album.getSong()) {
                        SongInAlbumView songInAlbumView = new SongInAlbumView();
                        PerformersInAlbumView performersInAlbumView = new PerformersInAlbumView();

                        performersInAlbumView.setId(song.getAlbum().getPerformer().getId());

                        songInAlbumView.setId(song.getId());
                        songInAlbumView.setName(song.getName());

                        songInAlbumView.getPerformerNames().add(this.getViewFotPerformer(song.getAlbum().getPerformer()));

                        for (Performer performer : song.getFeaturesPerformers()) {
                            songInAlbumView.getPerformerNames().add(this.getViewFotPerformer(performer));


                        }


                        albumView.getSongs().add(songInAlbumView);
                        albumView.getPerformersInAlbumView().add(performersInAlbumView);
                    }
                    return albumView;
        });
    }


    @Override
    public Class<AlbumView> getClassMethod() {
        return AlbumView.class;
    }

    private PerformersInAlbumView getViewFotPerformer(Performer performer){

        PerformersInAlbumView performersInAlbumView = new PerformersInAlbumView();
        performersInAlbumView.setId(performer.getId());
        performersInAlbumView.setName(performer.getName());
        performersInAlbumView.setPicture(performer.getPictureFolder());
        return performersInAlbumView;

    }

//    public AlbumView map(Album album) {
//        return this.modelMapper.map(album, AlbumView.class);
//    }

}
