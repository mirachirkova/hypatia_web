package com.example.demo.controllers;

import com.example.demo.DAO.impl.*;
import com.example.demo.models.Pictures;
import com.example.demo.models.PicturesToObjects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.example.demo.DAO.AstroObjectsDAO;
import com.example.demo.models.AstroObjects;
import com.example.demo.DAO.impl.UsersDAOImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.FileOutputStream;

@Controller
public class AstroObjectsController {
    @Autowired
    private final AstroObjectsDAO astroObjectsDAO = new AstroObjectsDAOImpl();

    @Autowired
    private final UsersDAOImpl UsersDAO = new UsersDAOImpl();

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

    @GetMapping("/objectClass")
    public String objectClassListPage(@RequestParam(name = "objectClass") String objectClass,
                                      Model model) {
        List<AstroObjects> objects =
                (List<AstroObjects>) astroObjectsDAO.getAllObjectsByClass(objectClass);
        model.addAttribute("objectClass", objects);
        model.addAttribute("objectClassName", objectClass);
        return "objectClass";
    }

    @GetMapping("/addPicture")
    public String addPicturePage(@RequestParam(name = "objectId") Long objectId,
                                 Model model) {

        model.addAttribute("objectId", objectId);
        model.addAttribute("backLink", "/addPicture?objectId=" + objectId + "%26");
        model.addAttribute("UsersService", UsersDAO);
        model.addAttribute("PicturesToObjectsService", PicturesToObjectsDAO);
        return "addPicture";
    }

    @PostMapping("/savePicture")
    public String savePicturePage( @RequestParam(name = "objectId") Long objectId,
                                   @RequestParam(name = "nickname") String nickname,
                                   @RequestParam(name = "password") String password,
                                   @RequestParam(name = "imageFile") MultipartFile  imageFile,
                                   @RequestParam(name = "telescope") String telescope,
                                   Model model, HttpServletRequest request) throws IOException {
        if (UsersDAO.checkHashPassword(nickname, password)) {
            String filePath =  request.getServletContext().getRealPath("/images/");
            if(! new File(filePath).exists())
            {
                new File(filePath).mkdir();
            }
            filePath = filePath + imageFile.getOriginalFilename();
            String eternal_storage_path = "C:\\Users\\mir-u\\Downloads\\demo\\demo\\src\\main\\resources\\static\\images\\"
                    + imageFile.getOriginalFilename();
            File eternalFile = new File(eternal_storage_path);
            try (OutputStream os = new FileOutputStream(eternalFile)) {
                os.write(imageFile.getBytes());
            }
            imageFile.transferTo(new File(filePath));

            Pictures new_pic = new Pictures(null, "/images/" +
                    imageFile.getOriginalFilename(),
                    UsersDAO.getByNickname(nickname), telescope);
            PicturesDAO.save(new_pic);
            PicturesToObjects new_pic_ob = new PicturesToObjects(astroObjectsDAO.getById(objectId),
                    new_pic);
            PicturesToObjectsDAO.save(new_pic_ob);
            return "redirect:/object?objectId=" + objectId;
        } else {
            model.addAttribute("error_msg", "Неверный никнейм или пароль.");
            return "errorPage";
        }
    }
}

