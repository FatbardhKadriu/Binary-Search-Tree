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

        tree.Delete(20);

        // print inorder traversal of the BST
        System.out.print("\nInOrder: ");
        tree.InOrder();
        System.out.print("\n\nPreOrder: ");
        tree.PreOrder();
        System.out.print("\n\nPostOrder: ");
        tree.PostOrder();
        System.out.println("\n\nHeight of the tree is: " + tree.Height());
        System.out.print("Give node to find: ");
        Scanner input = new Scanner(System.in);
        int data = input.nextInt();
        if (tree.Search(data)) {
            System.out.println(data + " is found in the tree");
        } else {
            System.out.println(data + " does not exists");
        }
    }
}
