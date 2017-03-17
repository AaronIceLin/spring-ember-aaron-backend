package com.springember.controllers;

import com.springember.exception.EntityNotFoundException;
import com.springember.model.User;
import com.springember.store.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by aaron.lin on 3/13/17.
 */
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository repository) {
        this.userRepository = repository;
    }

    /***
     * Get User by ID
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    User  getUserById(@PathVariable("id") Integer id) {
        User user = userRepository.findUserById(id);
        if (user == null) {
            throw new EntityNotFoundException("Customer not found - id: " + id);
        }
        return user;
    }

    /***
     * Get All users
     * @return
     */
    @RequestMapping(value = "all", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    List<User> getAllUser() {
        return userRepository.getAllUsers();
    }

    /***
     * Create user
     * @param user
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    void saveUser(@Valid @RequestBody User user) {
        userRepository.save(user);
    }

    /***
     * Delete User by Id
     * @param id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    void   deleteUser(@PathVariable("id") Integer id) {
        User user = userRepository.findUserById(id);
        if (user == null) {
            throw new EntityNotFoundException("Customer not found - id: " + id);
        }
        userRepository.deleteUser(user);
    }

    /***
     * Update User
     * @param id
     * @param updatedUser
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    @ResponseStatus(HttpStatus.OK)
    User   updateUser(@PathVariable("id") Integer id, @RequestBody User updatedUser) {
        User user = userRepository.findUserById(id);
        if (user == null) {
            throw new EntityNotFoundException("Customer not found - id: " + id);
        }

        user.setFullName(updatedUser.getFullName());
        user.setPhone(updatedUser.getPhone());

        return user;
    }

}
