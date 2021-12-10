package de.PogChampIsAlreadyTaken.Papaya.Services;


import de.PogChampIsAlreadyTaken.Papaya.Entities.Meal;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/meals")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MealService {

    @GET
    @Path("/{id}")
    public Response getMeal(@PathParam("id") long id) {
        Meal meal = Meal.findById(id);
        return Response.ok().entity(meal).build();
    }


    @POST
    @Transactional
    public Response postMeal(Meal meal) {
        meal.persist();
        return Response.created(URI.create("/meals/" + meal.id)).build();
    }
}
