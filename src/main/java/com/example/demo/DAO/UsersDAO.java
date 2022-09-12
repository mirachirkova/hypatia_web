package com.example.demo.DAO;

import com.example.demo.models.Users;

public interface UsersDAO extends CommonDAO<Users, Long> {

    //Users getSingleUserByNickname(String userNickname);
    boolean checkHashPassword(String userNickname, String password);

}