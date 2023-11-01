class UndergroundSystem {
     Map<Integer, Pair<String, Integer>> checkInMap;
     Map<String, Pair<Integer, Integer>> travelMap;//route ->{totalTime,count}

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        travelMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id,new Pair(stationName,t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> checkInData = checkInMap.get(id);
               
        String startStation = checkInData.getKey();
        int startTime = checkInData.getValue();

        int travelTime = t - startTime;
        String routeKey=startStation+"-"+stationName;

       
        Pair timeTravelPair=travelMap.getOrDefault(routeKey,new Pair(0,0));
            int totalTime=(Integer) timeTravelPair.getKey() +  travelTime;
            int count=(Integer) timeTravelPair.getValue()+1;
            travelMap.put(routeKey, new Pair(totalTime, count));
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String routeKey=startStation+"-"+endStation;
        Pair timeTravelPair = travelMap.get(routeKey);

        double time = (Integer) timeTravelPair.getKey();
        int count = (Integer) timeTravelPair.getValue();
        return time/(1.0*count);
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */