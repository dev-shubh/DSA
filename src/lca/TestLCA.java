package lca;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by shumishra on 6/13/17.
 */
public class TestLCA {

    public static void main(String[] args) {
        Node root = createBinaryTree();
        System.out.println(LCA(root, 3,19));
        System.out.println(efficientLCA(root, 3,19).data);
        Stack<Node> pathS = new Stack<>();
        getPath(root, 19, pathS);
        System.out.println(pathS.size());
    }


    /*
    Note that the above method assumes that keys are present in Binary Tree. If one key is present and other is absent,
    then it returns the present key as LCA (Ideally should have returned NULL). We can extend this method to handle all
    cases by passing two boolean variables v1 and v2. v1 is set as true when n1 is present in tree and v2 is set as true
    if n2 is present in tree.
     */
    private static Node efficientLCA(Node root, int n1, int n2) { // traverses the tree 1 time only.
        if(root == null) {
            return null;
        }

        if(root.data == n1 || root.data == n2) {
            return root;
        }

        if(efficientLCA(root.left, n1, n2) != null && efficientLCA(root.right, n1, n2) != null) {
            return root;
        }

        else if(efficientLCA(root.left, n1, n2) != null || efficientLCA(root.right, n1, n2) != null) {
            return efficientLCA(root.left, n1, n2) != null ? efficientLCA(root.left, n1, n2) : efficientLCA(root.right, n1, n2);
        }
        else {
            return null;
        }

    }

    private static int LCA(Node root, int n1, int n2) {  // traverses the tree 3 times
        ArrayList<Integer> path_n1 = new ArrayList<>();
        ArrayList<Integer> path_n2 = new ArrayList<>();

        path(root, n1, path_n1);
        path(root, n2, path_n2);

        print(path_n1);
        print(path_n2);

        int i = path_n1.size() -1;
        int j = path_n2.size() -1;

        int ans = -1;

        while( i >=0 && j >= 0) {
            if(path_n2.get(i) == path_n1.get(j)) {
                ans = path_n2.get(i);
            }
            i--;
            j--;
        }
        return ans;
    }

    private static boolean path(Node root, int n, ArrayList<Integer> path_n) {
        if(root == null) return false;

        if(root.data == n) return true;

        if(path(root.left, n, path_n) == true || path(root.right, n, path_n) == true) {
            path_n.add(root.data);
            return true;
        }
        return false;
    }

    private static Node createBinaryTree() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(6);


        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(3);
        root.right.right = new Node(19);

        return root;
    }

    private static void print(ArrayList<Integer> arrayList) {
        arrayList.forEach( it -> System.out.print(it.toString() + "  "));
        System.out.println("\n");
    }

    private static boolean getPath(Node node, int x, Stack<Node> pathStack) {
        if (node == null ) return false;
        if (node.data == x) {
            pathStack.add(node);
            return true;
        }


        if(getPath(node.left, x, pathStack) || getPath(node.right, x, pathStack)) {
            pathStack.add(node);
            return true;
        }

        return false;

    }
}
