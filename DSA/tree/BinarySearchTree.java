import java.util.*;

class BinarySearchTree {

    Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int val) {
        root = insertHelper(root, val);
    }

    public void delete(int val) {
        root = deleteHelper(root, val);
    } 

    private Node insertHelper(Node node, int val) {
        if (node == null) {
            node = new Node(val);
        } else if (val < node.val) {
            node.left = insertHelper(node.left, val);
        } else if (val > node.val) {
            node.right = insertHelper(node.right, val);
        }
        return node;
    }

    private Node deleteHelper(Node root, int val) {
        if (root == null) {
            return root;
        } else if (val < root.val) {
            root.left = deleteHelper(root.left, val);
        } else if (val > root.val) {
            root.right = deleteHelper(root.right, val);
        } else {
            // node has zero or one child
            if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            } else {
                int minVal = getMin(root.right);
                root.val = minVal;
                root.right = deleteHelper(root.right, minVal);
            }
        }
        return root;
    }

    private int getMin(Node root) {
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

    public List<Integer> inorder() {
        return inorder(root);
    }

    private List<Integer> inorder(Node root) {
        List<Integer> lst = new ArrayList<>();
        if (root != null) {
            lst.addAll(inorder(root.left));
            lst.add(root.val);
            lst.addAll(inorder(root.right));
        }      
        return lst;        
    }                                                                       
}