import java.util.*;

class Test {
    public static void main (String[] args) {
        AVLTree bst = new AVLTree();
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        printList(bst.inorder());
        System.out.println("Delete 20");
        bst.delete(20);
        printList(bst.inorder());

        System.out.println("Delete 30");
        bst.delete(30);
        printList(bst.inorder());

        System.out.println("Delete 50");
        bst.delete(50);
        printList(bst.inorder());
    }

    public static void printList(List<Integer> lst) {
        for (int num : lst) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}