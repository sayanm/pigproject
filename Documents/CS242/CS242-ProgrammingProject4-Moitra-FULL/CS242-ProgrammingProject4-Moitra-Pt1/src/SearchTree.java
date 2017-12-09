public interface SearchTree <E> {
   /** inserts item where it belongs in the tree;
       Returns true if item is inserted; false if the
       item is not inserted (it is already in the tree)
     */
   public boolean add(E item);

   /** Returns a reference to the data in the node
       that is equal to target.  If no such node is
       found, returns null. count holds the number of
       comparisons done for this search
     */
   public E find (E target, IntObject count);

} // end SearchTreeInterface
