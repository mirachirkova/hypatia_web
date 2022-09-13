package com.example.demo.DAO.impl;

import com.example.demo.models.Reactions;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.DAO.ReactionsDAO;
import com.example.demo.DAO.PicturesDAO;
import com.example.demo.models.Pictures;

@Repository
public class ReactionsDAOImpl extends CommonDAOImpl<Reactions, Long> implements ReactionsDAO {

    public ReactionsDAOImpl(){
        super(Reactions.class);
    }

    @Override
    public Long getLikes(Pictures PictureId) {
        try (Session session = sessionFactory.openSession()) {
            Query<Reactions> query = session.createQuery("FROM Reactions WHERE picture_id = :gotId AND reaction = 'like'", Reactions.class)
                    .setParameter("gotId", PictureId);

            return (long) query.getResultList().size();
        }
    }

    @Override
    public Long getDistrusts(Pictures PictureId) {
        try (Session session = sessionFactory.openSession()) {
            Query<Reactions> query = session.createQuery("FROM Reactions WHERE picture_id = :gotId AND reaction = 'distrust'", Reactions.class)
                    .setParameter("gotId", PictureId);
            return (long) query.getResultList().size();
        }
    }
}