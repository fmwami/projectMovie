package utility;

public class QueryConstants {
    public static String getAllUsers="select * from users";
    public static String saveUsers="insert into users(userName,password,phoneNumber,address,email) values(?,?,?,?,?)";
    public static String saveMovies="insert into movies(title,description,rating,recommendation,status)values(?,?,?,?,?)";
    public static String getAllMovies="select * from movies";
    public static String getAllMoviesWatched="select * from movies where status='W'";
    public static String getAllmoviesNotWatched="select * from movies where status='NW'";
    public static String updateMovie="update movies set title=?,description=?,rating=?,recommendation=?,watched=? where movieId=? ";
    public static String deleteMovie="update movies set status='D' where movieId=?";
    public static String updateMovieStatus="update movies set status=? where movieId=?";
    public static String verifyCredentials="select userId from users where userName=? and password=?";
}
