package com.pedidosya.ejercicio.services;

import com.pedidosya.ejercicio.domain.Opinion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.util.Assert.notNull;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {"spring.config.name=myapp-test-h2","myapp.trx.datasource.url=jdbc:h2:mem:trxServiceStatus"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class OpinionServiceTest {

    @Autowired
    private OpinionService opinionService;

    @Test
    public void addOpinionTest() {
        Opinion opinion = new Opinion("Opinion de Test", 5, new Date(), 1L, 1L, 1L, false);
        Opinion savedOpinion = opinionService.addOpinion(opinion);
        assertNotNull(savedOpinion);
        assertNotNull(savedOpinion.getId());
    }

    @Test
    public void deleteOpinionTest() {
        Opinion opinion = new Opinion("Opinion de Test", 5, new Date(), 1L, 1L, 1L, false);
        Opinion savedOpinion = opinionService.addOpinion(opinion);
        Opinion deletedOpinion = opinionService.deleteOpinion(savedOpinion.getId());
        assertNotNull(deletedOpinion);
        assertTrue(deletedOpinion.getOpinionEliminada());
    }

    @Test
    public void getOpinionByCompraIdTest() {
        Opinion opinion = new Opinion("Opinion de Test", 5, new Date(), 1L, 1L, 1L, false);
        Opinion savedOpinion = opinionService.addOpinion(opinion);
        Opinion opinionCompra = opinionService.getOpinionByCompraId(1L);
        assertNotNull(opinionCompra);
        assertEquals(opinionCompra.getCompraId(), Long.valueOf(1));
    }

    @Test
    public void getOpinionByTiendaIdAndDateRangeTest() {
        Opinion opinion = new Opinion("Opinion de Test", 5, new Date(), 1L, 1L, 1L, false);
        Opinion savedOpinion = opinionService.addOpinion(opinion);

        Date dtFrom = new Date(new Date().getTime() - (1000 * 60 * 60 * 24));
        Date dtTo = new Date(new Date().getTime() + (1000 * 60 * 60 * 24));

       List<Opinion> opinionCompras = opinionService.getOpinionByTiendaIdAndDateRange(1L, dtFrom, dtTo);
        assertNotNull(opinionCompras);
        assertEquals(opinionCompras.size(), 1);
    }
}
