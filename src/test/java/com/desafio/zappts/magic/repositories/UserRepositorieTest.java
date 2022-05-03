package com.desafio.zappts.magic.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UserRepositorieTest {

    private Long idExisting;
    private Long idNotExisting;
    private Long countTotalProduct;

    @BeforeEach
    void setUp() throws Exception {
        idExisting = 1L;
        idNotExisting = 1500L;
        countTotalProduct = 25L;
    }



}
