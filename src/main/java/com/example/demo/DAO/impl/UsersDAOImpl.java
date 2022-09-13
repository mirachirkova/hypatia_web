package com.example.demo.DAO.impl;

import com.example.demo.models.Pictures;
import com.example.demo.models.Users;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.demo.DAO.UsersDAO;
import com.example.demo.models.Pictures;
import com.example.demo.DAO.impl.PicturesDAOImpl;
import com.example.demo.DAO.PicturesDAO;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class UsersDAOImpl extends CommonDAOImpl<Users, Long> implements UsersDAO {

    @Autowired
    private final PicturesDAO PicturesDAO = new PicturesDAOImpl();

    public UsersDAOImpl(){
        super(Users.class);
    }

    @Override
    public boolean checkHashPassword(String userNickname, String password) {
        try (Session session = sessionFactory.openSession()) {
            Query<Users> query = session.createQuery("FROM Users WHERE nickname = :gotName", Users.class)
                    .setParameter("gotName", userNickname);
            if (query.getResultList().size() != 0)
                return false;
            Users userToCheck = query.getResultList().get(0);

            return userToCheck.getPassword_hash() == password.hashCode() ? true : false;
        }
    }

    @Override
    public String getNicknameByPicture(Pictures PictureId) {
        return PicturesDAO.getById(PictureId.getId()).getAuthor_id().getNickname();
    }

}