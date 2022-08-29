package DAO.impl;

import models.AstroObjects;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import DAO.PicturesToObjectsDAO;
import models.PicturesToObjects;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PicturesToObjectsDAOImpl extends CommonDAOImpl<PicturesToObjects, Long> implements PicturesToObjectsDAO {

    public PicturesToObjectsDAOImpl(){
        super(PicturesToObjects.class);
    }

    @Override
    public List<PicturesToObjects> getAllPictures(Long ObjectId) {
        try (Session session = sessionFactory.openSession()) {
            Query<PicturesToObjects> query = session.createQuery
                            ("FROM pictures_to_objects WHERE object_id = :gotId",
                                    PicturesToObjects.class)
                    .setParameter("gotId", ObjectId);
            return query.getResultList();
        }
    }

    @Override
    public List<PicturesToObjects> getAllObjects(Long PictureId) {
        try (Session session = sessionFactory.openSession()) {
            Query<PicturesToObjects> query = session.createQuery(
                    "FROM pictures_to_objects WHERE picture_id = :gotId",
                            PicturesToObjects.class)
                    .setParameter("gotId", PictureId);
            return query.getResultList();
        }
    }
}