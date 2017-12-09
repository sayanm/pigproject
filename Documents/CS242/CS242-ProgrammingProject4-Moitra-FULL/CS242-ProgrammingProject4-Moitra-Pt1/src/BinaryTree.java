import java.util.Iterator;
import java.util.NoSuchElementException;


public class BinaryTree <E> {
   protected Node <E> root;

   /**
     Constructor - initializes the tree to an empty tree
     */
   public BinaryTree () {
      root = null;
   }

   /**
     Construct a new Binary tree with data in its root;
     leftTree as its left sub tree and rightTree as its right
     subtree.
    */
   public BinaryTree(E data, BinaryTree <E> leftTree,
            BinaryTree <E> rightTree) {
	  root = new Node<E> (data);
	  if (leftTree != null)
		  root.left = leftTree.root;
      else root.left = null;

	  if (rightTree != null)
		  root.right = rightTree.root;
	  else
	      root.right = null;
   }

   /**
   	 prints the elements of the tree rooted at this
   	 node in the inorder fashion
   	*/
   private void inorderPrint(Node <E> aNode) {
   	  if (aNode == null) return;
   	  if (aNode.left != null)
   	     inorderPrint(aNode.left);
   	  System.out.println(aNode.data);
   	  if (aNode.right != null)
   	     inorderPrint(aNode.right);
   }
   /** prints the elements of this tree in the
       inorder format
     */
   public void inorderPrint()  {
      inorderPrint(root);
   }

   /** prints the elements of the tree rooted
       at this node in the preorder fashion
     */
   private void preorderPrint(Node <E> aNode) {
   	  if (aNode == null) return;
   	  System.out.println(aNode.data);
   	  if (aNode.left != null)
   	    preorderPrint(aNode.left);
   	  if (aNode.right != null)
   	    preorderPrint(aNode.right);
   }

   /** prints the elements of this tree in the
       preorder format
     */
   public void preorderPrint()  {
        preorderPrint(root);
   }

   /** prints the elements of the tree rooted at this
       node in the postorder fashion
     */
   private void postorderPrint(Node <E> aNode) {
   	  if (aNode == null) return;
   	  if (aNode.left != null)
         postorderPrint(aNode.left);
   	  if (aNode.right != null)
   	     postorderPrint(aNode.right);
      System.out.println(aNode.data);
   }

   /** prints the elements of this tree in the
       postorder format
     */
   public void postorderPrint()  {
        postorderPrint(root);
   }

   /**
     @return
          the number of elements in the tree
    */
  
   public int size() {
	   return size(root);
   }
   
   int size(Node<E> localRoot) {
	   if (localRoot == null) {
		   return 0;
	   }
	   else
		   return size(localRoot.left) + size(localRoot.right) + 1;
   }

   /** @return the height of this tree */
  
   public int height() {
	   return height(root);
   }
   
   int height(Node<E> localRoot) {
	   if (localRoot == null) {
		   return -1;
	   }
	   int leftHeight = height(localRoot.left);
	   int rightHeight = height(localRoot.right);
	   
	   if (leftHeight > rightHeight) {
		   return leftHeight + 1;
	   }
	   else {
		   return rightHeight+1;
	   }
   }

   public Iterator <E> iterator() {
	   return new DepthFirstIterator();
   }

   private class DepthFirstIterator implements Iterator <E> {
	  /* code for Tree Iterator is taken from
	   https://inst.eecs.berkeley.edu/~cs61b/sp06/labs/t9-3-1
	  */

   	  private java.util.Stack <Node <E> > fringe = new java.util.Stack <Node <E> > ( );

      public DepthFirstIterator () {
         if (root != null)
   	         fringe.push (root);
   	  }

   	  public boolean hasNext () {
   	     return !fringe.empty ();
   	  }

   	  public E next ( ) {
   	     if (!hasNext ( ))
   	       throw new NoSuchElementException ("tree ran out of elements");

   	     Node <E> node = fringe.pop ();
   	     if (node.right != null)
   	        fringe.push (node.right);

   	     if (node.left != null)
   	        fringe.push (node.left);

   	     return node.data;
   	  }

   	  public void remove () {
   	     throw new UnsupportedOperationException ();
   	  }
   }

   /** Class to encapsulate a tree node. */
       protected static class Node<E> {
           // Data Fields

           /** The information stored in this node. */
           public E data;
           /** Reference to the left child. */
           public Node<E> left;
           /** Reference to the right child. */
           public Node<E> right;

           // Constructors
           /**
            * Construct a node with given data and no children.
            * @param data The data to store in this node
            */
           public Node(E data) {
               this.data = data;
               left = null;
               right = null;
           }

           // Methods
           /**
            * Returns a string representation of the node.
            * @return A string representation of the data fields
            */
           @Override
           public String toString() {
               return data.toString();
           }
    }
}
