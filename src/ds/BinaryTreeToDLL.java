package ds;


import sun.jvm.hotspot.debugger.windbg.DLL;

public class BinaryTreeToDLL {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
    }

    static class DLLNode {
        int data;
        DLLNode prev;
        DLLNode next;
    }

    private static DLLNode convertBinaryTreeToDLL(TreeNode treeNode) {
        DLLNode dllHead = null;
        DLLNode dllEnd = solve(treeNode);
        DLLNode it = dllEnd;
        while (it != null) {
            it = it.prev;
            dllHead = it;
        }
        return dllHead;
    }

    private static DLLNode solve(TreeNode treeNode) {
        if (treeNode == null) return null;
        DLLNode prev = solve(treeNode.left);
        DLLNode current = new DLLNode();
        current.data = treeNode.data;
        if( prev == null) {
            prev = current;
        }
        else {
            prev.next = current;
            current.prev = prev;
        }
        current.next = solve(treeNode.right);
        return current.next == null ? current : current.next;
    }

    private static TreeNode convertToDLLInPlace(TreeNode node){
        solveInplace(node);
        TreeNode head = node;
        while (head.left != null) {
            head = head.left;
        }
        return head;
    }

    private static void solveInplace(TreeNode node) {
        if (node == null) return;
        solveInplace(node.left);
        solveInplace(node.right);
        TreeNode prev = node.left;
        TreeNode next = node.right;
        if (node.left != null) {
            while (prev.right != null) {
                prev = prev.right;
            }
        }
        if (node.right != null) {
            while (next.left != null) {
                next = next.left;
            }
        }
        node.left = prev;
        if(prev != null) {
            prev.right = node;
        }
        node.right = next;
        if (next != null) {
            next.left = node;
        }
    }


    public static void main(String[] args) {
        TreeNode treeNode = initialiseTree();
        TreeNode head = convertToDLLInPlace(treeNode);
        System.out.println(head.data);
    }

    private static TreeNode initialiseTree() {
        TreeNode treeNode = new TreeNode();
        treeNode.data = 10;

        treeNode.left = new TreeNode();
        treeNode.left.data = 12;

        treeNode.right = new TreeNode();
        treeNode.right.data = 15;

        treeNode.left.left = new TreeNode();
        treeNode.left.left.data = 25;

        treeNode.right.left = new TreeNode();
        treeNode.right.left.data = 36;

        treeNode.left.right = new TreeNode();
        treeNode.left.right.data = 30;

        return treeNode;
    }
}




