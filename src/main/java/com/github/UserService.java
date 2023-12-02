package com.github;

import com.github.user.User;

public class UserService {

    User addUser(int userId, String userName){
        return new User(userId, userName);
    }
}
