package DAO.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import DAO.AstroObjectsDAO;
import models.AstroObjects;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AstroObjectsDAOImpl extends CommonDAOImpl<AstroObjects, Long> implements AstroObjectsDAO {

    public AstroObjectsDAOImpl(){
        super(AstroObjects.class);
    }

    @Override
    public List<AstroObjects> getAllObjectsByName(String ObjectName) {
        try (Session session = sessionFactory.openSession()) {
            Query<AstroObjects> query = session.createQuery("FROM objects WHERE name LIKE :gotName", AstroObjects.class)
                    .setParameter("gotName", likeExpr(ObjectName));
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public List<AstroObjects> getAllObjectsByClass(AstroObjects.EObjectClass ObjectClass) {
        try (Session session = sessionFactory.openSession()) {
            Query<AstroObjects> query = session.createQuery("FROM objects WHERE object_class = :gotClass", AstroObjects.class)
                    .setParameter("gotClass", ObjectClass);
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public List<AstroObjects> getAllObjectsByDiscoverer(String DiscovererName) {
        try (Session session = sessionFactory.openSession()) {
            Query<AstroObjects> query = session.createQuery("FROM objects WHERE discoverer LIKE :gotDiscoverer", AstroObjects.class)
                    .setParameter("gotDiscoverer", likeExpr(DiscovererName));
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public AstroObjects getObjectByNCG(String ObjectNCGId) {
        try (Session session = sessionFactory.openSession()) {
            Query<AstroObjects> query = session.createQuery("FROM objects WHERE ncg_id = :gotNCG", AstroObjects.class)
                    .setParameter("gotNCG", ObjectNCGId);

            return query.getResultList().size() == 0 ? null : query.getResultList().get(0);
        }
    }

    @Override
    public AstroObjects getObjectByMessier(String ObjectMessierId) {
        try (Session session = sessionFactory.openSession()) {
            Query<AstroObjects> query = session.createQuery("FROM objects WHERE messier_id = :gotMessier", AstroObjects.class)
                    .setParameter("gotMessier", ObjectMessierId);

            return query.getResultList().size() == 0 ? null : query.getResultList().get(0);
        }
    }

    private String likeExpr(String param) {
        return "%" + param + "%";
    }
}