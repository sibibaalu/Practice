package com.restful.testproject.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.restful.testproject.model.Artist;
import com.restful.testproject.service.ArtistService;

@Path("/art")
public class ArtistResource {

    ArtistService artistService = new ArtistService();

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Artist> getAllArtists() {
        return artistService.getArtists();
    }

    @GET
    @Path("/get/artistUid/{artistUid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Artist getArtistByUid(@PathParam("artistUid") Long artistUid) {
        return artistService.getArtistByUid(artistUid);
    }
    
    
    @GET
    @Path("/get/artistName/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Artist> getArtistByName(@PathParam("name") String name) {
        return artistService.getArtistsByName(name);        
    }
    
    @GET
    @Path("/get/albumName/{albumName}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Artist> getArtistByAlbumName(@PathParam("albumName") String albumName) {
        return artistService.getArtistsByAlbumName(albumName);        
    }
    
    @GET
    @Path("/get/albumYear/{year}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Artist> getArtistByAlbumName(@PathParam("year") Integer year) {
        return artistService.getArtistsByAlbumYear(year);        
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Artist> createArtist(Artist artist) {
        artistService.create(artist);
        return artistService.getArtists();
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Artist> updateArtist(Artist artist) {
        artistService.update(artist);
        return artistService.getArtists();
    }

    @DELETE
    @Path("/delete/{artistUid}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Artist> deleteArtist(@PathParam("artistUid") Long artistUid) {
        artistService.delete(artistUid);
        return artistService.getArtists();
    }

}
