package com.example.demo.DAO.impl;

import com.example.demo.models.AstroObjects;
import com.example.demo.models.Pictures;
import com.example.demo.models.PicturesToObjects;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.DAO.PicturesToObjectsDAO;
import com.example.demo.DAO.PicturesDAO;
import com.example.demo.DAO.impl.PicturesDAOImpl;


import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

@Repository
public class PicturesToObjectsDAOImpl extends CommonDAOImpl<PicturesToObjects, Long> implements PicturesToObjectsDAO {

    public PicturesToObjectsDAOImpl(){
        super(PicturesToObjects.class);
    }

    @Override
    public List<Pictures> getAllPictures(Long ObjectId) {
        List<Pictures> ret = new ArrayList<>();
        for (PicturesToObjects picturesToObjects : getAll()) {
            if (Objects.equals(picturesToObjects.getObject_id().getId(), ObjectId)) {
                ret.add(picturesToObjects.getPicture_id());
            }
        }
        return ret;
    }

    @Override
    public List<String> getAllPicturesLinks(Long ObjectId) {
        List<String> ret = new ArrayList<>();
        for (PicturesToObjects picturesToObjects : getAll()) {
            if (Objects.equals(picturesToObjects.getObject_id().getId(), ObjectId)) {
                ret.add(picturesToObjects.getPicture_id().getLink());
            }
        }
        return ret;
    }

    @Override
    public List<PicturesToObjects> getAllObjects(Long PictureId) {
        try (Session session = sessionFactory.openSession()) {
            Query<PicturesToObjects> query = session.createQuery(
                    "FROM PicturesToObjects WHERE picture_id = :gotId",
                            PicturesToObjects.class)
                    .setParameter("gotId", PictureId);
            return query.getResultList();
        }
    }
}