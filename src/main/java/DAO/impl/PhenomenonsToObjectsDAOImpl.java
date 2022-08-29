package DAO.impl;

import models.AstroObjects;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import DAO.PhenomenonsToObjectsDAO;
import models.PhenomenonsToObjects;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
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