/** Since Java passes primitives by value and Integer is immutable
    this class is created.  This class is similar to Integer wrapper
    class provided by Java but objects of this class are mutable.
  */
public class IntObject {
   private int data;


   /** Constructor
       @param aData the value for the instance variable
     */
   public IntObject (int aData) {
      data = aData;
   }

   /** Accessor method
       @return the value of the instance variable
     */
   public int getData() {
      return data;
   }

   /** Mutator method
       @param someData the new value for the instance variable
     */
   public void setData(int someData) {
      data = someData;
   }
}