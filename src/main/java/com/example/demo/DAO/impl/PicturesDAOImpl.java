package com.example.demo.DAO.impl;

import com.example.demo.models.PicturesToObjects;
import com.example.demo.models.Users;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.DAO.PicturesToObjectsDAO;
import com.example.demo.models.Pictures;
import org.springframework.stereotype.Repository;
import com.example.demo.DAO.PicturesDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Repository
public class PicturesDAOImpl extends CommonDAOImpl<Pictures, Long> implements PicturesDAO {


    public PicturesDAOImpl(){
        super(Pictures.class);
    }

    @Override
    public String getLinkById(Long PictureId) {
        try (Session session = sessionFactory.openSession()) {
            Query<Pictures> query = session.createQuery("FROM Pictures WHERE id = :gotName", Pictures.class)
                    .setParameter("gotName", PictureId);
            if (query.getResultList().size() == 0)
                return null;
            return query.getResultList().get(0).getLink();
        }
    }

    @Override
    public List<Pictures> getAllLinksByUserId(Long UserId) {
        List<Pictures> ret = new ArrayList<>();
        for (Pictures pictures : getAll()) {
            if (Objects.equals(pictures.getAuthor_id().getId(), UserId)) {
                ret.add(pictures);
            }
        }
        return ret;
    }

}