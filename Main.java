import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();  // Correct instantiation
        Scanner scanner = new Scanner(System.in);
        String fileName = "StartingDataFile.csv";  // Ensure the correct file name

        // Load the data from the CSV file
        library.readFromFile(fileName);

        int choice = 0;
        while (choice != 7) {
            System.out.println("************************************");
            System.out.println("       Welcome to the Library       ");
            System.out.println("************************************");
            System.out.println("  1 > View all Books                ");
            System.out.println("  2 > View eBooks                   ");
            System.out.println("  3 > View non-eBooks               ");
            System.out.println("  4 > View an author's Books         ");
            System.out.println("  5 > Add Book                      ");
            System.out.println("  6 > Edit Book                     ");
            System.out.println("  7 > Exit                          ");
            System.out.println("************************************");
            System.out.print("  Your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1: // View all Books
                    System.out.println("************************************");
                    System.out.println("           All Books                ");
                    System.out.println("************************************");
                    for (int i = 0; i < library.getBookCount(); i++) {
                        System.out.println(library.getBook(i).toString());
                    }
                    break;

                case 2: // View eBooks
                    System.out.println("************************************");
                    System.out.println("           eBooks                   ");
                    System.out.println("************************************");
                    for (int i = 0; i < library.getBookCount(); i++) {
                        Book ebook = library.getBook(i);
                        if (ebook.isEbook()) {
                            System.out.println(ebook.toString());
                        }
                    }
                    break;

                case 3: // View non-eBooks
                    System.out.println("************************************");
                    System.out.println("          Non-eBooks                ");
                    System.out.println("************************************");
                    for (int i = 0; i < library.getBookCount(); i++) {
                        Book nonEbook = library.getBook(i);
                        if (!nonEbook.isEbook()) {
                            System.out.println(nonEbook.toString());
                        }
                    }
                    break;

                case 4: // View books by author
                    System.out.println("************************************");
                    System.out.println("        Books by Author             ");
                    System.out.println("************************************");
                    System.out.print("Enter Author Name: ");
                    String authorName = scanner.nextLine();
                    boolean found = false;

                    for (int i = 0; i < library.getBookCount(); i++) {
                        Book book = library.getBook(i);
                        for (Author author : book.getAuthors()) {
                            if (author != null && author.getName().contains(authorName)) {
                                System.out.println("\nBook:");
                                System.out.println(book.toString());
                                found = true;
                            }
                        }
                    }
                    if (!found) {
                        System.out.println("No books found by author: " + authorName);
                    }
                    break;

                case 5:
                    // Logic to add a book can be added here
                    System.out.println("Add Book functionality not implemented yet.");
                    break;

                case 6:
                    // Logic to edit a book can be added here
                    System.out.println("Edit Book functionality not implemented yet.");
                    break;

                case 7:
                    System.out.println("Exiting the program...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        // Save any changes to the CSV file
        library.writeToFile(fileName);
        scanner.close();
    }
}



