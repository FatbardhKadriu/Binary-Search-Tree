import java.util.Scanner;

public class TestClass {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.Insert(50);
        tree.Insert(30);
        tree.Insert(20);
        tree.Insert(40);
        tree.Insert(70);
        tree.Insert(60);
        tree.Insert(80);

        tree.Delete(10);

        // print preorder traversal of the BST
        System.out.print("\nPreOrder: ");
        tree.PreOrder();

        // print inorder traversal of the BST
        System.out.print("\n\nInOrder: ");
        tree.InOrder();

        // print postorder traversal of the BST
        System.out.print("\n\nPostOrder: ");
        tree.PostOrder();

        System.out.println("\n\nHeight of the tree is: " + tree.Height());

        System.out.print("\nGive the node value to find: ");

        Scanner input = new Scanner(System.in);
        int data = input.nextInt();
        input.close();

        if (tree.Search(data)) {
            System.out.println(data + " is found in the tree.");
        } else {
            System.out.println(data + " does not exists in the tree.");
        }
    }
}
