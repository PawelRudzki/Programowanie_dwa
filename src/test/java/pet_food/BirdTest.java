package pet_food;

import day_two.pet_food.FoodType;
import org.junit.Test;
import day_two.pet_food.pets.Bird;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class BirdTest {

    @Test
    public void getFoodKind() {




        //given
        List<FoodType> foodList = new LinkedList<>();
        foodList.add(FoodType.CORN);
        foodList.add(FoodType.WHEY);
        foodList.add(FoodType.FISH);

        Bird bird = new Bird();

        //when

        //then
        assertTrue(bird.getFoodKind().contains(FoodType.CORN));
        assertTrue(bird.getFoodKind().contains(FoodType.WHEY));
        assertTrue(bird.getFoodKind().contains(FoodType.FISH));


    }
}