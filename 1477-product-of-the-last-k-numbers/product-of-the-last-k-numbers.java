class ProductOfNumbers {
     ArrayList<Integer> list;
     int zero;

    public ProductOfNumbers() {
        list=new ArrayList<>();
        zero=0;
    }
    
    public void add(int num) {
        list.add(num);
        if(num==0){
            zero=1;
        }
        
    }
    
    public int getProduct(int k) {

        int product=1;
        for(int i=list.size()-k;i<list.size();i++){
            product*=list.get(i);
        }
        return product;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */