package com.example.demo.DAO;

import com.example.demo.models.Pictures;

public interface PicturesDAO extends CommonDAO<Pictures, Long> {
    String getLinkById(Long PictureId);

}