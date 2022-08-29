package DAO;

import models.PicturesToPhenomenons;

import java.util.List;

public interface PicturesToPhenomenonsDAO extends CommonDAO<PicturesToPhenomenons, Long> {

    List<PicturesToPhenomenons> getAllPictures(Long PhenomenonId);
    List<PicturesToPhenomenons> getAllPhenomenons(Long PictureId);

}