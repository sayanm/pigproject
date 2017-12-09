import java.io.*;
import java.util.*;

// Author: Aparna Mahadev
// Course Name: CS 242 Data Structures
// Semester: Fall 2015
// Project #4
// E-mail: amahadev@worcester.edu
// Description:
//    In this assignment we implement the AVL Tree which is an
//    implementation of the Search Tree ADT.
//    An input file of Books has been provided by the instructor.
//    The program first inserts all these Book objects into an empty BST.
//
//    A file of 80 keys is given by the instructor to perform searches on the
//    AVL tree.  For each search, if the key is found in the tree, the program
//    reports the # of comparisons made for this search.
//
//    If the key is not found, the program reports that the key is not found
//    along with the # of comparisons made for the search.
//
//    The program reports the height of the tree along with the
//    average # of comparisons made for a successful and for an unsuccessful
//    search and the number of nodes in the tree.
//
//    Known Bugs: None
//    Time Estimate: I spent close to 8 hours from start to finish to complete
//    this assignment.

public class AVLDriver {
    public static void main (String args[]) {
       String line;
       BinarySearchTree <Book> avl = new AVLTree <Book> ();
       int unsuccessfulComparisons = 0;
       int successfulComparisons = 0;
       int unsuccessfulSearches = 0;
       int successfulSearches = 0;
       IntObject searchCount = new IntObject(0);

       try {
		   Scanner inFile = new Scanner (new FileInputStream("Books.txt"), "ISO-8859-1");

           Scanner testFile = new Scanner(new FileInputStream("TestISBN.txt"));

           PrintWriter out = new PrintWriter(new FileWriter("AVLOutput.txt"));

           while (inFile.hasNextLine())  {
               line = inFile.nextLine();
               Book aBook = new Book(line.substring(0,10),
                  line.substring(15,55).trim(),
                  line.substring(55,95).trim(),
                  Integer.parseInt(line.substring(95,99)),
                  line.substring(104,line.length()));
                  avl.add(aBook);
            }
            inFile.close();
            out.println("All the " + avl.size() + " elements have been successfully " +
                             "inserted into the BST");
            out.println();
            out.println("The height of the tree is " + avl.height() );
            out.println();

            out.println("The minimum element in the tree is: ");
            out.println(avl.first() );

            out.println("\nThe maximum element in the tree is: ");
            out.println(avl.last() );
            out.println();
            out.println();

            // now start searching the AVL tree
            while (testFile.hasNextLine()) {
                line = testFile.nextLine();
                Book aBook = new Book();
                aBook.setIsbn(line);
                searchCount.setData(0);
                Book result = avl.find(aBook, searchCount);
                if (result != null) {
                   out.println("Sucessful Search!!!");
                   out.println(result);
                   out.println("The number of comparisons made for " +
                                 "this succeesful search is " +
                                  searchCount.getData() );
                   out.println();
                   out.println();
                   successfulComparisons += searchCount.getData();
                   successfulSearches++;
                }
                else { // key is not found in the AVL Tree
                    out.println("There is no book with ISBN " + aBook.getIsbn());
                    out.println("The number of comparisons made for " +
                            "this unsucceesful search is " +
                             searchCount.getData() );
                    out.println();

                    unsuccessfulComparisons += searchCount.getData();
                    unsuccessfulSearches++;
                }  // else
            }  // while

             out.println("There were " + successfulSearches +
                           " successful searches");
            if (successfulSearches > 0)
                 out.format("The average number of comparisons for a " +
                        "successful search is %.2f%n",
                        (double)successfulComparisons / successfulSearches);
            out.println();

            out.println("There were " + unsuccessfulSearches +
                             " unsuccessful searches");
            if (unsuccessfulSearches > 0)
              out.format("The average number of comparisons for " +
                     "an unsuccessful search is %.2f%n",
                     (double)unsuccessfulComparisons / unsuccessfulSearches);
			inFile.close();
            testFile.close();
            out.close();
	   }  // try
	   catch (IOException e) {
		   System.out.println("Input file or the test file cannot be opened");
		   System.exit(0);
       }
    }  // main method
}

