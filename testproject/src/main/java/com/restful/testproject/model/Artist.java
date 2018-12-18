package com.restful.testproject.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "artist")
public class Artist {

    private long artistUid;

    private String name;

    private List<Album> albums;

    public Artist() {

    }

    public Artist(long artistUid, String name, List<Album> albums) {
        this.artistUid = artistUid;
        this.name = name;
        this.albums = albums;
    }

    @XmlElement(required = true)
    public long getArtistUid() {
        return artistUid;
    }

    public void setArtistUid(long artistUid) {
        this.artistUid = artistUid;
    }

    @XmlElement(required = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(required = true)
    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

}
