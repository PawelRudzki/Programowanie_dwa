package pet_food;

import org.junit.Test;
import pet_food.pets.Dog;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class DogTest {

    @Test
    public void getFoodKind() {


        //given
        List<FoodType> foodList = new LinkedList<>();
        foodList.add(FoodType.POTATOES);
        foodList.add(FoodType.PORK);
        foodList.add(FoodType.PELLET);

        Dog dog = new Dog();

        //when

        //then
        assertTrue(dog.getFoodKind().contains(FoodType.PORK));
        assertTrue(dog.getFoodKind().contains(FoodType.PELLET));
        assertTrue(dog.getFoodKind().contains(FoodType.POTATOES));


    }
}