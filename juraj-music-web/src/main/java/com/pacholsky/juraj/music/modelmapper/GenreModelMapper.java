package com.pacholsky.juraj.music.modelmapper;

import com.pacholsky.juraj.music.dto.GenreView;
import com.pacholsky.juraj.music.dto.inner.AlbumInGenreView;
import com.pacholsky.juraj.music.dto.inner.PerformerInGenreView;
import com.pacholsky.juraj.music.dto.inner.SongInGenreView;
import com.pacholsky.juraj.music.entity.Genre;
import com.pacholsky.juraj.music.entity.Song;
import org.springframework.stereotype.Component;

@Component
public class GenreModelMapper extends AbstractModelMapper<GenreView, Genre>{

    public GenreModelMapper() {
        super.modelMapper.createTypeMap(Genre.class, GenreView.class)
                .addMapping(Genre::getName, GenreView::setName)
                .addMapping(Genre::getId , GenreView::setId)
                .setPostConverter(converter -> {

                    Genre genre = converter.getSource();
                    GenreView genreView = converter.getDestination();

                    for (Song song : genre.getSongs()){
                        SongInGenreView songInGenreView = new SongInGenreView();
                        songInGenreView.setName(song.getName());
                        songInGenreView.setId(song.getId());
                        songInGenreView.setPerformerName(song.getAlbum().getPerformer().getName());
                        songInGenreView.setSongPictureFolder(song.getAlbum().getPicture());

                        AlbumInGenreView albumInGenreView = new AlbumInGenreView();
                        albumInGenreView.setAlbumName(song.getAlbum().getName());
                        albumInGenreView.setPerformerName(song.getAlbum().getPerformer().getName());
                        albumInGenreView.setId(song.getAlbum().getId());
                        albumInGenreView.setAlbumPictureFolder(song.getAlbum().getPicture());

                        PerformerInGenreView performerInGenreView = new PerformerInGenreView();
                        performerInGenreView.setPerformerName(song.getAlbum().getPerformer().getName());
                        performerInGenreView.setPictureFolder(song.getAlbum().getPerformer().getPictureFolder());
                        performerInGenreView.setId(song.getAlbum().getPerformer().getId());

                        genreView.getSongsInGenreView().add(songInGenreView);
                        genreView.getAlbumInGenreView().add(albumInGenreView);
                        genreView.getPerformerInGenreViews().add(performerInGenreView);

                    }
                    return genreView;
                });
    }


    @Override
    public Class<GenreView> getClassMethod() {
        return GenreView.class;
    }
}
