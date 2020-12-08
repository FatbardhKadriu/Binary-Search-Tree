public class BinarySearchTree {

    // Root of BST
    BstNode root;

    BinarySearchTree() {
        root = null;
    }

    void Insert(int data) {
        root = insert(root, data);
    }

    BstNode insert(BstNode root, int data) {

        if (root == null) {
            root = new BstNode(data);
        } else if (data < root.data)
            root.Left = insert(root.Left, data);
        else if (data > root.data)
            root.Right = insert(root.Right, data);

        return root;
    }

    void InOrder() {
        inorder(root);
    }

    void inorder(BstNode root) {
        if (root != null) {
            inorder(root.Left);
            System.out.print(root.data + " ");
            inorder(root.Right);
        }
    }

    void PreOrder() {
        preorder(root);
    }

    void preorder(BstNode root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preorder(root.Left);
        preorder(root.Right);
    }

    void PostOrder() {
        postorder(root);
    }

    void postorder(BstNode root) {
        if (root == null)
            return;
        postorder(root.Left);
        postorder(root.Right);
        System.out.print(root.data + " ");
    }

    int Height() {
        return height(root);
    }

    int height(BstNode root) {
        if (root == null)
            return -1;
        int leftHeight = height(root.Left);
        int rightHeight = height(root.Right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    boolean Search(int data) {
        return search(root, data);
    }

    boolean search(BstNode root, int data) {
        boolean result;
        if (root == null) {
            result = false;
        } else if (root.data == data) {
            result = true;
        } else if (data <= root.data) {
            result = search(root.Left, data);
        } else {
            result = search(root.Right, data);
        }
        return result;
    }

    void Delete(int data) {
        delete(root, data);
    }

    BstNode delete(BstNode root, int data) {
        if (root == null)
            return root;
        else if (data < root.data)
            root.Left = delete(root.Left, data);
        else if (data > root.data)
            root.Right = delete(root.Right, data);
        else // found
        {
            // Case 1: No child
            if (root.Left == null && root.Right == null) {
                // delete root;
                root = null;
            }
            // Case 2: One child
            else if (root.Left == null) {
                root = root.Right;
            } else if (root.Right == null) {
                root = root.Left;
            }
            // Case 3: 2 children
            else {
                BstNode temp = FindMin(root.Right);
                root.data = temp.data;
                root.Right = delete(root.Right, temp.data);
            }
        }
        return root;
    }

    BstNode FindMin(BstNode root) {
        while (root.Left != null)
            root = root.Left;
        return root;
    }
}