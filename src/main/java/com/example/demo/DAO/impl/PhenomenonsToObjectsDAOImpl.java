package com.example.demo.DAO.impl;

import com.example.demo.models.PhenomenonsToObjects;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.DAO.PhenomenonsToObjectsDAO;

import java.util.List;

@Repository
public class PhenomenonsToObjectsDAOImpl extends CommonDAOImpl<PhenomenonsToObjects, Long> implements PhenomenonsToObjectsDAO {

    public PhenomenonsToObjectsDAOImpl(){
        super(PhenomenonsToObjects.class);
    }

    @Override
    public List<PhenomenonsToObjects> getAllPhenomenons(Long ObjectId) {
        try (Session session = sessionFactory.openSession()) {
            Query<PhenomenonsToObjects> query = session.createQuery("FROM phenomenons_to_objects WHERE object_id = :gotId", PhenomenonsToObjects.class)
                    .setParameter("gotId", ObjectId);
            return query.getResultList();
        }
    }

    @Override
    public List<PhenomenonsToObjects> getAllObjects(Long PhenomenonId) {
        try (Session session = sessionFactory.openSession()) {
            Query<PhenomenonsToObjects> query = session.createQuery("FROM phenomenons_to_objects WHERE phenomenon_id = :gotId", PhenomenonsToObjects.class)
                    .setParameter("gotId", PhenomenonId);
            return query.getResultList();
        }
    }
}