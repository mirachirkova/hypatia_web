package com.example.demo.DAO.impl;

import com.example.demo.models.Reactions;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.DAO.ReactionsDAO;

@Repository
public class ReactionsDAOImpl extends CommonDAOImpl<Reactions, Long> implements ReactionsDAO {

    public ReactionsDAOImpl(){
        super(Reactions.class);
    }

    @Override
    public Long getLikes(Long PictureId) {
        try (Session session = sessionFactory.openSession()) {
            Query<Reactions> query = session.createQuery("FROM reactions WHERE picture_id = :gotId AND reaction = 'like'", Reactions.class)
                    .setParameter("gotId", PictureId);

            return new Long(query.getResultList().size());
        }
    }

    @Override
    public Long getDistrusts(Long PictureId) {
        try (Session session = sessionFactory.openSession()) {
            Query<Reactions> query = session.createQuery("FROM reactions WHERE picture_id = :gotId AND reaction = 'distrust'", Reactions.class)
                    .setParameter("gotId", PictureId);
            return new Long(query.getResultList().size());
        }
    }
}