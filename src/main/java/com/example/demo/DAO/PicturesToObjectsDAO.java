package com.example.demo.DAO;

import com.example.demo.models.AstroObjects;
import com.example.demo.models.Pictures;
import com.example.demo.models.PicturesToObjects;

import java.util.List;
import java.util.Objects;

public interface PicturesToObjectsDAO extends CommonDAO<PicturesToObjects, Long> {

    List<Pictures> getAllPictures(Long ObjectId);
    List<String> getAllPicturesLinks(Long ObjectId);
    List<AstroObjects> getAllObjects(Long PictureId);

}