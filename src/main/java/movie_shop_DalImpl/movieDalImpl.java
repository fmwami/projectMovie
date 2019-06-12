package movie_shop_DalImpl;

import movie_shop_model.Users;
import movie_shop_model.movieResponse;
import movie_shop_model.movies;
import utility.QueryConstants;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class movieDalImpl {

    private DataSource dataSource;

    public movieDalImpl(DataSource dataSource) {
        super();
        this.dataSource = dataSource;
    }
    public movieResponse saveMovie(movies movie) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {

            connection=dataSource.getConnection();
            preparedStatement=connection.prepareStatement(QueryConstants.saveMovies);

            preparedStatement.setString(1,movie.title);
            preparedStatement.setString(2,movie.description);
            preparedStatement.setString(3,movie.rating);
            preparedStatement.setString(4,movie.recommendation);
            preparedStatement.setString(5,movie.watched);


            if (preparedStatement.executeUpdate()>0){
                return new movieResponse(200,"Movie saved Successfully");
            }
            return new movieResponse(201,"Failed to save");


        }catch(Exception ex){
            ex.printStackTrace();
            return new movieResponse(204,"Exception Occurred");

        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<movies> getAllMovies() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = dataSource.getConnection();
            preparedStatement = connection
                    .prepareStatement(QueryConstants.getAllMovies);

            resultSet = preparedStatement.executeQuery();
            List<movies> movies = new ArrayList<movies>();
            while (resultSet.next()) {
                movies movie = new movies();
                movie.title = resultSet.getString("title");
                movie.description = resultSet.getString("description");
                movie.rating = resultSet.getString("rating");
                movie.recommendation = resultSet.getString("recommendation");
                movies.add(movie);
            }
            return movies;


        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public List<movies> getAllMoviesWatched() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = dataSource.getConnection();
            preparedStatement = connection
                    .prepareStatement(QueryConstants.getAllMoviesWatched);

            resultSet = preparedStatement.executeQuery();
            List<movies> movies = new ArrayList<movies>();
            while (resultSet.next()) {
                movies movie = new movies();
                movie.title = resultSet.getString("title");
                movie.description = resultSet.getString("description");
                movie.rating = resultSet.getString("rating");
                movie.recommendation = resultSet.getString("recommendation");
                movies.add(movie);
            }
            return movies;


        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public List<movies> getAllMoviesNotWatched() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = dataSource.getConnection();
            preparedStatement = connection
                    .prepareStatement(QueryConstants.getAllmoviesNotWatched);

            resultSet = preparedStatement.executeQuery();
            List<movies> movies = new ArrayList<movies>();
            while (resultSet.next()) {
                movies movie = new movies();
                movie.title = resultSet.getString("title");
                movie.description = resultSet.getString("description");
                movie.rating = resultSet.getString("rating");
                movie.recommendation = resultSet.getString("recommendation");
                movies.add(movie);
            }
            return movies;


        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public movieResponse updateMovie(movies movie) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {

            connection=dataSource.getConnection();
            preparedStatement=connection.prepareStatement(QueryConstants.updateMovie);

            preparedStatement.setString(1,movie.title);
            preparedStatement.setString(2,movie.description);
            preparedStatement.setString(3,movie.rating);
            preparedStatement.setString(4,movie.recommendation);
            preparedStatement.setString(5,movie.movieId);


            if (preparedStatement.executeUpdate()>0){
                return new movieResponse(200,"Movie Updated");
            }
            return new movieResponse(201,"Failed to update");


        }catch(Exception ex){
            ex.printStackTrace();
            return new movieResponse(204,"Exception Occurred");

        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public movieResponse deleteMovie(movies movie) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {

            connection=dataSource.getConnection();
            preparedStatement=connection.prepareStatement(QueryConstants.deleteMovie);

            preparedStatement.setString(1,movie.movieId);



            if (preparedStatement.executeUpdate()>0){
                return new movieResponse(200,"Movie deleted successfully");
            }
            return new movieResponse(201,"Failed to delete");


        }catch(Exception ex){
            ex.printStackTrace();
            return new movieResponse(204,"Exception Occurred");

        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public movieResponse updateMovieStatus(movies movie) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {

            connection=dataSource.getConnection();
            preparedStatement=connection.prepareStatement(QueryConstants.updateMovieStatus);

            preparedStatement.setString(1,movie.movieId);
            preparedStatement.setString(2,movie.watched);



            if (preparedStatement.executeUpdate()>0){
                return new movieResponse(200,"Status saved Successfully");
            }
            return new movieResponse(201,"Failed to update");


        }catch(Exception ex){
            ex.printStackTrace();
            return new movieResponse(204,"Exception Occurred");

        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
