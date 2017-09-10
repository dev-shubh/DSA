package gfgs;

/**
 * Created by shumishra on 8/29/17.
 */
class GfG
{
    Node LCA(Node root, int n1,int n2)
    {
        if(root == null){
            return null;
        }

        if(root.data == n1 || root.data == n2) {
            return root;
        }

        Node isPresentInLeft = LCA(root.left, n1, n2);
        Node isPresentInRight = LCA(root.right, n1, n2);

        if (isPresentInLeft != null && isPresentInRight != null) {
            return root;
        }
        if (isPresentInLeft != null) return isPresentInLeft;
        if (isPresentInRight != null) return isPresentInRight;

        return null;
    }

}

class Node
{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
