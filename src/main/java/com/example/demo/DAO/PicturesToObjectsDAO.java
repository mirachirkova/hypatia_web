package com.example.demo.DAO;

import com.example.demo.models.Pictures;
import com.example.demo.models.PicturesToObjects;

import java.util.List;

public interface PicturesToObjectsDAO extends CommonDAO<PicturesToObjects, Long> {

    List<Pictures> getAllPictures(Long ObjectId);
    List<String> getAllPicturesLinks(Long ObjectId);
    List<PicturesToObjects> getAllObjects(Long PictureId);

}