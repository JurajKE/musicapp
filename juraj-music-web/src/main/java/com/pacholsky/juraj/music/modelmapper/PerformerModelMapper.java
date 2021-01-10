package com.pacholsky.juraj.music.modelmapper;

import com.pacholsky.juraj.music.dto.PerformerView;
import com.pacholsky.juraj.music.dto.inner.AlbumInPerformerView;
import com.pacholsky.juraj.music.entity.Album;
import com.pacholsky.juraj.music.entity.Performer;
import org.springframework.stereotype.Component;

@Component
public class PerformerModelMapper extends AbstractModelMapper<PerformerView, Performer>{

//    private final ModelMapper modelMapper = new ModelMapper();

    public PerformerModelMapper() {
        super.modelMapper.createTypeMap(Performer.class, PerformerView.class)
                .addMapping(Performer::getPictureFolder, PerformerView::setPictureFolder)
                .setPostConverter(converter -> {

                Performer performer = converter.getSource();
                PerformerView performerView = converter.getDestination();

                for (Album album : performer.getAlbums()) {

                    AlbumInPerformerView albumInPerformerView = new AlbumInPerformerView();

                    albumInPerformerView.setName(album.getName());
                    albumInPerformerView.setAlbumId(album.getId());
                    albumInPerformerView.setAlbumDate(album.getReleaseDate());
                    albumInPerformerView.setPicture(album.getPicture());


                    performerView.getAlbums().add(albumInPerformerView);
                }
                return performerView;

            });
    }


    @Override
    public Class<PerformerView> getClassMethod() {
        return PerformerView.class;
    }

//    public PerformerView map(Performer performer) {
//        return this.modelMapper.map(performer, PerformerView.class);
//    }

}
