/* 
AVL tree is a self-balancing Binary Search Tree (BST) 
where the difference between heights of left and right 
subtrees cannot be more than one for all nodes.

guide source: https://www.baeldung.com/java-avl-trees (modified)
*/

import java.util.*;

class AVLTree {
    private AVLNode root;

    public AVLTree() {
        root = null;
    }

    public void insert(int key) {
        root = insertHelper(root, key);
    }

    public void delete(int key) {
        root = deleteHelper(root, key);
    }

    public List<Integer> inorder() {
        return inorder(root);
    }

    private List<Integer> inorder(AVLNode root) {
        List<Integer> lst = new ArrayList<>();
        if (root != null) {
            lst.addAll(inorder(root.left));
            lst.add(root.val);
            lst.addAll(inorder(root.right));
        }      
        return lst;        
    } 

    
    public AVLNode rotateRight(AVLNode node) {
        AVLNode left = node.left;
        AVLNode leftRight = left.right;
        node.left = leftRight;
        left.right = node;
        updateHeight(node);
        updateHeight(left);
        return left;
    }

    public AVLNode rotateLeft(AVLNode node) {
        AVLNode right = node.right;
        AVLNode rightLeft = right.left;
        node.right = rightLeft;
        right.left = node;
        updateHeight(node);
        updateHeight(right);
        return right;
    }

    public AVLNode rebalance(AVLNode node) {
        int balaceFactor = getBalance(node);
        if (balaceFactor > 1) {
            if (height(node.right.right)<height(node.right.left)) {
                node.right = rotateRight(node.right);
            }
            node = rotateLeft(node);
        } else if (balaceFactor < -1) {
            if (height(node.left.left)<height(node.left.right)) {
                node.left = rotateLeft(node.left);
            }
            node = rotateRight(node);
        }
        return node;
    }

    private AVLNode insertHelper(AVLNode node, int key) {
        if (node == null) {
            return new AVLNode(key);
        } else if (node.val > key) {
            node.left = insertHelper(node.left, key);
        } else if (node.val < key) {
            node.right = insertHelper(node.right, key);
        } else {
            throw new RuntimeException("duplicate Key!");
        }
        return rebalance(node);
    }

    private AVLNode deleteHelper(AVLNode node, int key) {
        if (node == null) {
            return node;
        } else if (node.val > key) {
            node.left = deleteHelper(node.left, key);
        } else if (node.val < key) {
            node.right = deleteHelper(node.right, key);
        } else {
            if (node.left == null) {
                node = node.right;
            } else if (node.right == null) {
                node = node.left;
            } else {
                int minVal = getMin(node.right);
                node.val = minVal;
                node.right = deleteHelper(node.right, minVal);
            }
        }
        if (node != null) {
            node = rebalance(node);
        }
        return node;
    }

    private int getMin(AVLNode root) {
        if (root != null) {
            int min = root.val;
            while (root.left != null) {
                root = root.left;
                min = root.val;
            }
            return min;
        }
        return -1;
    }

    private int height(AVLNode node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    private void updateHeight(AVLNode node) {
        n.height = 1 + Math.max(height(node.left), height(node.right));
    }

    private int getBalance(AVLNode node) {
        if (node == null) {
            return 0;
        }
        return height(node.right) - height(node.left);
    }
}