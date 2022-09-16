package com.example.demo.controllers;

import com.example.demo.models.AstroObjects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.example.demo.DAO.impl.PicturesDAOImpl;
import com.example.demo.DAO.impl.PicturesToPhenomenonsDAOImpl;
import com.example.demo.DAO.impl.PicturesToObjectsDAOImpl;
import com.example.demo.DAO.impl.ReactionsDAOImpl;
import com.example.demo.DAO.impl.UsersDAOImpl;
import com.example.demo.DAO.impl.AstroObjectsDAOImpl;
import com.example.demo.models.Pictures;
import com.example.demo.models.Reactions;

import java.util.List;

@Controller
public class PicturesController {
    @Autowired
    private final PicturesDAOImpl PicturesDAO = new PicturesDAOImpl();

    @Autowired
    private final UsersDAOImpl UsersDAO = new UsersDAOImpl();

    @Autowired
    private final PicturesToPhenomenonsDAOImpl PicturesToPhenomenonsDAO = new PicturesToPhenomenonsDAOImpl();

    @Autowired
    private final PicturesToObjectsDAOImpl PicturesToObjectsDAO = new PicturesToObjectsDAOImpl();

    @Autowired
    private final ReactionsDAOImpl ReactionsDAO = new ReactionsDAOImpl();

    @Autowired
    private final AstroObjectsDAOImpl AstroObjectsDAO = new AstroObjectsDAOImpl();


    @GetMapping("/picture")
    public String picturesPage(@RequestParam(name = "pictureId") Long pictureId, Model model) {
        Pictures picture = PicturesDAO.getById(pictureId);

        if (picture == null) {
            model.addAttribute("error_msg", "В базе нет фотографии с ID = " + pictureId);
            return "errorPage";
        }

        model.addAttribute("picture", picture);
        model.addAttribute("PicturesToPhenomenonsService", PicturesToPhenomenonsDAO);
        model.addAttribute("ReactionsService", ReactionsDAO);
        model.addAttribute("PicturesToObjectsService", PicturesToObjectsDAO);
        model.addAttribute("UsersService", UsersDAO);
        model.addAttribute("AstroObjectsService", AstroObjectsDAO);
        model.addAttribute("PicturesService", PicturesDAO);
        return "picture";
    }

    @GetMapping("/addReaction")
    public String addReactionPage(@RequestParam(name = "pictureId") Long pictureId,
                                      Model model) {

        model.addAttribute("pictureId", pictureId);
        model.addAttribute("backLink", "/addReaction?pictureId=" + pictureId + "%26");
        model.addAttribute("UsersService", UsersDAO);
        return "addReaction";
    }

    @PostMapping("/saveReaction")
    public String saveReactionPage(@RequestParam(name = "pictureId") Long pictureId,
                                       @RequestParam(name = "nickname") String nickname,
                                       @RequestParam(name = "password") String password,
                                       @RequestParam(name = "reaction") String reaction,
                                        Model model) {
        if (UsersDAO.checkHashPassword(nickname, password)) {
            Reactions react = new Reactions(null, UsersDAO.getByNickname(nickname),
                    PicturesDAO.getById(pictureId),
                    reaction);
            ReactionsDAO.save(react);
            return "redirect:/picture?pictureId=" + pictureId;
        } else {
            model.addAttribute("error_msg", "Неверный никнейм или пароль.");
            return "errorPage";
        }
    }




}