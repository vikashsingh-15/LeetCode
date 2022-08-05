class Solution {
    public String convert(String s, int numRows) {
        char[][] a = new char[numRows][s.length()];
        int x=-1,t=0;
        int n=s.length();
        int i,j;
        String word="";
        while(t!=n)
        {
            x++;
            for(i=0;i<numRows && t!=n;i++)
                a[i][x]=s.charAt(t++);
            for(i=numRows-2;i>0 && t!=n;i--)
                a[i][++x]=s.charAt(t++);
        }
        for(i=0;i<numRows;i++)
        {
            for(j=0;j<=x;j++)
            {
                if(a[i][j] != '\u0000')
                    word+=a[i][j];
            }
        }
        return word;
    }
}