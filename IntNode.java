// Saul Armendariz
// February 11, 2019
// Lab 3
// IntNode.java

public class IntNode{
   
   // Variable for data
   private int d;
   // Variable for link
   private IntNode link;
   
   
   
   //***********************************************************************************
   // 2 no-arguement constructor
   public IntNode(){
      d = 0;
      link = null;
   } // end of IntNode constructor
   
   
   
   //***********************************************************************************
   // 3 constructor with given values
   public IntNode(int newData, IntNode newPointer){
      d = newData;
      link = newPointer;
   } // end of IntNode with given values constructor
   
   
   
   //***********************************************************************************
   // 4 Get method to get the node value
   public int getData(){
      return d;
   } // end of getData method
   
   
   
   //***********************************************************************************
   // 5 Get method to get the node link
   public IntNode getLink(){
      return link;
   } // end of getLink method
   
   
   
   //***********************************************************************************
   // 6 Set method to set the node value
   public void setData(int newData){
      d = newData;
   } // end of setData method
   
   
   
   //***********************************************************************************
   // 7 Set method to set the node link
   public void setLink(IntNode newLink){
      link = newLink;
   } // end of setLink method
   
   
   
   //***********************************************************************************
   // 8 A method to get the number of nodes in the list starting from a given node head
   public static int listLength(IntNode head){
      int count = 0;
      IntNode cursor = head;
      
      // Will keep running until it reaches the tail
      while( cursor != null ){
         cursor = cursor.link;
         count++;
      } // end of while
      
      return count;
   } // end of listLength method
   
   
   
   //***********************************************************************************
   // 9 toString Method 
   public String toString(){
      // allData will start with first value
      String allData = Integer.toString(getData());
      IntNode cursor = link;
      
      // Will keep running until it reaches the tail
      while(cursor != null){
         allData = allData + "->" + cursor.d;
         cursor = cursor.link;
      } // end of while
      
      return allData;
   } // end of toString method
   
   
   
   //***********************************************************************************
   // 10 A method to add a node after the current node
   public void addNodeAfterThis(int nodeAdded){
      link = new IntNode(nodeAdded, link);
   } // end of addNodeAfter method
   
   
   
   //***********************************************************************************
   // 11 A method to search wheather a linked list starting w/ head contains a given value
   // Search method is going through the linked list using recursion
   public static boolean search(IntNode head, int sData){
      IntNode cursor = head;
      
      if(head == null){
         System.out.println("Head cannot be null!");
         return false;
      }
      if(head.d == sData){
         return true;
      }
      
      return search(head.link, sData);
   } // end of search method
   
   
   
   //***********************************************************************************
   // 12 A method to remove the node after the current node
   // Will ensure that the one calling isnt null
   public void removeNodeAfterThis(){
      if(link == null){
         System.out.println("Selected node is tail, there is nothing after to remove!");
      }
      else{
         link = link.link;
      }
   } // end of removeNodeAfterThis method

   
   
   
} // end of IntNode class