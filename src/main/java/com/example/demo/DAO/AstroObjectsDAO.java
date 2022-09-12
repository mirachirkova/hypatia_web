package com.example.demo.DAO;

import com.example.demo.models.AstroObjects;

import java.util.List;

public interface AstroObjectsDAO extends CommonDAO<AstroObjects, Long> {

    List<AstroObjects> getAllObjectsByName(String ObjectName);
    List<AstroObjects> getAllObjectsByClass(String ObjectClass);
    List<AstroObjects> getAllObjectsByDiscoverer(String DiscovererName);
    List<AstroObjects> getAllObjectsByInfo(String ObjectInfo);

}