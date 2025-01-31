#include <iostream>
using namespace std;

struct BstNode
{
    int data;
    BstNode* Left;
    BstNode* Right;
};

BstNode* getNewNode(int data);
BstNode* Insert(BstNode* root, int data);
bool Search(BstNode* root, int data);
void Preorder(BstNode* root);
void PostOrder(BstNode* root);
void InOrder(BstNode* root);
int Height(BstNode* root);
BstNode* Delete(BstNode* root, int data);
BstNode* FindMin(BstNode* root);

int main()
{
    /*
      Creating an example tree
                 15
               /    \           |
              10     20         |
             / \       \        | height = 3
            8   11      25      |
           /     \      / \     |
          7      14    22  26   |
    */

    BstNode* root = NULL; // Creating an empty tree

    // Insert values 
    root = Insert(root, 15);
    root = Insert(root, 10);
    root = Insert(root, 20);
    root = Insert(root, 25);
    root = Insert(root, 8);
    root = Insert(root, 22);
    root = Insert(root, 7);
    root = Insert(root, 26);
    root = Insert(root, 11);
    root = Insert(root, 14);

    // Delete(root, 25);

    cout << "Preorder: ";
    Preorder(root);
    cout << "\nPostorder: ";
    PostOrder(root);
    cout << "\nInorder: ";
    InOrder(root);

    cout << "\n\nHeight of the tree is: " << Height(root) << endl;

    // Search in BST for a value
    int data;
    cout << "Give the node value to find:: ";
    cin >> data;
    if (Search(root, data))
    {
        cout << data << " is found in the tree.\n";
    }
    else
    {
        cout << data << " does note exists in the tree.\n";
    }

    return 0;
}

BstNode* getNewNode(int data)
{
    BstNode* newNode = new BstNode();
    newNode->data = data;
    newNode->Left = NULL;
    newNode->Right = NULL;
    return newNode;
};

BstNode* Insert(BstNode* root, int data)
{
    if (root == NULL)
    {
        //empty tree
        root = getNewNode(data);
    }
    else if (data <= root->data)
    {
        root->Left = Insert(root->Left, data);
    }
    else
    {
        root->Right = Insert(root->Right, data);
    }
    return root;
}

bool Search(BstNode* root, int data)
{
    bool result;
    if (root == NULL)
    {
        result = false;
    }
    else if (root->data == data)
    {
        result = true;
    }
    else if (data <= root->data)
    {
        result = Search(root->Left, data);
    }
    else
    {
        result = Search(root->Right, data);
    }
    return result;
}

void Preorder(BstNode* root)
{
    if (root == NULL) return;
    cout << root->data << " ";
    Preorder(root->Left);
    Preorder(root->Right);
}

void PostOrder(BstNode* root)
{
    if (root == NULL) return;
    PostOrder(root->Left);
    PostOrder(root->Right);
    cout << root->data << " ";
}

void InOrder(BstNode* root)
{
    if (root == NULL) return;
    InOrder(root->Left);
    cout << root->data << " ";
    InOrder(root->Right);
}

int Height(BstNode* root)
{
    if (root == NULL) return -1;
    int leftHeight = Height(root->Left);
    int rightHeight = Height(root->Right);
    return max(leftHeight, rightHeight) + 1;

}

BstNode* Delete(BstNode* root, int data)
{
    if (root == NULL) return root;
    else if (data < root->data) root->Left = Delete(root->Left, data);
    else if (data > root->data) root->Right = Delete(root->Right, data);
    else // Found
    {
        // Case 1: No child
        if (root->Left == NULL && root->Right == NULL) {
            delete root;
            root = NULL;
        }
        // Case 2: One child
        else if (root->Left == NULL) {
            BstNode* temp = root;
            root = root->Right;
            delete temp;
        }
        else if (root->Right == NULL) {
            BstNode* temp = root;
            root = root->Left;
            delete temp;
        }
        // Case 3: 2 children
        else {
            BstNode* temp = FindMin(root->Right);
            root->data = temp->data;
            root->Right = Delete(root->Right, temp->data);
        }
    }
    return root;

}

BstNode* FindMin(BstNode* root)
{
    while (root->Left != NULL) root = root->Left;
    return root;
}