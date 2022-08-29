package DAO.impl;

import models.AstroObjects;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import DAO.UsersDAO;
import models.Users;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UsersDAOImpl extends CommonDAOImpl<Users, Long> implements UsersDAO {

    public UsersDAOImpl(){
        super(Users.class);
    }

    @Override
    public boolean checkHashPassword(String userNickname, String password) {
        try (Session session = sessionFactory.openSession()) {
            Query<Users> query = session.createQuery("FROM users WHERE nickname = :gotName", Users.class)
                    .setParameter("gotName", userNickname);
            if (query.getResultList().size() != 0)
                return false;
            Users userToCheck = query.getResultList().get(0);

            return userToCheck.getPassword_hash() == password.hashCode() ? true : false;
        }
    }

}