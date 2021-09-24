public class Tree {
    private Estudante estudante;
    Node root;
 
    // Tree Node
    static class Node {
        Estudante es;
        Node left, right;
        Node(Estudante arr)
        {
            this.es = arr;
            this.left = null;
            this.right = null;
        }
        
    }
 
    // Function to insert nodes in level order
    public Node insertLevelOrder(Estudante[] arr, Node root,
                                                int i)
    {
        // Base case for recursion
        if (i < arr.length) {
            Node temp = new Node(arr[i]);
            root = temp;
 
            // insert left child
            root.left = insertLevelOrder(arr, root.left,
                                             2 * i + 1);
 
            // insert right child
            root.right = insertLevelOrder(arr, root.right,
                                               2 * i + 2);
        }
        return root;
    }
 
    // Function to print tree nodes in InOrder fashion
    public void inOrder(Node root)
    {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.es + " ");
            inOrder(root.right);
        }
    }

    public Estudante[] inserirEstudante(Estudante array[]) {
        for (int i = 0; i < array.length; i++) {
            estudante = new Estudante();
            array[i] = estudante;
            //System.out.println(array[i]);
        }

        return array;
    }
 
    // Driver program to test above function
    public static void main(String args[])
    {
        Estudante[] array = new Estudante[100000];


        Tree t2 = new Tree();

        t2.inserirEstudante(array);

        t2.root = t2.insertLevelOrder(array, t2.root, 0);
        t2.inOrder(t2.root);
        // int arr[] = { 1, 2, 3, 4, 5, 6, 6, 6, 6 };
        // t2.root = t2.insertLevelOrder(arr, t2.root, 0);
        // t2.inOrder(t2.root);
    }
}
