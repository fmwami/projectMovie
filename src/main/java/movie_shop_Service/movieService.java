package movie_shop_Service;

import movie_shop_Bal.movieBalImpl;
import movie_shop_model.movieResponse;
import movie_shop_model.movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Component
@Path("/movie")
public class movieService {
    @Autowired
    movieBalImpl movieBal;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/registerMovie")
    public Response registerMovie(movies movie){
        movieResponse response=movieBal.saveMovie(movie);
        return Response.status(200).entity(response).build();


    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/GetAllMovies")
    public Response getAllMovies(){
        List<movies> movie=movieBal.getAllMovies();
        return Response.status(200).entity(movie).build();

    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/GetAllMoviesWatched")
    public Response getAllMoviesWatched(){
        List<movies> movie=movieBal.getAllMoviesWatched();
        return Response.status(200).entity(movie).build();

    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/GetAllMoviesNotWatched")
    public Response getAllMoviesNotWatched(){
        List<movies> movie=movieBal.getAllMoviesNotWatched();
        return Response.status(200).entity(movie).build();

    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/updateMovie")
    public Response updateMovie(movies movie){
        movieResponse response=movieBal.updateMovie(movie);
        return Response.status(200).entity(response).build();


    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/deleteMovie")
    public Response deleteMovie(movies movie){
        movieResponse response=movieBal.deleteMovie(movie);
        return Response.status(200).entity(response).build();


    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/updateMovieStatus")
    public Response updateMovieStatus(movies movie){
        movieResponse response=movieBal.updateMovieStatus(movie);
        return Response.status(200).entity(response).build();


    }


}
