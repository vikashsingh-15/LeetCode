class BrowserHistory {

   private String currentUrl;
    private LinkedList<String> history=new LinkedList<>();
    private int currentIndex;

     public BrowserHistory(String homepage) {
        currentUrl = homepage;   
        history.add(homepage);
        currentIndex = 0;
    }

    public void visit(String url) {
        currentIndex++;
       history.add(currentIndex,url);
         while(currentIndex < history.size()-1){
            history.removeLast();
        }
        
    }

    public String back(int steps) {
        currentIndex = Math.max(currentIndex - steps, 0);
        currentUrl = history.get(currentIndex);
        return currentUrl;
    }

    public String forward(int steps) {
        int stepsToForward = Math.min(steps, history.size() - 1 - currentIndex);
        currentIndex += stepsToForward;
        currentUrl = history.get(currentIndex);
        return currentUrl;
    }
}
/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
