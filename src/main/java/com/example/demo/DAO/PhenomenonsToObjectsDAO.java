package com.example.demo.DAO;

import com.example.demo.models.PhenomenonsToObjects;

import java.util.List;

public interface PhenomenonsToObjectsDAO extends CommonDAO<PhenomenonsToObjects, Long> {

    List<PhenomenonsToObjects> getAllPhenomenons(Long ObjectId);
    List<PhenomenonsToObjects> getAllObjects(Long PhenomenonId);

}