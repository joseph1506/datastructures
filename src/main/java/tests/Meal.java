package tests;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Meal implements Comparable<Meal> {
    public static final HashMap<String,Integer> all_calories= new HashMap<>();
    public static String eater;
    public static String time;
    public List<String> foods;
    public List<Integer> weights;
    public Map<String, Integer> calories;

    public Meal(){
        super();
    }

    public Meal(String eater_name){
        super();
        eater = eater;
    }

    public Meal(String eater_name,String meal_time) throws Exception {
        super();
        eater= eater_name;
        time= meal_time.toUpperCase();
        switch (time) {
            case "BREAKFAST":
                System.out.println("BREAKFAST");
                break;
            case "LUNCH":
                System.out.println("LUNCH");
                break;
            case "DINNER":
                System.out.println("DINNER");
                break;
            default:
                throw new Exception("Invalid Meal Time given");
        }

    }

    {
        calories = all_calories;
    }


    public void add(String name, int weight){
        if(!calories.containsKey(name)){
            throw new RuntimeException(name +" doesnt exist");
        }
        foods.add(name);
        weights.add(weight);
    }

    public void remove(String name) throws RuntimeException {
        if(!calories.containsKey(name)){
            throw new RuntimeException(name +" doesnt exist");
        }
        final int i = foods.indexOf(name);
        if(i==-1){
            throw new RuntimeException(name +" not in this meal");
        } else {
            foods.remove(i);
            weights.remove(i);
        }
    }

    public void update(String name, int weight){
        if(!calories.containsKey(name)){
            throw new RuntimeException(name +" doesnt exist");
        }
        final int i = foods.indexOf(name);
        if(i==-1){
            throw new RuntimeException(name +"not in this meal");
        } else {
            weights.set(i,weight);
        }
    }

    public int cal() {
        int calories = 0;
        for(int i=0;i<foods.size();i++){
            calories = calories+ this.calories.get(this.foods.get(i)) * this.weights.get(i);
        }
        return calories;
    }


    @Override
    public int compareTo(Meal o) {
        int this_calories = 0;
        for(int i=0;i<foods.size();i++){
            this_calories += this.calories.get(this.foods.get(i)) * this.weights.get(i);
        }
        int other_calories = 0;
        for(int i=0;i<foods.size();i++){
            other_calories += this.calories.get(this.foods.get(i)) * this.weights.get(i);
        }
        return this_calories-other_calories;
    }

    public String toString(){
        return super.toString();
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
        return eater == meal.eater && time == meal.time;
    }

    @Override
    public int hashCode() {
        return Objects.hash(eater);
    }
}
