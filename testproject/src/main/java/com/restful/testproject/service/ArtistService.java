package com.restful.testproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.restful.testproject.database.DatabaseClass;
import com.restful.testproject.entity.ArtistEntity;
import com.restful.testproject.model.Album;
import com.restful.testproject.model.Artist;

public class ArtistService {

    private Map<Long, Artist> artists = DatabaseClass.getArtists();

    ArtistEntity artistEntity = new ArtistEntity();

    public ArtistService() {
        // Adding default Artist information
        addDefaultArtist();
    }

    public List<Artist> getArtists() {
        return new ArrayList<Artist>(artists.values());
    }

    public Artist getArtistByUid(Long artistUid) {
        return artists.get(artistUid);
    }

    public List<Artist> getArtistsByName(String name) {
        List<Artist> returnList = new ArrayList<Artist>();
        for (Artist ar : artists.values()) {
            if (ar.getName().equals(name)) {
                returnList.add(ar);
            }
        }
        return returnList;
    }

    public List<Artist> getArtistsByAlbumName(String albumName) {
        List<Artist> returnList = new ArrayList<Artist>();
        for (Artist ar : artists.values()) {
            for (Album album : ar.getAlbums()) {
                if (album.getAlbumName().equals(albumName)) {
                    returnList.add(ar);
                }
            }
        }
        return returnList;
    }

    public List<Artist> getArtistsByAlbumYear(Integer albumYear) {
        List<Artist> returnList = new ArrayList<Artist>();
        for (Artist ar : artists.values()) {
            for (Album album : ar.getAlbums()) {
                if (album.getYear().equals(albumYear)) {
                    returnList.add(ar);
                }
            }
        }
        return returnList;
    }

    public void create(Artist newArtist) {
        newArtist.setArtistUid(artists.size() + 1L);
        long maxAlbumUid = getMaxAlbumUid();
        for (Album albumInternal : newArtist.getAlbums()) {
            albumInternal.setAlbumUid(maxAlbumUid++);
            albumInternal.setArtistUid(newArtist.getArtistUid());
        }
        artistEntity.create(newArtist);
    }

    public void update(Artist artist) {
        artistEntity.update(artist);
    }

    public void delete(Long artistUid) {
        artistEntity.delete(artistUid);

    }

    private void addDefaultArtist() {

        List<String> trackListMJ = new ArrayList<String>();
        trackListMJ.add("Beat It");
        trackListMJ.add("Billie Jean");
        trackListMJ.add("Human Natur");
        trackListMJ.add("P.Y.T. (Pretty Young Thing)");
        trackListMJ.add("he Lady in My Life");

        Album albumMJ1 = new Album(1L, "Thriller", 1982, 1L, trackListMJ);
        Album albumMJ2 = new Album(2L, "The Dude", 1981, 1L, trackListMJ);
        List<Album> albumList = new ArrayList<Album>();
        albumList.add(albumMJ1);
        albumList.add(albumMJ2);

        Artist artistMJ = new Artist(1L, "MJ", albumList);

        artists.put(artistMJ.getArtistUid(), artistMJ);

        List<String> trackListBB = new ArrayList<String>();
        trackListBB.add("I Want It That Way");
        trackListBB.add("Larger than Life");
        trackListBB.add("Show Me the Meaning of Being Lonely");
        trackListBB.add("The One");

        Album albumBB = new Album(3L, "Millennium", 1998, 2L, trackListBB);
        List<Album> albumListBB = new ArrayList<Album>();
        albumListBB.add(albumBB);

        Artist artistBB = new Artist(2L, "BackStreet Boys", albumListBB);

        artists.put(artistBB.getArtistUid(), artistBB);

    }

    private Long getMaxAlbumUid() {
        long maxAlbumUid = 1L;
        for (Artist art : artists.values()) {
            for (Album alb : art.getAlbums()) {
                maxAlbumUid++;
            }
        }

        return maxAlbumUid;
    }
}
