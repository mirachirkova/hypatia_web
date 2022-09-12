package com.example.demo.DAO;

import com.example.demo.models.Reactions;

public interface ReactionsDAO extends CommonDAO<Reactions, Long> {

    Long getLikes(Long PictureId);
    Long getDistrusts(Long PictureId);

}