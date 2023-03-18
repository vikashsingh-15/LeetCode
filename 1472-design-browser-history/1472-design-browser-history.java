class BrowserHistory {

   private String currentUrl;
    private LinkedList<String> history;
    private int currentIndex;

     public BrowserHistory(String homepage) {
        this.currentUrl = homepage;
        this.history = new LinkedList<>();
        this.history.add(homepage);
        this.currentIndex = 0;
    }

    public void visit(String url) {
        this.currentIndex++;
        if (currentIndex == history.size()) {
            history.add(url);
        } else {
            history.set(currentIndex, url);
            int size = history.size();
            for (int i = currentIndex + 1; i < size; i++) {
                history.removeLast();
            }
        }
        this.currentUrl = url;
    }

    public String back(int steps) {
        this.currentIndex = Math.max(currentIndex - steps, 0);
        this.currentUrl = history.get(currentIndex);
        return this.currentUrl;
    }

    public String forward(int steps) {
        int stepsToForward = Math.min(steps, history.size() - 1 - currentIndex);
        this.currentIndex += stepsToForward;
        this.currentUrl = history.get(currentIndex);
        return this.currentUrl;
    }
}
/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
