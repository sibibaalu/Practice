package com.restful.testproject.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "album")
public class Album {

    private long albumUid;
    private String albumName;
    private Integer year;
    private long artistUid;
    private List<String> trackList;

    public Album() {

    }

    public Album(long albumUid, String albumName, Integer year, long artistUid, List<String> trackList) {
        this.albumUid = albumUid;
        this.albumName = albumName;
        this.year = year;
        this.artistUid = artistUid;
        this.trackList = trackList;
    }

    @XmlElement(required = true)
    public Long getAlbumUid() {
        return albumUid;
    }

    public void setAlbumUid(Long albumUid) {
        this.albumUid = albumUid;
    }

    @XmlElement(required = true)
    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    @XmlElement(required = true)
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @XmlElement(required = true)
    public Long getArtistUid() {
        return artistUid;
    }

    public void setArtistUid(Long artistUid) {
        this.artistUid = artistUid;
    }

    @XmlElement(required = true)
    public List<String> getTrackList() {
        return trackList;
    }

    public void setTrackList(List<String> trackList) {
        this.trackList = trackList;
    }

}
