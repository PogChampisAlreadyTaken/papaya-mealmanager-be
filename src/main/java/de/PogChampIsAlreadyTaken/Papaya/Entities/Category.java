package de.PogChampIsAlreadyTaken.Papaya.Entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;


@Entity
public class Category extends PanacheEntity {

    public String name;

    @OneToMany
    public List<Meal> mealsList;

}
