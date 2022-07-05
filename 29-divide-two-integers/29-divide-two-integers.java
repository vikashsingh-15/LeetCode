class Solution {

    public int divide(int Dividend, int Divisor) {
        long dividend = Dividend, divisor = Divisor;

        if (divisor == 1)
            return (int) dividend;

        if ( dividend == Integer.MIN_VALUE && divisor == -1 ) 
            return Integer.MAX_VALUE; //Corner Case

        int signOfQuotient = 1;

        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) 
            signOfQuotient = -1; //Quotiient will be negative

        divisor = Math.abs(divisor);
        dividend = Math.abs(dividend);

        int quotient = 0;
        while (dividend >= divisor) {
            dividend = dividend - divisor;
            quotient++;
        }

        if (signOfQuotient == -1) quotient = -quotient;

        return quotient;
    }
}
