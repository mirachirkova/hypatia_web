package DAO.impl;

import models.AstroObjects;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import DAO.PhenomenonsDAO;
import models.Phenomenons;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
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