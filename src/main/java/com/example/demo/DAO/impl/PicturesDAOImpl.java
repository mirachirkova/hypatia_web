package com.example.demo.DAO.impl;

import com.example.demo.models.Pictures;
import org.springframework.stereotype.Repository;
import com.example.demo.DAO.PicturesDAO;

@Repository
public class PicturesDAOImpl extends CommonDAOImpl<Pictures, Long> implements PicturesDAO {

    public PicturesDAOImpl(){
        super(Pictures.class);
    }

}