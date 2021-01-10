package com.pacholsky.juraj.music.modelmapper;

import com.pacholsky.juraj.music.dto.PlaylistView;
import com.pacholsky.juraj.music.dto.SongView;
import com.pacholsky.juraj.music.entity.Performer;
import com.pacholsky.juraj.music.entity.Playlist;
import com.pacholsky.juraj.music.entity.Song;
import com.pacholsky.juraj.music.service.PerformerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class SongModelMapper extends AbstractModelMapper<SongView, Song>{

//    private final ModelMapper modelMapper = new ModelMapper();

    public SongModelMapper(){
        this.modelMapper.createTypeMap(Song.class, SongView.class)
                .addMapping(song -> song.getAlbum().getName(), SongView::setAlbumName)
                .addMapping(song -> song.getAlbum().getId() , SongView::setAlbumId)
                .addMapping(song -> song.getAlbum().getPicture() , SongView::setAlbumPicture)
                .addMapping(song -> song.getAlbum().getPerformer().getId() , SongView::setPerformerId)
                .setPostConverter(converter -> {
                    Song song = converter.getSource();
                    SongView songView = converter.getDestination();
                    songView.getPerformerNames().add(song.getAlbum().getPerformer().getName());
                    for (Performer performer: song.getFeaturesPerformers()) {
                        songView.getPerformerNames().add(performer.getName());
                    }
                    return songView;
        });
    }

    @Override
    public Class<SongView> getClassMethod() {
        return SongView.class;
    }

//    public SongView map(Song song) {
//        return this.modelMapper.map(song, SongView.class);
//    }

}
