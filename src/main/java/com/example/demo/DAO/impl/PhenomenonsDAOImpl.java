package com.example.demo.DAO.impl;

import com.example.demo.models.Phenomenons;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.DAO.PhenomenonsDAO;

import java.util.List;

@Repository
public class PhenomenonsDAOImpl extends CommonDAOImpl<Phenomenons, Long> implements PhenomenonsDAO {

    public PhenomenonsDAOImpl(){
        super(Phenomenons.class);
    }

    @Override
    public List<Phenomenons> getAllPhenomenonsByName(String PhenomenonName) {
        try (Session session = sessionFactory.openSession()) {
            Query<Phenomenons> query = session.createQuery("FROM phenomenons WHERE name LIKE :gotName", Phenomenons.class)
                    .setParameter("gotName", likeExpr(PhenomenonName));
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public List<Phenomenons> getAllPhenomenonsByClass(Phenomenons.EPhenomenonClass PhenomenonClass) {
        try (Session session = sessionFactory.openSession()) {
            Query<Phenomenons> query = session.createQuery("FROM phenomenons WHERE phenomenon_class = :gotClass", Phenomenons.class)
                    .setParameter("gotClass", PhenomenonClass);
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    @Override
    public List<Phenomenons> getAllObjectsInTime(Byte[] StartTime, Byte[] FinishTime) {
        try (Session session = sessionFactory.openSession()) {
            Query<Phenomenons> query = session.createQuery("FROM phenomenons WHERE start_time  :gotTime", Phenomenons.class)
                    .setParameter("gotTime", StartTime);
            return query.getResultList().size() == 0 ? null : query.getResultList();
        }
    }

    private String likeExpr(String param) {
        return "%" + param + "%";
    }
}