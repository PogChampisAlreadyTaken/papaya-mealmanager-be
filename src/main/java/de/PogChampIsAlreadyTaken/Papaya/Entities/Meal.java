package de.PogChampIsAlreadyTaken.Papaya.Entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;

@Entity
public class Meal extends PanacheEntity {

    public String mealName;
    public int categoryid;
    public String hotness;
    }


