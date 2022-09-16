/*
When any of p and n is 0, return 1
When p = 1:
        n = 1, the light has two states: on or off, so the answer is 2;
        n = 2, the light has 3 states: 00, 01, 10, so the answer is 3;
        n = 3, the light has 4 states: 000, 101, 010, 011, so the answer is 4;
        n = 4, the light has 4 states: 0000, 1010, 0101, 0110, so the answer is 4;
        Combining n = 3, n = 4, when n > 3, the answer is both 4.

When p = 2:
        n = 1, the light has two states: on or off, so the answer is 2;
        n = 2, the light has 4 states: 11, 01, 10, 00, so the answer is 4;
        n = 3, the lamp has 7 states: 111, 101.010, 100, 000, 001, 110, so the answer is 7;
        Ditto, when n > 3, the answer is both 7.


When p = 3:
        n = 1, the light has two states: on or off, so the answer is 2;
        n = 2, the light has 4 states: 00, 01, 10, 11, so the answer is 4;
        n = 3, the light has 8 states: 111, 101.010, 100, 000, 001, 110, 011, so the answer is 8;
        Ditto, when n > 3, the answer is both 8.

When p > 3, the answer should be the same as m = 3.
*/



class Solution {
    public int flipLights(int n, int p) {
        if (p == 0){
            return 1;
        }
            if(p==1){
                if(n==1){
                    return 2;
                }
                if(n==2){
                    return 3;
                }
                else{
                    return 4;
                }
            }
        
        if(p==2){
                if(n==1){
                    return 2;
                }
                if(n==2){
                    return 4;
                }
                else{
                    return 7;
                }
            }
        
        else{
                if(n==1){
                    return 2;
                }
                if(n==2){
                    return 4;
                }
                else{
                    return 8;
                }
            }       


        
    }
}