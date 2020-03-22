class AVLNode {
    AVLNode(int v) {
        val = v;
        height = 0;
        left = null;
        right = null;
    }

    int val;
    int height; 
    AVLNode left;
    AVLNode right;
}