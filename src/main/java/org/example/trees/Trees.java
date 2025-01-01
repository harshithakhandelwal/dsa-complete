package org.example.trees;

import java.util.*;


public class Trees {

  public void preOrderTraversal(TreeNode root, List<Integer> list) {
    if (root == null) {
      System.out.println(list);
      return;
    }

    list.add(root.val);
    preOrderTraversal(root.left, list);
    preOrderTraversal(root.right, list);
    System.out.println(list);
  }

  public void postOrderTraversal(TreeNode root, List<Integer> list) {
    if (root == null) {
      System.out.println(list);
      return;
    }

    postOrderTraversal(root.left, list);
    postOrderTraversal(root.right, list);
    list.add(root.val);
    System.out.println(list);
  }

  public void inOrderTraversal(TreeNode root, List<Integer> list) {
    if (root == null) {
      System.out.println(list);
      return;
    }

    inOrderTraversal(root.left, list);
    list.add(root.val);
    inOrderTraversal(root.right, list);
    System.out.println(list);
  }

  public List<List<Integer>> levelOrderTraversal(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();

    List<List<Integer>> result = new ArrayList<>();

    if (root == null) {
      System.out.println(result);
      return result;
    }
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> sub = new ArrayList<>();

      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        sub.add(node.val);
        if (node.left != null)
          queue.add(node.left);
        if (node.right != null)
          queue.add(node.right);
      }
      result.add(sub);
    }
    System.out.println(result);
    return result;
  }

  public void iterativePreorderTraversal(TreeNode node, List<Integer> result) {
    if (node == null) {
      System.out.println(result);
      return;
    }
    Stack<TreeNode> stack = new Stack<>();
    stack.push(node);
    while (!stack.isEmpty()) {
      node = stack.pop();
      result.add(node.val);
      if (node.right != null) stack.push(node.right);
      if (node.left != null) stack.push(node.left);
    }
    System.out.println(result);
  }

  public void iterativeInorderTraversal(TreeNode node) {
    TreeNode current = node;

    Stack<TreeNode> stack = new Stack<>();
    while (current != null || !stack.isEmpty()) {
      while (current != null) {
        stack.push(current);
        current = current.left;
      }
      current = stack.pop();
      System.out.print(current.val + " ");
      current = current.right;
    }
  }


  public void postOrderTraversalUsing1Stack(TreeNode node) {


  }

  public void postOrderTraversalUsing2Stack(TreeNode root) {

    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return;
    }

    Stack<TreeNode> st1 = new Stack<>();
    Stack<TreeNode> st2 = new Stack<>();

    st1.push(root);
    while (!st1.isEmpty()) {
      root = st1.pop();
      st2.push(root);
      if (root.left != null)
        st1.push(root.left);
      if (root.right != null)
        st1.push(root.right);
    }
    while (!st2.isEmpty()) {
      result.add(st2.pop().val);
    }
    System.out.println(result);
  }

  public void PreOrderInOrderPostOrderTraversalInOneTraversal() {

  }

  public void heightOfABinaryTree(TreeNode root) {
    int count = 0;
    Queue<TreeNode> queue = new LinkedList<>();
    if (root == null)
      return;
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode ele = queue.poll();

        if (ele.left != null) queue.add(ele.left);
        if (ele.right != null) queue.add(ele.right);
      }
      count++;
    }
    System.out.println(count);
  }

  public int checkIfABinaryTreeIsBalancedOrNot(TreeNode root) {
    if (root == null)
      return 0;
    int lenr = checkIfABinaryTreeIsBalancedOrNot(root.right);
    if (lenr == -1)
      return -1;
    int lenl = checkIfABinaryTreeIsBalancedOrNot(root.left);
    if (lenl == -1)
      return -1;
    if (Math.abs(lenl - lenr) > 0) return -1;
    return Math.max(lenl, lenr) + 1;
  }

  public int diameterOfABinaryTree(TreeNode node, int diameter) {
    if (node == null)
      return 0;
    int lenr = diameterOfABinaryTree(node.right,diameter);
    int lenl = diameterOfABinaryTree(node.left,diameter);
    diameter = Math.max(diameter, lenl + lenr);
    return 1 + Math.max(lenl, lenr);
  }

  public int maximumPathSum(TreeNode node, int sum) {
    if (node == null)
      return 0;
    int lenr = Math.max(maximumPathSum(node.right,sum),0);
    int lenl = Math.max(maximumPathSum(node.left,sum),0);
    sum = Math.max(sum, lenl + lenr+node.val);
    return 1 + Math.max(lenl, lenr)+node.val;
  }

  public boolean checkIfTwoTreesAreIdenticalOrNot(TreeNode root1, TreeNode root2) {
    if (root1 == null && root2 == null) {
      System.out.println(true);
      return true;
    }
    if (root1 == null || root2 == null) {
      System.out.println(false);
      return false;
    }

    return ((root1.val == root2.val) &&
            checkIfTwoTreesAreIdenticalOrNot(root1.left, root2.left) &&
            checkIfTwoTreesAreIdenticalOrNot(root1.right, root2.right));
  }


  public void zigZagTraversal(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();

    List<List<Integer>> result = new ArrayList<>();

    if (root == null) {
      System.out.println(result);
      return;
    }
    queue.add(root);
    boolean switchleftToRight = true;
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> sub = new ArrayList<>();

      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        int index = switchleftToRight ? i : (size-1-i);
        assert node != null;
        sub.add(index,node.val);
        if (node.left != null)
          queue.add(node.left);
        if (node.right != null)
          queue.add(node.right);
      }
      switchleftToRight = !switchleftToRight;
      result.add(sub);
    }
    System.out.println(result);
    return;
  }

  public void boundaryTraversal(TreeNode node, List<Integer> res) {
    if(node==null)
      return;
    if(!isLeaf(node))
      res.add(node.val);

    addLeft(node,res);
    addLeaves(node,res);
    addRight(node,res);

    System.out.println(res);
  }

  boolean isLeaf(TreeNode node){
    return node.left==null && node.right==null;
  }

  void addLeft(TreeNode node, List<Integer> res){
    TreeNode curr = node.left;
    while (curr!=null) {
      if (!isLeaf(curr))
        res.add(curr.val);
      if (curr.left != null) {
        curr = curr.left;
      } else {
        curr = curr.right;
      }
    }
  }

  void addRight(TreeNode node, List<Integer> res){
    TreeNode curr = node.left;
    List<Integer> temp = new ArrayList<>();
    while (curr!=null) {
      if (!isLeaf(curr))
        temp.add(curr.val);
      if (curr.right != null) {
        curr = curr.right;
      } else {
        curr = curr.left;
      }
    }
    for(int i = temp.size()-1; i>=0; i--){
      res.add(temp.get(i));
    }
  }

  void addLeaves(TreeNode node,List<Integer> res){
    if(isLeaf(node)) {
      res.add(node.val);
      return;
    }
    if(node.left!=null)
      addLeaves(node.left,res);
    if(node.right!=null)
      addLeaves(node.right,res);
  }
  public void verticalTraversal(TreeNode root) {
    TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
    Queue<Tuple> queue = new LinkedList<Tuple>();
    queue.add(new Tuple(root,0,0));
    while (!queue.isEmpty()){
      Tuple tuple = queue.poll();
      TreeNode node = tuple.node;
      int x = tuple.row;
      int y = tuple.col;
      if(!map.containsKey(x))
        map.put(x,new TreeMap<>());
      if(!map.get(x).containsKey(y))
        map.get(x).put(y,new PriorityQueue<>());
    }
  }

  public void topViewTree(){

  }


}
