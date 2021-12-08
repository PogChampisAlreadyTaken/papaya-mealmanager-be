package de.PogChampIsAlreadyTaken.Papaya.Webshop;


import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Path("/meals")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MealService {
    @Inject
    EntityManager em;

    @Inject
    Validator validator;


    @GET
    public Response getAllMeals() {
        List<Meal> cus = em.createQuery("SELECT m from Meal m", Meal.class).getResultList();
        return Response.ok().entity(cus).build();
    }

    @POST
    public Response postMeals(@Valid Meal meal) {
        Set<ConstraintViolation<Meal>> violations = validator.validate(meal);

        if (!violations.isEmpty()) {
            String msg = violations.stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.joining(", "));

            return Response.status(400).entity(msg).build();
        }
        Meal m = createMeal(meal.getMealName(), meal.getHotness(), meal.getCategoryId());
        System.out.println(m);
        return Response.status(201).entity(m).build();
    }

    @Transactional
    public Meal createMeal(String mealName, String hotness, int categoryId) {
        Meal m = new Meal();
        m.setMealName(mealName);
        m.setHotness(hotness);
        m.setCategoryId(categoryId);

        em.persist(m);
        return m;
    }
}
