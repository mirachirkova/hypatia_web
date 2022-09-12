package com.example.demo.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import com.example.demo.models.AstroObjects;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestPropertySource(locations="classpath:application.properties")
public class AstroObjectsDAOTest {

    @Autowired
    private AstroObjectsDAO AstroObjectsDAO;
    @Autowired
    private SessionFactory sessionFactory;

    @Test
    void testSimpleManipulations() {
        List<AstroObjects> getObjectByName = AstroObjectsDAO.getAllObjectsByName("T Возничего");
        assertEquals(1, getObjectByName.size());

        List<AstroObjects> getObjectsByClass = AstroObjectsDAO.getAllObjectsByClass(AstroObjects.EObjectClass.planet);
        assertEquals(3, getObjectsByClass.size());

        AstroObjects ObjectId3 = AstroObjectsDAO.getById(3L);
        assertEquals(3, ObjectId3.getId());

        AstroObjects ObjectNotExist = AstroObjectsDAO.getById(100L);
        assertNull(ObjectNotExist);
    }


    @BeforeEach
    void beforeEach() {
    }

    @BeforeAll
    @AfterEach
    void annihilation() {

    }
}
