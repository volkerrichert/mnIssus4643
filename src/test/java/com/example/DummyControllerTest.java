package com.example;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import io.micronaut.http.client.annotation.*;
import org.junit.jupiter.api.TestMethodOrder;

import javax.inject.Inject;
import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DummyControllerTest {

    @Inject
    @Client("/")
    RxHttpClient client;

    @Test
    @Order(1)
    public void testPut() throws Exception {
        assertEquals(HttpStatus.OK, client.toBlocking().exchange(HttpRequest.PUT("/dummy", "some important stuff")).status());
    }

    @Test
    @Order(2)
    public void testIndex() throws Exception {
        assertEquals(HttpStatus.OK, client.toBlocking().exchange("/dummy").status());
    }

}
