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

        List<AstroObjects> getObjectsByClass = AstroObjectsDAO.getAllObjectsByClass("планета");
        assertEquals(3, getObjectsByClass.size());

        AstroObjects ObjectId3 = AstroObjectsDAO.getById(3L);
        assertEquals(3, ObjectId3.getId());

        AstroObjects ObjectNotExist = AstroObjectsDAO.getById(100L);
        assertNull(ObjectNotExist);

        List<AstroObjects> AllObjects = (List<AstroObjects>) AstroObjectsDAO.getAll();
        assertEquals(11, AllObjects.size());

        List<AstroObjects> getObjectsByDiscoverer = AstroObjectsDAO.getAllObjectsByDiscoverer("Томас Дэвид Андерсон");
        assertEquals(2, getObjectsByDiscoverer.size());

        List<AstroObjects> getObjectsByInfo = AstroObjectsDAO.getAllObjectsByInfo("Самый близкий к Солнцу спутник");
        assertEquals(1, getObjectsByInfo.size());
        String nameInfo = AstroObjectsDAO.getNameById(getObjectsByInfo.get(0).getId());
        assertEquals("Луна", nameInfo);
    }

    @BeforeEach
    void beforeEach() {
    }

    @BeforeAll
    @AfterEach
    void annihilation() {

    }
}
