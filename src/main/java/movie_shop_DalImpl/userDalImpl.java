package movie_shop_DalImpl;


import movie_shop_model.Users;
import movie_shop_model.movieResponse;
import utility.AES;
import utility.QueryConstants;


import javax.crypto.Cipher;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class userDalImpl {
    private DataSource dataSource;
    private final static String ALGORITHM = "AES";

    public userDalImpl(DataSource dataSource) {
        super();
        this.dataSource = dataSource;
    }
    public List<Users> getAllUsers() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = dataSource.getConnection();
            preparedStatement = connection
                    .prepareStatement(QueryConstants.getAllUsers);

            resultSet = preparedStatement.executeQuery();
            List<Users> users = new ArrayList<Users>();
            while (resultSet.next()) {
                Users user = new Users();
                user.userName = resultSet.getString("username");
                user.phoneNumber = resultSet.getString("phoneNumber");
                user.address = resultSet.getString("address");
                user.email = resultSet.getString("email");
                users.add(user);
            }
            return users;


        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public movieResponse saveUsers(Users user) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;


        try {


            connection=dataSource.getConnection();
            preparedStatement=connection.prepareStatement(QueryConstants.saveUsers);

            preparedStatement.setString(1,user.userName);
            preparedStatement.setString(2, AES.encrypt(user.password));
            preparedStatement.setString(3,user.phoneNumber);
            preparedStatement.setString(4,user.address);
            preparedStatement.setString(5,user.email);

            if (preparedStatement.executeUpdate()>0){
                return new movieResponse(200,"User saved Successfully");
            }
            return new movieResponse(201,"username already Exists");


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

    public movieResponse authentication(Users user) {
        Connection connection = null;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {

            connection=dataSource.getConnection();
            preparedStatement=connection.prepareStatement(QueryConstants.verifyCredentials);

            preparedStatement.setString(1,user.userName);
            preparedStatement.setString(2,user.password);


            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                    return new movieResponse(200,"Login success");
                } else {
                return new movieResponse(201,"Login Fail");
                }


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
