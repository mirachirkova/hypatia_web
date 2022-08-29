package DAO;

import models.Phenomenons;

import java.util.List;

public interface PhenomenonsDAO extends CommonDAO<Phenomenons, Long> {

    List<Phenomenons> getAllPhenomenonsByName(String PhenomenonName);
    List<Phenomenons> getAllPhenomenonsByClass(Phenomenons.EPhenomenonClass PhenomenonClass);
    List<Phenomenons> getAllObjectsInTime(Byte[] StartTime, Byte[] FinishTime);

}