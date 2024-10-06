// class Solution {
//     public boolean areSentencesSimilar(String s1, String s2) {
//         Deque<String> deque1=new ArrayDeque<>(Arrays.asList(s1.split(" ")));
//         Deque<String> deque2=new ArrayDeque<>(Arrays.asList(s2.split(" ")));
//         while(!deque1.isEmpty()&&!deque2.isEmpty()&&deque1.peek().equals(deque2.peek())){
// deque1.poll();
// deque2.poll();
//         }

//         while(!deque1.isEmpty() && !deque2.isEmpty()&&deque1.peekLast().equals(deque2.peekLast())){
//             deque1.pollLast();
//             deque2.pollLast();
//         }
// return deque1.isEmpty() || deque2.isEmpty();
//     }
// }

class Solution {
    public boolean areSentencesSimilar(String s1, String s2) {
        if(s1.length()>s2.length()){
            return areSentencesSimilar(s2,s1);
        }

        String[] arr1=s1.split(" ");
        String[] arr2=s2.split(" ");
        int start=0;
        int start1=0;
        int start2=0;
        int end1=arr1.length-1;
        int end2=arr2.length-1;
        int count1=arr1.length-1;
        int count2=arr2.length-1;

        while(start<=count1 && arr1[start].equals(arr2[start])){
            start++;
        }

        while(end1>=start && arr1[end1].equals(arr2[end2])){
            end1--;
            end2--;
        }
        return (start + (count1 - end1)) == (count1 + 1);
         // return end1<start;
    }
}