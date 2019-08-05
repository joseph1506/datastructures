package tests.refactored;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Meal implements Comparable<Meal> {
    public static final HashMap<String,Integer> foodCalorieMap= new HashMap<>();
    private String eater;
    private MealTime mealTime;
    private Map<String,Integer> foodWeight;

    public Meal(String eater, String mealTime) throws Exception {
        this.eater= eater;
        this.mealTime= MealTime.getMealTimeValue(mealTime);
        this.foodWeight = new HashMap<>();
    }

    /*{
        calories = all_calories;
    }*/


    public void addFoodAndWeight(String food, int weight) throws Exception {
        checkIfFoodPresent(food, foodCalorieMap);
        Integer existingWeight = this.foodWeight.get(food)!=null?this.foodWeight.get(food):0;
        this.foodWeight.put(food,existingWeight+weight);
    }

    public void removeFoodAndWeight(String food) throws Exception {
        checkIfFoodPresent(food, foodCalorieMap);
        if(this.foodWeight.get(food)==null){
            throw new Exception(food +" not in this meal");
        }
        this.foodWeight.remove(food);
    }

    public int calculateTotalCalories() {
        return this.foodWeight.keySet().stream()
                .mapToInt(d-> foodCalorieMap.get(d) * this.foodWeight.get(d))
                .sum();
    }


    @Override
    public int compareTo(Meal o) {
        if(o==null){
            return 1;
        }
        return this.calculateTotalCalories()-o.calculateTotalCalories();
    }

    public static void checkIfFoodPresent(String food, Map<String, Integer> foodCalorieMapper) throws Exception {
        Objects.requireNonNull(foodCalorieMapper);
        if (!foodCalorieMapper.containsKey(food)) {
            throw new Exception(food + " doesnt exist");
        }
    }

    @Override
    public boolean equals(Object o){
        if(this==o){
            return true;
        }

        if(o==null || !(o instanceof Meal)){
            return false;
        }
        final Meal meal = (Meal) o;
        return this.eater == meal.eater && this.mealTime == meal.mealTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(eater, mealTime);
    }

    public String getEater() {
        return eater;
    }

    public MealTime getMealTime() {
        return mealTime;
    }
}
