package pet_food;

import org.junit.Test;
import pet_food.pets.Fish;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class FishTest {

    @Test
    public void getFoodKind() {



        //given
        List<FoodType> foodList = new LinkedList<>();
        foodList.add(FoodType.CORN);
        foodList.add(FoodType.WHEY);

        Fish fish = new Fish();

        //when

        //then
        assertTrue(fish.getFoodKind().contains(FoodType.CORN));
        assertTrue(fish.getFoodKind().contains(FoodType.WHEY));


    }
}