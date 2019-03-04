public class Palindrome {
    /**
     * return a Deque where the characters appear in the same order as in the String
     */
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            deque.addLast(word.charAt(i));
        }
        return deque;
    }

    /**
     * return true if the word is a palindrome, e.g 'a','noon'
     */

    public boolean isPalindrome(String word) {
        Deque<Character> deque = wordToDeque(word);
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()){
                return false;
            }
        }
        return true;
    }

    /**
     * overloads isPalindrome with certain CharacterComparator cc
     */
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> deque = wordToDeque(word);
        while (deque.size() > 1) {
            if (!cc.equalChars(deque.removeFirst(), deque.removeLast())) {
                return false;
            }
        }
        return true;
    }


}
