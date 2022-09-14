package com.example.demo.DAO;

import com.example.demo.DAO.impl.AstroObjectsDAOImpl;
import com.example.demo.models.Pictures;
import com.example.demo.models.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import com.example.demo.models.AstroObjects;
import com.example.demo.models.PicturesToObjects;
import com.example.demo.DAO.impl.PicturesToObjectsDAOImpl;
import com.example.demo.DAO.impl.PicturesDAOImpl;
import com.example.demo.DAO.impl.ReactionsDAOImpl;
import com.example.demo.DAO.impl.UsersDAOImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestPropertySource(locations="classpath:application.properties")
public class AstroObjectsDAOTest {

    @Autowired
    private AstroObjectsDAO AstroObjectsDAO = new AstroObjectsDAOImpl();
    @Autowired
    private PicturesToObjectsDAO PicturesToObjectsDAO = new PicturesToObjectsDAOImpl();
    @Autowired
    private PicturesDAO PicturesDAO = new PicturesDAOImpl();
    @Autowired
    private ReactionsDAO ReactionsDAO = new ReactionsDAOImpl();
    @Autowired
    private UsersDAO UsersDAO = new UsersDAOImpl();

    @Autowired
    private SessionFactory sessionFactory;


    @Test
    void testSimpleManipulations() {
        List<AstroObjects> getObjectByName = AstroObjectsDAO.getAllObjectsByName("T Возничего");
        if (getObjectByName == null) {
            assertEquals(1, 0);
        }
        assertEquals(1, getObjectByName.size());

        List<AstroObjects> getObjectsByClass = AstroObjectsDAO.getAllObjectsByClass("planet");
        assertEquals(3, getObjectsByClass.size());

        AstroObjects ObjectId3 = AstroObjectsDAO.getById(3L);
        assertEquals(3, ObjectId3.getId());

        AstroObjects ObjectNotExist = AstroObjectsDAO.getById(100L);
        assertNull(ObjectNotExist);

        List<AstroObjects> AllObjects = (List<AstroObjects>) AstroObjectsDAO.getAll();
        assertEquals(11, AllObjects.size());
    }

    @Test
    void testPictureToObjects() {
        List<Pictures> allMarsPictures = PicturesToObjectsDAO.getAllPictures(7L);
        if (allMarsPictures == null) {
            assertEquals(3, 0);
        }
        assertEquals(3, allMarsPictures.size());

        /*List<String> allMarsPicturesLink = PicturesToObjectsDAO.getAllPicturesLinks(7L);
        if (allMarsPicturesLink == null) {
            assertEquals(3, 0);
        }
        assertEquals(3, allMarsPicturesLink.size());*/
    }

    @Test
    void testPictures() {
        Pictures firstPicture = PicturesDAO.getById(1L);
        assertEquals("/images/id_1.jpg", firstPicture.getLink());
    }

    @Test
    void testReactions() {
        Long likes = ReactionsDAO.getLikes(PicturesDAO.getById(5L));
        assertEquals(1, likes);
        Long dislikes = ReactionsDAO.getDistrusts(PicturesDAO.getById(5L));
        assertEquals(3, dislikes);

    }

    @Test
    void testUsers() {
        String nick = UsersDAO.getNicknameByPicture(PicturesDAO.getById(5L));
        assertEquals("milady", nick);
        Users miladyUser= UsersDAO.getByNickname("milady");
        assertEquals(5L, miladyUser.getId());
        boolean checker = UsersDAO.checkHashPassword("d_artagnan", "SRdMtp");
        assertEquals(true, checker);
    }

    @BeforeEach
    void beforeEach() {
    }

    @BeforeAll
    @AfterEach
    void annihilation() {

    }
}
