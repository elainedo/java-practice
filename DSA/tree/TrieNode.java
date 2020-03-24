class TrieNode {
    final int ALPHABET_SIZE = 26;
    TrieNode[] children;
    boolean isEndOfWord;
    
    TrieNode (){
        children = new TrieNode[ALPHABET_SIZE];
        isEndOfWord = false;
    }
}