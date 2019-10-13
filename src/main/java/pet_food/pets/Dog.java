package pet_food.pets;

import pet_food.Food;
import pet_food.FoodType;
import pet_food.Pet;

import java.util.Arrays;
import java.util.List;

public class Dog implements Pet {

    private final List<FoodType> foodList = Arrays.asList(
            FoodType.PORK,
            FoodType.PELLET,
            FoodType.POTATOES);

    @Override
    public void doIntroduce() {

    }

    @Override
    public void doTrick() {
        System.out.println("Your dog does a trick.");
    }

    @Override
    public void feed(Food food) {

    }

    @Override
    public List<FoodType> getFoodKind() {
        return this.foodList;
    }
}
