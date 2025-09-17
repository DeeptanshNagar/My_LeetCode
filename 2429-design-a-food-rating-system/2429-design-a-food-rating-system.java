class FoodRatings {
    Map<String, Integer> foodToRating;
    Map<String, String> foodToCuisine;
    Map<String, TreeSet<Food>> cuisineToFoods;
    
    public class Food {
        String name;
        int rating;
        
        Food(String name, int rating) {
            this.name = name;
            this.rating = rating;
        }
    }
    
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToRating = new HashMap<>();
        foodToCuisine = new HashMap<>();
        cuisineToFoods = new HashMap<>();
        
        for (int i = 0; i < foods.length; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];
            
            foodToRating.put(food, rating);
            foodToCuisine.put(food, cuisine);
            
            cuisineToFoods.putIfAbsent(cuisine, new TreeSet<>((a, b) -> {
                if (a.rating != b.rating) {
                    return Integer.compare(b.rating, a.rating);
                }
                return a.name.compareTo(b.name);
            }));
            
            cuisineToFoods.get(cuisine).add(new Food(food, rating));
        }
    }
    
    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisine.get(food);
        int oldRating = foodToRating.get(food);
        
        cuisineToFoods.get(cuisine).remove(new Food(food, oldRating));
        foodToRating.put(food, newRating);
        cuisineToFoods.get(cuisine).add(new Food(food, newRating));
    }
    
    public String highestRated(String cuisine) {
        return cuisineToFoods.get(cuisine).first().name;
    }
}