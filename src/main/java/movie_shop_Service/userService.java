package movie_shop_Service;

import movie_shop_Bal.userBalImpl;
import movie_shop_model.Users;
import movie_shop_model.movieResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Component
@Path("/userService")
public class userService {
    @Autowired
    userBalImpl userBal;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/gtAllUsers")
  public Response GetAllApplications() {
      List<Users> user = userBal.GetAllUsers();
      return Response.status(200).entity(user).build();
  }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/registerUser")
    public Response registerUsers(Users user) {
      movieResponse response=userBal.saveUsers(user);
      return Response.status(200).entity(response).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/Login")
    public Response Authentication(Users user) {
        movieResponse response=userBal.authentication(user);
        return Response.status(200).entity(response).build();
    }



}
