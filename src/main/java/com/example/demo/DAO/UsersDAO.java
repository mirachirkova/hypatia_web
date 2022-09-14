package com.example.demo.DAO;

import com.example.demo.models.Users;
import com.example.demo.models.Pictures;

public interface UsersDAO extends CommonDAO<Users, Long> {

    //Users getSingleUserByNickname(String userNickname);
    boolean checkHashPassword(String userNickname, String password);
    String getNicknameByPicture(Pictures PictureId);
    Users getByNickname(String userNickname);

}