package com.restful.testproject.entity;

import com.restful.testproject.database.DatabaseClass;
import com.restful.testproject.model.Artist;

public class ArtistEntity {

    public void create(Artist newArtist) {
        DatabaseClass.getArtists().put(newArtist.getArtistUid(), newArtist);
    }

    public void update(Artist updatedArtist) {
        DatabaseClass.getArtists().replace(updatedArtist.getArtistUid(), updatedArtist);
    }

    public void delete(Long deletedArtistUid) {
        DatabaseClass.getArtists().remove(deletedArtistUid);
    }

}
