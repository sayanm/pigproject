public class BinarySearchTree <E extends Comparable <E>>
        extends BinaryTree <E> implements SearchTree <E> {
   // denotes whether the addition is successful
   protected boolean addReturn;

   /**
     Constructor - initializes the tree to an empty tree
     */
   public BinarySearchTree () {
      super() ;
   }

   public BinarySearchTree(E data, BinarySearchTree <E> left,
          BinarySearchTree <E> right)  {
	   super(data, left, right);
   }
   
   

   /**
     Searches for a given element in the binary search tree
     @param
           target element to be searched
     @param
           count - to keep track of the comparisons made for this
                   find operations
     @return
           the object if it is found in the tree; null
                     otherwise
    */

   public E find (E target, IntObject count) {
	  return find(root, target, count);
   }
   
   private E find (Node<E> localRoot, E target, IntObject count) {
	   if (localRoot == null) {
		   return null;
	   }
	   int compResult = target.compareTo(localRoot.data);
	   int newCount = count.getData();
	   newCount++;
	   count.setData(newCount);
	   
	   if (compResult == 0) {
		   return localRoot.data;
	   }
	   else if (compResult < 0) {
		   return find(localRoot.left, target, count);
	   }
	   else
		   return find(localRoot.right, target, count);
	  
   }

   /**
     inserts an element into a BST
     @param
           item element that needs to be inserted
     @return true if the insertion is successful, false otherwise
    */
    // Complexity: O(h) - where h is the height of the tree.
    // In the worst case it could be O(n).  But on average
    // we can expect a complexity of O(log n)
    public boolean add(E item) {
	   root = add(root, item);
	   return addReturn;
   }

   private Node <E> add (Node <E> localRoot, E item) {
	   if (localRoot == null) {
		   addReturn = true;
		   return new Node<E> (item);
       }

       int compareResult = item.compareTo(localRoot.data);
       if (compareResult == 0) {
		   // item is already in the tree.
		   addReturn = false;
		   return localRoot;
       }

       if (compareResult < 0) {
		   // item has to go in the left subtree of localRoot
		   localRoot.left = add(localRoot.left, item);
		   return localRoot;
       }

       else {
		    // item has to go in the left subtree of localRoot
		    localRoot.right = add(localRoot.right, item);
		    return localRoot;
       }
   }

   /** @return the minimum element in the Set */
   public E first() {
      return smallest(root);
   }
   
   private E smallest(Node<E> parent) {
	   
	   if (parent.left == null) {
		   E returnValue = parent.data;
		   return returnValue;
	   }
	   else {
		   return smallest(parent.left);
	   }
   }

   /** @return the maximum element in the Set */

   public E last() {
      	return largest(root);
   }
   
   private E largest(Node<E> parent) {
	   // If the right child has no right child, it is
	   // the inorder predecessor
	   if (parent.right.right == null) {
		   E returnValue = parent.right.data;
		   parent.right = parent.right.left;
		   return returnValue;
	   }
		   else {
			   return largest(parent.right);
		   }
	   
   }
}

