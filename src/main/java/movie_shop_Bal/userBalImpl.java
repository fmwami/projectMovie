package movie_shop_Bal;

import movie_shop_DalImpl.userDalImpl;
import movie_shop_model.Users;
import movie_shop_model.movieResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class userBalImpl {
    @Autowired
    userDalImpl userDal;
    public List<Users> GetAllUsers() {
        return userDal.getAllUsers();
    }

    public movieResponse saveUsers(Users user) {
        return userDal.saveUsers(user);
    }

    public movieResponse authentication(Users user) {
        return userDal.authentication(user);
    }
}
