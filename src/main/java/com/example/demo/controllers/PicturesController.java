package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.DAO.impl.PicturesDAOImpl;
import com.example.demo.DAO.impl.PicturesToPhenomenonsDAOImpl;
import com.example.demo.DAO.impl.PicturesToObjectsDAOImpl;
import com.example.demo.DAO.impl.ReactionsDAOImpl;
import com.example.demo.models.Pictures;

import java.util.List;

@Controller
public class PicturesController {
    @Autowired
    private final PicturesDAOImpl PicturesDAO = new PicturesDAOImpl();

    @Autowired
    private final PicturesToPhenomenonsDAOImpl PicturesToPhenomenonsDAO = new PicturesToPhenomenonsDAOImpl();

    @Autowired
    private final PicturesToObjectsDAOImpl PicturesToObjectsDAO = new PicturesToObjectsDAOImpl();

    @Autowired
    private final ReactionsDAOImpl ReactionsDAO = new ReactionsDAOImpl();


    @GetMapping("/picture")
    public String picturesPage(@RequestParam(name = "pictureId") Long pictureId, Model model) {
        Pictures picture = PicturesDAO.getById(pictureId);

        if (picture == null) {
            model.addAttribute("error_msg", "В базе нет объекта с ID = " + pictureId);
            return "errorPage";
        }

        model.addAttribute("object", picture);
        model.addAttribute("PicturesToPhenomenonsService", PicturesToPhenomenonsDAO);
        model.addAttribute("ReactionsService", ReactionsDAO);
        model.addAttribute("PicturesToObjectsService", PicturesToObjectsDAO);
        return "picture";
    }
/*
    @GetMapping("/downloadPicture")
    public String downloadPicture(@RequestParam Long pictureLinkId, @RequestParam , Model model) {
        if (placeId == null) {
            model.addAttribute("place", new Place());
            return "editPlace";
        }

        Place place = placeDAO.getById(placeId);

        if (place == null) {
            model.addAttribute("error_msg", "В базе нет места с ID = " + placeId);
            return "errorPage";
        }

        model.addAttribute("place", place);
        return "editPlace";
    }

    @PostMapping("/savePlace")
    public String savePlacePage(@RequestParam(name = "placeName") String placeName,
                                @RequestParam(name = "placeDescription") String description,
                                Model model) {

        Place place = new Place(placeName, description);
        placeDAO.save(place);

        return String.format("redirect:/place?placeId=%d", place.getId());
    }

    @PostMapping("/removePlace")
    public String removePlacePage(@RequestParam(name = "placeId") Long placeId) {
        placeDAO.deleteById(placeId);
        return "redirect:/places";
    }
*/
}