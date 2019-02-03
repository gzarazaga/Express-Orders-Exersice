package com.pedidosya.ejercicio.services;

import com.pedidosya.ejercicio.domain.Opinion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.assertNotNull;
import static org.springframework.util.Assert.notNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OpinionServiceTest {

    @Autowired
    private OpinionService opinionService;

    @Test
    public void addOpinionTest() {
        Opinion opinion = new Opinion("Opinion de Test", 5, new Date(), 1L, 1L, 1L, false);
        Opinion savedOpinion = opinionService.addOpinion(opinion);
        assertNotNull(savedOpinion);
    }

    @Test
    public void deleteOpinionTest() {
        opinionService.deleteOpinion(1L);

    }
}
