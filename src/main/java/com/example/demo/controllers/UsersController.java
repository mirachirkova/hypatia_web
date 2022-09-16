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
import com.example.demo.models.Users;

import java.util.List;

@Controller
public class UsersController {
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

    @GetMapping("/users")
    public String objectsListPage(Model model) {
        List<Users> users = (List<Users>) UsersDAO.getAll();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/user")
    public String usersPage(@RequestParam(name = "userId") Long userId, Model model) {
        Users user = UsersDAO.getById(userId);

        if (user == null) {
            model.addAttribute("error_msg", "В базе нет пользователя с ID = " + userId);
            return "errorPage";
        }

        model.addAttribute("user", user);
        model.addAttribute("UsersService", UsersDAO);
        model.addAttribute("PicturesService", PicturesDAO);
        return "user";
    }


}