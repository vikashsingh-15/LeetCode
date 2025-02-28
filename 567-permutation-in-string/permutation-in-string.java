// class Solution {
//     public boolean checkInclusion(String s1, String s2) {
//         int n=s1.length();
//         int m=s2.length();

//         if(n>m){
//             return false;
//         }

//         int arr []=new int [26];
//         for(int i=0;i<n;i++){
//             char c=s1.charAt(i);
//             arr[c-'a']++;
//         }


//         for(int i=0;i<=m-n;i++){
//             for(int j=i;j<i+n;j++){
//                 char c2=s2.charAt(j);
//                 arr[c2-'a']--;
//             }
//             if(checkZero(arr)){
//                 return true;
//             }

//             for(int j=i;j<i+n;j++){
//                 char c2=s2.charAt(j);
//                 arr[c2-'a']++;
//             }

//         }
//         return false;
//     }

//     public boolean checkZero(int [] arr){
//         for(int i=0;i<26;i++){
//             if(arr[i]!=0){
//                 return false;
//             }
//         }
//         return true;
//     }
// }



//way 2

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if (n > m) {
            return false;
        }

        int arr[] = new int[26];
        for (int i = 0; i < n; i++) {
            arr[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i <= m - n; i++) { 
            int[] tempArr = arr.clone();

            for (int j = i; j < i + n; j++) {
                char c2 = s2.charAt(j);
                tempArr[c2 - 'a']--;
            }

            if (checkZero(tempArr)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkZero(int[] arr) {
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
