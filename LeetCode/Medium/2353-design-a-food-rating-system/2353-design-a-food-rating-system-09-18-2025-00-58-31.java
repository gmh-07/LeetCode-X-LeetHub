class FoodRatings {
    private class Food{
        String name;
        int rating;
        Food(String name,int rating){
            this.name = name;
            this.rating = rating;
        }
    }

    HashMap<String,String> foodToCuisine;
    HashMap<String,Integer> foodToRating; 
    HashMap<String,PriorityQueue<Food>> cuisineToPQ;


    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToCuisine = new HashMap<>();
        foodToRating = new HashMap<>();
        cuisineToPQ = new HashMap<>();
        int n = foods.length;
        for(int i=0;i<n;i++){
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];
            foodToCuisine.put(food,cuisine);
            foodToRating.put(food,rating);
            
            cuisineToPQ.computeIfAbsent(cuisine,k->new PriorityQueue<>(
                (a,b)->{
                    if(b.rating != a.rating){
                        return b.rating-a.rating;
                    }
                    return a.name.compareTo(b.name);
                }
            )).add(new Food(food,rating));

        }
    }
    
    public void changeRating(String food, int newRating) {
        foodToRating.put(food, newRating);
        String cuisine = foodToCuisine.get(food);
        cuisineToPQ.get(cuisine).add(new Food(food, newRating));
    }
    
    public String highestRated(String cuisine) {
        PriorityQueue<Food> pq = cuisineToPQ.get(cuisine);
        while (true) {
            Food top = pq.peek();
            if (foodToRating.get(top.name) == top.rating) {
                return top.name;
            } else {
                pq.poll();
            }
        }
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */