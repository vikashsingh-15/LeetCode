class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {

        Set<String> available = new HashSet<>(Arrays.asList(supplies));
        List<String> result = new ArrayList<>();

        boolean state = true;
        boolean isPossible=true;


    while(isPossible){
        isPossible = false;
         for (int i = 0; i < recipes.length; i++) {
            state=true;
            String recipe = recipes[i];
            if (available.contains(recipe))
                continue;

            for (String ingredient : ingredients.get(i)) {
                if (!available.contains(ingredient)) {
                    state = false;
                    break;
                }
            }
            if (state) {
                available.add(recipe);
                result.add(recipe);
                isPossible=true;
            }

    }
       

        }
        return result;
    }
}