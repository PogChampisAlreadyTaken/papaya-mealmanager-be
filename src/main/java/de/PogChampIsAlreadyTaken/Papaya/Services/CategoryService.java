package de.PogChampIsAlreadyTaken.Papaya.Services;

import de.PogChampIsAlreadyTaken.Papaya.Entities.Category;
import de.PogChampIsAlreadyTaken.Papaya.Entities.Meal;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/category")
public class CategoryService {

    @GET
    @Path("/")
    public Response getAllCategories() {
        List<Category> categories = Category.findAll().list();
        return Response.ok().entity(categories).build();
    }

    @GET
    @Path("/{category}")
    public Response getCategoryByMenuCategory(@PathParam("category") long category) {
        Category newCategory = Category.findById(category);
        return Response.ok().entity(newCategory).build();
    }
}
