package DAO;

import models.PhenomenonsToObjects;

import java.util.List;

public interface PhenomenonsToObjectsDAO extends CommonDAO<PhenomenonsToObjects, Long> {

    List<PhenomenonsToObjects> getAllPhenomenons(Long ObjectId);
    List<PhenomenonsToObjects> getAllObjects(Long PhenomenonId);

}