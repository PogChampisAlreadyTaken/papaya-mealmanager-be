package de.PogChampIsAlreadyTaken.Papaya.Services;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class Orderingsystem {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String hello() {
        String hello = "Hello Mealmanager, UWUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU";

        Jsonb jsonb = JsonbBuilder.create();

        return jsonb.toJson(hello);
    }
}