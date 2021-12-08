package de.PogChampIsAlreadyTaken.Papaya.Webshop;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "meals")
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meal_id")
    private Long id;

    @NotNull(message = "Name is mandatory")
    @Column(name = "meal_name")
    private String mealName;

    @NotNull(message = "Hotness is mandatory")
    private String hotness;

    @NotNull(message = "Category is mandatory")
    @Column(name = "category_id")
    private int categoryId;


    public Long getId() {
        return id;
    }

    public String getMealName() {
        return mealName;
    }

    public String getHotness() {
        return hotness;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public void setHotness(String hotness) {
        this.hotness = hotness;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
