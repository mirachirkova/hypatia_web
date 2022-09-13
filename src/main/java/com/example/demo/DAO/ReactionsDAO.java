package com.example.demo.DAO;

import com.example.demo.models.Reactions;
import com.example.demo.models.Pictures;

public interface ReactionsDAO extends CommonDAO<Reactions, Long> {

    Long getLikes(Pictures PictureId);
    Long getDistrusts(Pictures PictureId);

}