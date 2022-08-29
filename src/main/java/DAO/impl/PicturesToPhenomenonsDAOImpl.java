package DAO.impl;

import models.AstroObjects;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import DAO.PicturesToPhenomenonsDAO;
import models.PicturesToPhenomenons;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PicturesToPhenomenonsDAOImpl extends CommonDAOImpl<PicturesToPhenomenons, Long> implements PicturesToPhenomenonsDAO {

    public PicturesToPhenomenonsDAOImpl(){
        super(PicturesToPhenomenons.class);
    }

    @Override
    public List<PicturesToPhenomenons> getAllPictures(Long PhenomenonId) {
        try (Session session = sessionFactory.openSession()) {
            Query<PicturesToPhenomenons> query = session.createQuery
                            ("FROM pictures_to_phenomenons WHERE phenomenon_id = :gotId",
                                    PicturesToPhenomenons.class)
                    .setParameter("gotId", PhenomenonId);
            return query.getResultList();
        }
    }

    @Override
    public List<PicturesToPhenomenons> getAllPhenomenons(Long PictureId) {
        try (Session session = sessionFactory.openSession()) {
            Query<PicturesToPhenomenons> query = session.createQuery(
                            "FROM pictures_to_phenomenons WHERE picture_id = :gotId",
                            PicturesToPhenomenons.class)
                    .setParameter("gotId", PictureId);
            return query.getResultList();
        }
    }
}