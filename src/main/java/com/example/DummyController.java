package com.example;

import io.micronaut.http.annotation.*;

@Controller("/dummy")
public class DummyController {

    @Get(uri="/", produces="text/plain")
    public String index() {
        return "Example Response";
    }

    @Put(uri="/", produces="text/plain")
    public String put(
            @Body String body
    ) {
        return "Example Response with " + body;
    }
}