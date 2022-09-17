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
public class ReactionsDAOTest {

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
    void testReactions() {
        Long likes = ReactionsDAO.getLikes(PicturesDAO.getById(5L));
        assertEquals(1, likes);
        Long dislikes = ReactionsDAO.getDistrusts(PicturesDAO.getById(5L));
        assertEquals(3, dislikes);
        
    }


    @BeforeEach
    void beforeEach() {
    }

    @BeforeAll
    @AfterEach
    void annihilation() {

    }
}
