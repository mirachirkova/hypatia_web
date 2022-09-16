package com.example.demo.DAO.impl;

import com.example.demo.models.AstroObjects;
import com.example.demo.models.Pictures;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.DAO.AstroObjectsDAO;


import java.util.List;

@Repository
public class AstroObjectsDAOImpl extends CommonDAOImpl<AstroObjects, Long> implements AstroObjectsDAO {

    public AstroObjectsDAOImpl(){
        super(AstroObjects.class);
    }

    @Override
    public List<AstroObjects> getAllObjectsByName(String ObjectName) {
        try (Session session = sessionFactory.openSession()) {
            Query<AstroObjects> query = session.createQuery("FROM AstroObjects WHERE name LIKE :gotName", AstroObjects.class)
                    .setParameter("gotName", likeExpr(ObjectName));
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public List<AstroObjects> getAllObjectsByClass(String ObjectClass) {
        try (Session session = sessionFactory.openSession()) {
            Query<AstroObjects> query = session.createQuery("FROM AstroObjects WHERE object_class = :gotClass", AstroObjects.class)
                    .setParameter("gotClass", ObjectClass);
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public List<AstroObjects> getAllObjectsByDiscoverer(String DiscovererName) {
        try (Session session = sessionFactory.openSession()) {
            Query<AstroObjects> query = session.createQuery("FROM AstroObjects WHERE discoverer LIKE :gotDiscoverer", AstroObjects.class)
                    .setParameter("gotDiscoverer", likeExpr(DiscovererName));
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public List<AstroObjects> getAllObjectsByInfo(String ObjectInfo) {
        try (Session session = sessionFactory.openSession()) {
            Query<AstroObjects> query = session.createQuery("FROM AstroObjects WHERE info LIKE :gotInfo", AstroObjects.class)
                    .setParameter("gotInfo", likeExpr(ObjectInfo));
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public String getNameById(Long ObjectId) {
        try (Session session = sessionFactory.openSession()) {
            Query<AstroObjects> query = session.createQuery("FROM AstroObjects WHERE id = :gotName", AstroObjects.class)
                    .setParameter("gotName", ObjectId);
            if (query.getResultList().size() == 0)
                return null;
            return query.getResultList().get(0).getName();
        }
    }

    private String likeExpr(String param) {
        return "%" + param + "%";
    }
}