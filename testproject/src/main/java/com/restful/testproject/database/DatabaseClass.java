package com.restful.testproject.database;

import java.util.HashMap;
import java.util.Map;

import com.restful.testproject.model.Artist;

public class DatabaseClass {

    /*
     * Creating this class to act as DB instance
     * Not right way to do it-reason- No thread safety
     * Implementing only for the demo purpose
     * 
     */

    private static Map<Long, Artist> artistsMap = new HashMap<Long, Artist>();

    public Long maxAlbumUid = 1L;

    public static Map<Long, Artist> getArtists() {
        return artistsMap;
    }

}
