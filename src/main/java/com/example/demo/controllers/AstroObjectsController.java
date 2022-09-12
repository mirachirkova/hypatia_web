package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.DAO.AstroObjectsDAO;
import com.example.demo.DAO.impl.AstroObjectsDAOImpl;
import com.example.demo.DAO.impl.PhenomenonsToObjectsDAOImpl;
import com.example.demo.DAO.impl.PicturesToObjectsDAOImpl;
import com.example.demo.DAO.impl.PicturesDAOImpl;
import com.example.demo.models.AstroObjects;

import java.util.List;

@Controller
public class AstroObjectsController {
    @Autowired
    private final AstroObjectsDAO astroObjectsDAO = new AstroObjectsDAOImpl();

    @Autowired
    private final PhenomenonsToObjectsDAOImpl PhenomenonsToObjectsDAO = new PhenomenonsToObjectsDAOImpl();

    @Autowired
    private final PicturesToObjectsDAOImpl PicturesToObjectsDAO = new PicturesToObjectsDAOImpl();

    @Autowired
    private final PicturesDAOImpl PicturesDAO = new PicturesDAOImpl();



    @GetMapping("/objects")
    public String objectsListPage(Model model) {
        List<AstroObjects> objects = (List<AstroObjects>) astroObjectsDAO.getAll();
        model.addAttribute("objects", objects);
        System.out.println(objects.size());
        return "objects";
    }

    @GetMapping("/object")
    public String objectPage(@RequestParam(name = "objectId") Long objectId, Model model) {
        AstroObjects object = astroObjectsDAO.getById(objectId);

        if (object == null) {
            model.addAttribute("error_msg", "В базе нет объекта с ID = " + objectId);
            return "errorPage";
        }

        model.addAttribute("object", object);
        model.addAttribute("AstroObjectsService", astroObjectsDAO);
        model.addAttribute("PhenomenonsToObjectsService", PhenomenonsToObjectsDAO);
        model.addAttribute("PicturesToObjectsService", PicturesToObjectsDAO);
        model.addAttribute("PicturesService", PicturesDAO);
        return "object";
    }
}