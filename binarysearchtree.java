import java.util.HashSet;

class Node {
    int data;
    Node left, right;
 
    Node(int value) {
        data = value;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;
    
    public void insert(int data) {
        root = insertRecursive(root, data);
    }
 
    private Node insertRecursive(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data)
            root.left = insertRecursive(root.left, data);
        else if (data > root.data)
            root.right = insertRecursive(root.right, data);
        return root;
    }
 
    public boolean findPair(Node root, int sum, HashSet<Integer> set) {
        if (root == null)
            return false;
        if (findPair(root.left, sum, set))
            return true;
        if (set.contains(sum - root.data)) {
            System.out.println("Pair is (" + (sum - root.data) + ", " + root.data + ")");
            return true;
        } else
            set.add(root.data);
        return findPair(root.right, sum, set);
    }
}

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(20);
        bst.insert(30);
        bst.insert(40);
        bst.insert(50);
        bst.insert(60);
        bst.insert(70);
 
        int sum = 130;
        HashSet<Integer> set = new HashSet<>();
        if (!bst.findPair(bst.root, sum, set))
            System.out.println("Nodes are not found.");
    }
}
