import java.io.*;

public class Library {
    private Book[] books;
    private int bookCount = 0;  // Track the number of books

    public Library() {
        books = new Book[100];  // Assume a max of 100 books
    }

    // Method to read books from the provided CSV file
    public void readFromFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();  // Skip the header
            while ((line = br.readLine()) != null) {
                // Skip empty lines
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split(",");

                // Check if the data array has at least 16 elements
                if (data.length < 16) {
                    System.out.println("Skipping line due to insufficient data: " + line);
                    continue;  // Skip this line if it doesn't have enough fields
                }

                String title = data[0];
                String isbn = data[14];
                boolean isEbook = Boolean.parseBoolean(data[15]);
                int yearPublished = Integer.parseInt(data[13]);

                // Creating an array of authors
                Author[] authors = new Author[3];
                for (int i = 0; i < 3; i++) {
                    int offset = 1 + i * 4;  // Offset to fetch each author data
                    if (offset < data.length && !data[offset].isEmpty()) {
                        String familyName = data[offset];
                        String firstName = data[offset + 1];
                        String nationality = data[offset + 2];
                        int birthYear = Integer.parseInt(data[offset + 3]);
                        authors[i] = new Author(familyName + " " + firstName, nationality, birthYear);
                    }
                }

                // Add the book to the array
                books[bookCount++] = new Book(title, isbn, isEbook, yearPublished, authors);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to write updated book data to the CSV file
    public void writeToFile(String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            // Writing the header row
            bw.write("title,familyNameOne,firstNameOne,nationalityOne,birthYearOne,familyNameTwo,firstNameTwo,nationalityTwo,birthYearTwo,familyNameThree,firstNameThree,nationalityThree,birthYearThree,year,isbn,ebook,edition");
            bw.newLine();

            // Writing each book's data
            for (int i = 0; i < bookCount; i++) {
                Book book = books[i];
                bw.write(book.getTitle() + "," + book.getIsbn() + "," + book.isEbook() + "," + book.getYearPublished());
                for (Author author : book.getAuthors()) {
                    if (author != null) {
                        bw.write("," + author.getName() + "," + author.getNationality() + "," + author.getYearOfBirth());
                    }
                }
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to get the number of books
    public int getBookCount() {
        return bookCount;  // Return the number of books loaded
    }

    // Method to get a specific book
    public Book getBook(int index) {
        if (index >= 0 && index < bookCount) {
            return books[index];  // Return the book at the given index
        }
        return null;  // Return null if index is out of bounds
    }
}


