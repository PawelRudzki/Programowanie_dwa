package pet_food;

import java.util.LinkedList;
import java.util.List;


public class Person {

    private List<Pet> myPets = new LinkedList<>();
    private List<Food> myFood = new LinkedList<>();
    private List<FoodType> myFoodToBuy = new LinkedList<>();

    public void feedPets() {
        myPets.stream().forEach(a -> {
            List<FoodType> foodList = a.getFoodKind();
            myFood.stream().filter(b -> foodList.contains(b.getFood()))
                    .findAny().orElse(null);
            if (myFood == null) {
                System.out.println("No food for your pet!");
                myFoodToBuy.addAll(a.getFoodKind());
            }
        });
    }

    public void addPet(Pet pet) {
        myPets.add(pet);
    }

    public void removePet(Pet pet) {
        myPets.remove(pet);

    }

    public void addFood(Food food) {
        myFood.add(food);

    }

    public void removeFood(Food food) {
        myFood.remove(food);

    }

}
