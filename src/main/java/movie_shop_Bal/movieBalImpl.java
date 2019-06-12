package movie_shop_Bal;

import movie_shop_DalImpl.movieDalImpl;
import movie_shop_model.movieResponse;
import movie_shop_model.movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class movieBalImpl {
    @Autowired
    movieDalImpl movieDal;
    public movieResponse saveMovie(movies movie) {
        return movieDal.saveMovie(movie);
    }

    public List<movies> getAllMovies() {
        return movieDal.getAllMovies();
    }

    public List<movies> getAllMoviesWatched() {
        return movieDal.getAllMoviesWatched();
    }

    public List<movies> getAllMoviesNotWatched() {
        return movieDal.getAllMoviesNotWatched();
    }

    public movieResponse updateMovie(movies movie) {
        return movieDal.updateMovie(movie);
    }

    public movieResponse deleteMovie(movies movie) {
        return movieDal.deleteMovie(movie);
    }

    public movieResponse updateMovieStatus(movies movie) {
        return movieDal.updateMovieStatus(movie);
    }
}
