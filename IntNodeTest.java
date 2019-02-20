// Saul Armendariz
// February 11, 2019
// IntNodeTest.java

public class IntNodeTest{
   
   public static void main(String[] args){
      
      // Testing 2, 4 & 5   
      IntNode List1 = new IntNode();
      System.out.println(List1.getData());
      System.out.println(List1.getLink());
      
      // Testing 6 & 7
      List1.setData(56);
      System.out.println("Data is: " + List1.getData());
      List1.setLink(null);
      System.out.println("Link is: " + List1.getLink());
      
      // Testing 3, 6 & 7
      IntNode List2 = new IntNode(2, null);
      System.out.println(List2);
      // Sets a new node after initialized value of 2
      // Should be 2 then 56 from List1
      List2.setLink(List1);
      System.out.println(List2);
      
      // Testing 8, 9 & 10
      // Will add 4 then 6 then 88
      // Should be 2 then 88 6 4 then 56
      List2.addNodeAfterThis(4);
      List2.addNodeAfterThis(6);
      List2.addNodeAfterThis(88);
      System.out.println("List length is: " + List2.listLength(List2));
      System.out.println(List2);
      
      // Testing 12
      // Will remove node after the 2nd Node
      List2.getLink().removeNodeAfterThis();
      System.out.println("List2 without 3rd node: " + List2);
      // Will readd the removed value
      List2.getLink().addNodeAfterThis(6);
      System.out.println("List2 now has 6 in it again: " + List2);
      // Will remove node after the first node
      List2.removeNodeAfterThis();
      System.out.println("List2 without 2nd node: " + List2);
      // Will give out special case message for tail
      List2.getLink().getLink().getLink().removeNodeAfterThis();
      
      // Testing 11
      // Will start at the first node then search through list
      // There is no 88 so will return false
      System.out.println("\n\n" + List2.search(List2, 88));
      // There is a 6 so will return true
      System.out.println(List2.search(List2, 6));
      // Head is tail so it will return false
      System.out.println(List2.search(List2.getLink().getLink(), 6));
      // Head holds the value, so it should return true
      System.out.println(List2.search(List2, 2));
   
   } // end of main

} // end of IntNodeTest class