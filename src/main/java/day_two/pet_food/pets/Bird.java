package day_two.pet_food.pets;

import day_two.pet_food.Food;
import day_two.pet_food.FoodType;
import day_two.pet_food.Pet;

import java.util.Arrays;
import java.util.List;

public class Bird implements Pet {


    private final List<FoodType> foodList = Arrays.asList(
            FoodType.CORN,
            FoodType.FISH,
            FoodType.WHEY);

    @Override
    public void doIntroduce() {

    }

    @Override
    public void doTrick() {
        System.out.println("Your fish does a trick.");


    }

    @Override
    public void feed(Food food) {

    }

    @Override
    public List<FoodType> getFoodKind() {
        return this.foodList;
    }
}
