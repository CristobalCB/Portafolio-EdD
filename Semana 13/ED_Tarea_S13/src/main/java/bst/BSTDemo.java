package bst;

public class BSTDemo {
    public static void main(String[] args) {
        BST tree = new BST();

        /*
                       8
                    /      \
                 6            9
               /    \       /  \
            5        null     null null
         /   \       /  \
        4     7  null   null        */

        tree.root = new Nodo(8);
        tree.root.rightChild = new Nodo(9);
        tree.root.leftChild = new Nodo(6);
        tree.root.leftChild = new Nodo(5);
        tree.root.leftChild.leftChild = new Nodo(4);
        tree.root.leftChild.rightChild = new Nodo(7);
        System.out.println(tree.buscar(tree.root, 000));
    }
}


