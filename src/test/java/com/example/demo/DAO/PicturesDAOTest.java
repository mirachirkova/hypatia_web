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
public class PicturesDAOTest {

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
    void testPictures() {
        Pictures firstPicture = PicturesDAO.getById(1L);
        assertEquals("/images/id1.jpg", firstPicture.getLink());

        String linkById = PicturesDAO.getLinkById(1L);
        assertEquals("/images/id1.jpg", linkById);

        String linkById_n = PicturesDAO.getLinkById(100L);
        assertEquals(null, linkById_n);

        List<Pictures> allLinksByUser = PicturesDAO.getAllLinksByUserId(1L);
        assertEquals(1, allLinksByUser.size());
    }


    @BeforeEach
    void beforeEach() {
    }

    @BeforeAll
    @AfterEach
    void annihilation() {

    }
}
