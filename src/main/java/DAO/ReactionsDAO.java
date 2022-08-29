package DAO;

import models.Reactions;

import java.util.List;

public interface ReactionsDAO extends CommonDAO<Reactions, Long> {

    Long getLikes(Long PictureId);
    Long getDistrusts(Long PictureId);

}