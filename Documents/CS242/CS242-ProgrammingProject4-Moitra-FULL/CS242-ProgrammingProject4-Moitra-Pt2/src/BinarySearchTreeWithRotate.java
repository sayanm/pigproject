public class BinarySearchTreeWithRotate<E extends Comparable<E>>
    extends BinarySearchTree<E> {
    // Methods
    /**
      Method to perform right rotation
      pre:  root is the root of a binary search tree
      post: root.right is the root of a binary search tree
         root.right.right is raised one level,
         root.right.left does not change levels,
         root.left is lowered one level,
         the new root is returned
       @param localRoot
          The root of the binary tree to be rotated
       @return
          The new root of the rotated tree
     */
     protected Node <E> rotateRight(Node <E> localRoot) {
		 Node<E> temp = localRoot.left;
		 localRoot.left = temp.right;
		 temp.right = localRoot;
		 return temp;
     }

    /**
     * Method to perform left rotation
     * 
     * pre: root is root of the binary search tree
     * post: root.left is the root of the binary search tree
     * 	root.left.left is raised one level
     * 	root.left.right does not change levels
     * 	root.right is lowered one level
     * 	the new root is returned
     * @param localRoot
     * @return
     * 	the new root of the rotate tree
     */
     protected Node <E> rotateLeft(Node <E> localRoot) {
	 		 Node<E> temp = localRoot.right;
	 		 localRoot.right = temp.left;
	 		 temp.left = localRoot;
	 		 return temp;
     }
}


