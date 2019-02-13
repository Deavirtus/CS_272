// Saul Armendariz
// February 03, 2019
// Lab_2
// StringSet.java

import java.util.Arrays;



/*************************************************************************************
* StringSet is a collection of strings
* @author Saul Armendariz
* @version
* February 07, 2019
**************************************************************************************
*/
public class StringSet{
   private int cap;
   private int stringNumber;
   private String[] stringSet;
   
   // 2***************************************************************************
   // No-argument constructor
   /*************************************************************************************
   * Default constructor with no pass through elements
   * Will set capacity to a defaul value of 2
   * @param - none
   * @postcondition
   * StringSet will have no elements with a capacity of 2
   **************************************************************************************
   */
   public StringSet(){
      cap = 2;
      stringSet = new String[cap];
   } // end of StringSet Constructor
   
   
   
   // 3***************************************************************************
   // Constructor with input for cap
   /*************************************************************************************
   * Will initialize StringSet with a given capacity
   * @param newCap
   * @precondition
   * Capacity given has to be a positive number
   **************************************************************************************
   */
   public StringSet(int newCap){
      if( newCap < 0){
         System.out.println("Capacity has to be a positive number!!!");
      }
      stringSet = new String[newCap];
      stringNumber = 0;
   } // end of StringSet(int NewCap) constructor
   
   
   
   // All get/set methods
   public void setCap(int newCap){
      cap = newCap;
   } // end of setCap
   
   public String callElement(int a){
      return stringSet[a];
   } // end of all get/set methods
   

   // 4***************************************************************************
   // Copy Constructor
   /*************************************************************************************
   * Copy all the elements of another StringSet into this StringSet
   * @param obj
   * @precondition
   * Parameter obj cannot be null
   **************************************************************************************
   */
   public StringSet(Object obj){
      if(obj == null){
         System.out.print("Object has a null!");
      } // end of null exception for Copy Constructor
      else if(obj instanceof StringSet) {
         StringSet newStringSet = (StringSet) obj;
         cap = newStringSet.capacity();
         stringSet = newStringSet.stringSet;
         for(int i = 0; i < cap; i++){
            stringSet[i] = newStringSet.stringSet[i]; 
         } // end of if for Copy Constructor
      } // end of else if for Copy Constructor
   }  // end of Copy Constructor
   
   
   
   // 5***************************************************************************
   // Method to return actual number of elements in array
   /*************************************************************************************
   * Accessor to give us the number of elements in StringSet that are not null
   * @param - none
   * @return
   * The return is the number of non-null elements in StringSet
   **************************************************************************************
   */
   public int size(){
      int elements = 0;
      for(int i = 0; i < cap; i++){
         if(stringSet[i] != null){
            elements++;
         }
      }
      return elements;
   } // end of size method
   
   
   
   // 6***************************************************************************
   // Method to return the capacity of the instance
   /*************************************************************************************
   * Accessor to give us the total capacity of the StringSet
   * @param - none
   * @return
   * The total capacity of the StringSet
   **************************************************************************************
   */
   public int capacity(){
      return cap;
   } // end of capacity method
   
   
   
   // 7***************************************************************************
   // Method to add a give String value to the first available space
   // Precondition, "String value should NOT be null
   /*************************************************************************************
   * Method to add another string element to StringSet
   * @param a
   * @postcondition
   * Will first use method ensureCapacity to make sure there is enough space
   * then add the element
   **************************************************************************************
   */
   public void add(String a){
      stringNumber = size();
      // if to add to next available space;
      if(stringNumber == cap){
         ensureCapacity(stringNumber * 2);
         cap = stringNumber * 2;
      }
      
      stringSet[stringNumber++] = a;
   } // end of add method
   
   
   
   // 8***************************************************************************
   // Method to check if collection contains a string being passed through
   /*************************************************************************************
   * Contains method to check if a given StringSet contains a particular string element
   * @param a
   * @postcondition
   * Will return a true if the string parameter is found within StringSet
   * or false indicating that the string element was not found
   **************************************************************************************
   */
   public boolean contains(String a){
      if( a == null){
         System.out.println("Found a null!");
         return false;
      }
      else{
         for(int i = 0; i < stringNumber; i++){
            if( a == stringSet[i]){
               return true;
            }
         }
      }
      return false;
   }
   
   
   
   // 9***************************************************************************
   // Method to remove
   /*************************************************************************************
   * Remove method, to remove a string element and move the last element in StringSet
   * to the removed element's spot
   * @param s
   * @postcondition
   * Will return true if the element was removed and false if the element was not
   **************************************************************************************
   */
   public boolean remove(String s){
      for(int i = 0; i < stringNumber ; i++){
         if( s == stringSet[i] ){
            stringNumber--;
            stringSet[i] = stringSet[stringNumber]; // Copies last element into current one
            stringSet[stringNumber] = null; // Will erase last element after it is copied
            return true;
         }
      }
      return false;
   } // end of remove method
   
   
   
   // 10***************************************************************************
   // Method to ensure there is enough space in the array's capacity
   /*************************************************************************************
   * EnsureCapacity method to make sure there is enough space in StringSet to add another
   * string element, if not the capacity of StringSet will be doubled
   * @param minCap
   * @note
   * This is a private method and will only be called by other methods inside the class,
   * ususally when adding another string element in add method or in addOrdered method.
   **************************************************************************************
   */
   private void ensureCapacity(int minCap){
      String [] temp;
      
      if(stringSet.length < minCap){
         temp = new String[minCap];
         System.arraycopy(stringSet, 0, temp, 0, stringNumber);
         stringSet = temp;
      }
   } // end of ensureCapacity method
   
   
   
   // 11***************************************************************************
   // Method which adds one string value to this string set instance in ascending order
   /*************************************************************************************
   * AddOrdered method, that will sort the StringSet before calling the add method that
   * calls the ensureCapacity method to make sure there is enough space, once added the 
   * StringSet will be sorted again from the initial element to the last non-null element
   * @param a
   * @note
   * Has a while loop to only sort out the non-null elements in the StringSet to avoid
   * having a NullPointerException thrown.
   **************************************************************************************
   */
   public void addOrdered(String a){
      Arrays.sort(stringSet);
      if( a == null){
         System.out.println("Cannot be a null!");
      } // end of null if
      else{
         add(a);
         int i = 0;
         while( stringSet[i] != null){
            i++;
         }
         Arrays.sort(stringSet, 0, i);
      } // end of else
   } // end of addOrdered method
   
   
   
   //   ***************************************************************************
   // Main method to test all my other methods___________________________
   public static void main(String[] args){
      
      // Testing 2
      // by printing out the new capacity that should be 2
      StringSet newSet = new StringSet();
      System.out.println("Capacity for default should be 2:\n" + newSet.capacity());
      
      // Testing 3
      // by printing out the new capacity with the one passed through it
      StringSet newSet2 = new StringSet(8);
      System.out.println("\nCapacity with a given value: \n" + newSet2.capacity());
      
      // Testing 5
      // by printing out the number of the size of elements in the collection
      System.out.println("\nSize of the elements of a default should be zero: \n" + newSet.size());
      
      // Testing 6
      // by printout the number of capacity for a default constructor which is 2
      System.out.println("\nUsing capacity method of a default should be 2: \n" +newSet.capacity());
      
      // Testing 7 & 10
      // Will be adding strings then calling them back
      // First two adds will add into out default cap of 2
      // Second two adds will test my ensureCapacity function
      newSet.add("Hello");
      newSet.add("World");
      System.out.println("\nCalling first element in string array: \n" + newSet.callElement(0));
      System.out.println("\nCalling second element in string array: \n" + newSet.callElement(1));
      newSet.add("I have");
      newSet.add("arrived");
      System.out.println("\nCalling first element in string array: \n" + newSet.callElement(2));
      System.out.println("\nCalling second element in string array: \n" + newSet.callElement(3));
      System.out.println("New size of my array is: \n" + newSet.size());
      
      // Testing 6
      // Will return the updated capacity from previous test 7 & 10 of 4
      System.out.println("New capacity\n" + newSet.capacity());
      // Will return user given capacity on newSet2
      System.out.println("\nCapacity for newSet2 is: \n" + newSet2.capacity());
      
      // Testing 4
      // Will copy object being passed to calling object, will be using newSet
      StringSet newSet3 = new StringSet(newSet);
      System.out.println("\nCapacity for newSet3 copied from newSet is: \n" + newSet3.capacity());
      System.out.println("\n" + newSet3.callElement(0) + " " + newSet3.callElement(1) + " " + newSet3.callElement(2) + " " + newSet3.callElement(3));
      
      // Testing 9
      // Will remove a string in the array if it matches the string being passed through
      System.out.println("\nWill remove the string 'Hahaha' from the array and then print out all string elements\n");
      System.out.println("Since array doesn't contain such string, array will remain the same.\n");
      newSet.remove("Hahaha");
      for(int i = 0; i < newSet.size(); i++){
         System.out.println(newSet.callElement(i));
      }
      // Now it will remove a string actually in the array
      System.out.println("\nWill remove the string 'Hello' from the array and then print out all string elements\n");
      newSet.remove("Hello");
      for(int i = 0; i < newSet.size(); i++){
         System.out.println(newSet.callElement(i));
      }
      
      // Testing 8
      // Will be testing several strings to see if it matches them to the collection in the object
      System.out.print("\nChecking if newSet has a string that matches 'wow': \n" + newSet.contains("wow"));
      System.out.print("\nChecking if newSet has a string that matches 'Hello': \n" + newSet.contains("Hello"));
      System.out.print("\nChecking if newSet has a string that matches 'hello': \n" + newSet.contains("hello"));
      System.out.print("Checking if newSet has a string that matches 'arrived': \n" + newSet.contains("arrived"));
      System.out.print("Checking if newSet has a string that matches 'World': \n" + newSet.contains("World"));
      
      // Testing 7, 8 & 10 together
      newSet.add("My");
      newSet.add("name");
      newSet.add("is");
      newSet.add("Slim");
      newSet.add("Shady");
      System.out.println(newSet.capacity());
      System.out.print("\nChecking if newSet has a string that matches 'My': \n" + newSet.contains("My"));
      System.out.print("\nChecking if newSet has a string that matches 'my': \n" + newSet.contains("my"));
      System.out.print("\nChecking if newSet has a string that matches 'slim shady': \n" + newSet.contains("slim shady"));
      System.out.print("Checking if newSet has a string that matches 'Slim': \n" + newSet.contains("Slim"));
      System.out.print("Checking if newSet has a string that matches 'Shady': \n" + newSet.contains("Shady"));
      
      // Testing 11
      // Will see if newSet will be sorted and then add the new string element
      newSet.addOrdered("Boo");
      System.out.println("\n");
      for(int i = 0; i < newSet.size(); i++){
         System.out.println(newSet.callElement(i));
      }
   } // end of main
   
} // end of StringSet class
