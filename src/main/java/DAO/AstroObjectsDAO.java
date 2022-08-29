package DAO;

import lombok.Builder;
import lombok.Getter;
import models.AstroObjects;

import java.util.List;

public interface AstroObjectsDAO extends CommonDAO<AstroObjects, Long> {

    List<AstroObjects> getAllObjectsByName(String ObjectName);
    List<AstroObjects> getAllObjectsByClass(AstroObjects.EObjectClass ObjectClass);
    List<AstroObjects> getAllObjectsByDiscoverer(String DiscovererName);
    List<AstroObjects> getAllObjectsByInfo(String ObjectInfo);

}