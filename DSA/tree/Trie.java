class Trie {
    
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        int len = word.length();
        TrieNode ptr = root;
        for (int i = 0; i < len; i++) {
            int key = word.charAt(i)-'a';
            if (ptr.children[key] == null)
                ptr.children[key] = new TrieNode();
            ptr = ptr.children[key];
        }
        ptr.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        int len = word.length();
        TrieNode ptr = root;
        for (int i = 0; i < len; i++) {
            int key = word.charAt(i)-'a';
            if (ptr.children[key] == null) {
                return false;
            }
            ptr = ptr.children[key];
        }
        return ptr != null && ptr.isEndOfWord;
    }
    
    public boolean startsWith(String prefix) {
        int len = prefix.length();
        TrieNode ptr = root;
        for (int i = 0; i < len; i++) {
            int key = prefix.charAt(i)-'a';
            if (ptr.children[key] == null) {
                return false;
            }
            ptr = ptr.children[key];
        }
        return ptr != null;
    }
}
