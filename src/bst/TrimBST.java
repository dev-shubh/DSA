package bst;

/**
 * Created by shumishra on 9/12/17.
 */
public class TrimBST {
}


 //* Definition for a binary tree node.
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {

    public TreeNode trimBST(TreeNode node, int min, int max) {
        if(node == null) return null;
        if(node.val >= min && node.val <= max) {
            node.left = trimBST(node.left, min, max);
            node.right =  trimBST(node.right, min, max);
            return node;
        }
        else if(node.val < min) {
            node = trimBST(node.right, min, max);
            return node;
        }
        else if(node.val > max) {
            node = trimBST(node.left, min, max);
            return node;
        }
        else return null;

    }
//
//    public TreeNode trimBST(TreeNode node, int min, int max) {
//
//        if(node == null) return null;
//
//        if(node.val >= min && node.val <= max) { // If node is a valid node
//            if(node.left != null) {
//                if(node.left.val < min) {
//                    node.left = node.left.right;
//                }
//                node.left = trimBST(node.left, min, max);
//            }
//            if(node.right != null) {
//                if(node.right.val > max) {
//                    node.right = node.right.left;
//                }
//                node.right =  trimBST(node.right, min, max);
//            }
//            return node;
//        }
//        else if(node.val < min) { // node is smaller than minimum, hence we will never find a valid node in left sub tree, hence we need to only traverse the right subtree.
//            node = trimBST(node.right, min, max);
//            return node;
//        }
//        else if(node.val > max) { // node is larger that maximum, hence we will never find a valid node in the right sub tree, hence we traverse only the left sub tree.
//            node = trimBST(node.left, min, max);
//            return node;
//        }
//
//        else return null;

    }
