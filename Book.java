// Written by Saul Armendariz
// January 28, 2019
// Lab 1
// Book.java


public class Book{

   // variables for the class Book
   private String bookTitle = "";
   private int authorNumber;
   private String[] authorNames;
   private String ISBN = "";
   
   
   
   // 1 ***********************************************************
   // Default constructor that will initialize variables to default values
   public Book(){
      bookTitle = null;
      authorNumber = 0;
      authorNames = new String[3];
      ISBN = null;
   } // end of default constructor
   
   
   
   // 2 ***********************************************************
   // Constructor to get book title
   public Book(String title){
      bookTitle = title;
      authorNumber = 0;
      authorNames = new String[3];
      ISBN = null;
   } // end of constructor with bookTitle initialized
   
   
   
   // 3 ***********************************************************
   // Copy Constructor
   public Book(Object obj){
      authorNames = new String[3];
      if(obj == null){
         System.out.println("NULL DETECTED!");
      }
      else if(obj instanceof Book) {
         Book newBook = (Book) obj;
         bookTitle = newBook.bookTitle;
         authorNumber = newBook.authorNumber;
         for(int i = 0; i < authorNames.length; i++){
            authorNames[i] = newBook.authorNames[i];
         }
         ISBN = newBook.ISBN;
      } // end of else if
   }// end of Copy Constructor
   
   
   
   // 4 ***********************************************************
   // Accessor for bookTitle
   public String getTitle(){
      return(bookTitle);
   } // end of accessor for bookTitle
   
   
   
   // 5 ***********************************************************
   // Accessor for authors
   public int getAuthorNumber(){
      return(authorNumber);
   } // end of getAuthorNumber
   
   
   
   // 6 ***********************************************************
   // Accessor for ISBN
   public String getISBN(){
      return(ISBN);
   } // end of getISBN
   
   
   
   // 7 ***********************************************************
   // Mutator for bookTitle
   public void setTitle(String newTitle){
      bookTitle = newTitle;
   } // end of setTitle
   
   
   
   // 8 ***********************************************************
   // Mutator for ISBN
   public void setISBN(String newISBN){
      ISBN = newISBN;
   } // end of setISBN
   
   
   
   // 9 
   // Method to add an author
   // Will check to see if there is room and return true
   // If no space available then no author will be added
   public boolean addAuthor(String newAuthor){
      if(authorNumber == 3){
         System.out.println("No more room for author names!");
         return false;
      } // end of if
      else{
         authorNames[authorNumber] = newAuthor;
         authorNumber++;
         } // end of else
      return true;
   } // end of addAuthor
   
   
   
   // 10 ***********************************************************
   // equals method
   // This method will see if the calling object has the same ISBN as the one it calls to compare
   public boolean equals(Object obj){
      if(this == obj){
         return true;
      }
      if(obj == null){
         System.out.println("NULL DETECTED!");
         return false;
      }
      // Will check if the ISBN is the same as the calling objects
      else if(obj instanceof Book) {
         Book newBook = (Book) obj;
         if(newBook.getISBN().equals(ISBN)){
            return true;
         }
      }
      return false;
   } // end of equals method
   
   
   
   // 11 ***********************************************************
   public static String[] getAllAuthors(Book b1, Book b2){
      int length = 0;
      int b1Length = b1.authorNames.length;
      int b2Length = b2.authorNames.length;
      int totalLength = b1Length + b2Length;
         
      for(int a = 0; a < b2Length; a++){
         if(b1.authorNames[0] == b2.authorNames[a])
            totalLength = totalLength - 1;
      }
      for(int a = 0; a < b2.authorNames.length; a++){
         if(b1.authorNames[1] == b2.authorNames[a])
            totalLength = totalLength - 1;
      }
      for(int a = 0; a < b2.authorNames.length; a++){
         if(b1.authorNames[2] == b2.authorNames[a])
            totalLength = totalLength - 1;
      }
      
      String authors[] = new String[totalLength];
      
      for(int i = 0; i < b1Length; i++){
         if(b1.authorNames[i] == null){
            i++;
         }
         else
            authors[i] = b1.authorNames[i];
      } // end of if for first b1
      
      for(int i = 0; i < b2Length; i++){
         if(b2.authorNames[i] == null){
            i++;
         }
         else
            authors[i + b1Length] = b2.authorNames[i];
      } // end of if for first b1
      
      return authors;
   } // end of getAllAuthors method


   
   // 12 ***********************************************************
   // toString method
   // Format will be: "bookTitle, ISBN, authorNumber, authorNames
   public String toString(){
      String firstPart = bookTitle + ", " + ISBN + ", " + authorNumber;
      String secondPart = "";
      for(int i = 0; i < authorNames.length; i++){
         secondPart = secondPart + ", " + authorNames[i];
      }
      return(firstPart + secondPart);
   } // end of toString method
   
   
   
   // 13 ***********************************************************
   // main method to test Book.java
   public static void main(String[] args){
      // Testing 1
      Book book1 = new Book();
      System.out.println("Default constructor with default values:   " + book1);
      
      // Testing 2
      Book book2 = new Book("Blade Runner");
      System.out.println("Constructor with user given book title:   " + book2);
      
      // Testing 7
      book1.setTitle("Dante's Inferno");
      System.out.println("Changed book1's title:   " + book1);
      book2.setTitle("Pan's Labyrinth");
      System.out.println("Changed book2's title:   " + book2);
      
      // Testing 8
      book1.setISBN("SE780");
      System.out.println("Changed book1's ISBN:   " + book1);
      book2.setISBN("ISBN: 48885474F");
      System.out.println("Changed book2's ISBN:   " + book2);
      
      // Testing 4
      System.out.println("Getting the new title for book1:   " + book1.getTitle());
      System.out.println("Getting the new title for book2:   " + book2.getTitle());
      
      // Testing 5
      System.out.println("Getting the number of authors for book1:   " + book1.getAuthorNumber());
      System.out.println("Getting the number of authors for book2:   " + book2.getAuthorNumber());
      
      // Testing 6
      System.out.println("Getting the new ISBN for book1:   " + book1.getISBN());
      System.out.println("Getting the new ISBN for book2:   " + book2.getISBN());
      
      // Testing 9
      book2.addAuthor("Marc McGuirre");
      book2.addAuthor("John S. Whitney");
      book2.addAuthor("Henry White");
      book2.addAuthor("Adam Stuart");
      
      // Testing 3
      Book book3 = new Book(book2);
      System.out.println("\nBoth book2 and book3 should have the same values");
      System.out.println("book2:   " + book2);
      System.out.println("book3:   " + book3);
      
      System.out.println("\nNew book created using default constructor that has null values");
      Book book4 = new Book();
      Book book5 = new Book(book4);
      
      // Testing 10
      System.out.println(book2.equals(book3));
      System.out.println(book1.equals(book2));
      
      // Testing 11
      System.out.println(getAllAuthors(book2, book3));
   
   } // end of main method


} // end of class Book