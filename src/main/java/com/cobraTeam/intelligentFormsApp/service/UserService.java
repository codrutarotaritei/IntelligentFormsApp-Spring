package com.cobraTeam.intelligentFormsApp.service;

import com.cobraTeam.intelligentFormsApp.entity.User;

import java.util.Iterator;
import java.util.List;

public interface UserService {

    User create(User user);

    List<User> getAllUsers();

//    User save(User user);
}
