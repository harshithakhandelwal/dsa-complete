package org.example.trees;

 public class TreeNode {
    // Value of the node
    public int val;

    // Pointer to the left child node
    public TreeNode left;

    // Pointer to the right child node
    public TreeNode right;

    // Constructor to initialize the node with a
    // value and set left and right pointers to null
   public TreeNode(int x) {
      val = x;
      left = null;
      right = null;
    }

}
