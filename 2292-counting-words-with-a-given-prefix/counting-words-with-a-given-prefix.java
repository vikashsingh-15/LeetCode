// class Solution {

//     public int prefixCount(String[] words, String pref) {
//         int count = 0;
//         for (String word : words) {
//             if (word.startsWith(pref)) {
//                 count++;
//             }
//         }
//         return count;
//     }
// }

class Solution {
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        Trie trie = new Trie();
        for (String word : words) {
            trie.addWord(word);
        }
        return trie.countPrefix(pref);
    }

    public class Trie {
        class Node {
            Node[] links;
            int count;

            Node() {
                links = new Node[26];
                count = 0;
            }
        }

        final private Node root;

        public Trie() {
            root = new Node();
        }

        public void addWord(String word) {
            Node curr = root;

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);

                if (curr.links[ch - 'a'] == null) {
                    curr.links[ch - 'a'] = new Node();
                }
                curr = curr.links[ch - 'a'];
                curr.count++;
            }
        }

        public int countPrefix(String pref) {
            Node curr = root;
            for (int i = 0; i < pref.length(); i++) {
                char c = pref.charAt(i);
                if (curr.links[c - 'a'] == null) {
                    return 0; // Prefix not found
                }
                curr = curr.links[c - 'a'];
            }
            return curr.count; // Return count at last node
        }

    }
}