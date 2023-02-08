class RandomizedSet {
     ArrayList<Integer> list;
    HashMap<Integer, Integer> map;

    public RandomizedSet() {
         list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {
          if(map.containsKey(val))
        return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
         if(!map.containsKey(val))
        return false;
        
        int loc = map.get(val);
        if(loc < list.size() - 1)
        {
            int lastOne = list.get(list.size() - 1);
            list.set(loc, lastOne);
            map.put(lastOne, loc);
        }
        map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }
    
    public int getRandom() {
         java.util.Random rand = new java.util.Random();
        return list.get(rand.nextInt(list.size()) );
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */