package com.example.demo.DAO;

import com.example.demo.models.Pictures;

import java.util.List;

public interface PicturesDAO extends CommonDAO<Pictures, Long> {
    String getLinkById(Long PictureId);
    List<Pictures> getAllLinksByUserId(Long UserId);

}