package com.example.demo.DAO;

import com.example.demo.models.PicturesToObjects;

import java.util.List;

public interface PicturesToObjectsDAO extends CommonDAO<PicturesToObjects, Long> {

    List<PicturesToObjects> getAllPictures(Long ObjectId);
    List<PicturesToObjects> getAllObjects(Long PictureId);

}