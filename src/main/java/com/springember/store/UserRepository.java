package com.springember.store;

import com.springember.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aaron.lin on 3/12/17.
 */
@Repository
public class UserRepository {

    private static List<User> users = new ArrayList<>(3);
    private static int newId;

    static {
        users.add(new User(++newId, "Jason Mraz", "11-111-111"));
        users.add(new User(++newId, "Johon Legend", "22-222-222"));
        users.add(new User(++newId, "Bruno Mars", "33-333-333"));
    }

    /***
     * Find User by id
     * @param id
     * @return
     */
    public User findUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    /***
     * Get all users
     * @return
     */
    public List<User> getAllUsers(){
        List<User> list = new ArrayList<>();
        for (User user : users) {
            list.add(user);
        }
        return list;
    }

    /***
     * Save user
     * @param user
     */
    public void save(User user) {
        if(users.size() == 0){
            user.setId(++newId);
            users.add(user);
        }else{
            user.setId(++newId);
            users.add(user);
        }
    }

    /**
     * Delete user
     * @param user
     */
    public void deleteUser(User user){
        users.remove(user);
    }
}
