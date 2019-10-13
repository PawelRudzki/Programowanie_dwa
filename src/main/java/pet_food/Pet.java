package pet_food;

import java.util.List;

public interface Pet {

    void doIntroduce();
    void doTrick();
    void feed(Food food);
    List<FoodType> getFoodKind();

}
