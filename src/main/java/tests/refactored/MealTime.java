package tests.refactored;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public enum MealTime {
    BREAKFAST,
    DINNER,
    LUNCH;

    public static MealTime getMealTimeValue(String mealTime) throws Exception {
        MealTime mealfetchTime= Arrays.asList(MealTime.values()).stream()
                .filter(mt->mt.name().equalsIgnoreCase(mealTime))
                .findFirst()
                .orElse(null);
        if(mealfetchTime==null){
            throw new Exception("Invalid Meal Time Given");
        }
        return mealfetchTime;
    }
}
