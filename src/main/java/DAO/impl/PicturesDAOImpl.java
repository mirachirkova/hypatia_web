package DAO.impl;

import models.AstroObjects;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import DAO.PicturesDAO;
import models.Pictures;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PicturesDAOImpl extends CommonDAOImpl<Pictures, Long> implements PicturesDAO {

    public PicturesDAOImpl(){
        super(Pictures.class);
    }

}