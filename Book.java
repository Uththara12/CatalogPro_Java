public class Book {
    private String title;
    private String isbn;
    private boolean isEbook;
    private int yearPublished;
    private Author[] authors;

    public Book(String title, String isbn, boolean isEbook, int yearPublished, Author[] authors) {
        this.title = title;
        this.isbn = isbn;
        this.isEbook = isEbook;
        this.yearPublished = yearPublished;
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isEbook() {
        return isEbook;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public Author[] getAuthors() {
        return authors;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Title: ").append(title).append("\n");
        sb.append("Published: ").append(yearPublished).append("\n");
        sb.append("ISBN: ").append(isbn).append("\n");
        sb.append("eBook: ").append(isEbook ? "Yes" : "No").append("\n");
        sb.append("Edition: ").append("1").append("\n"); // Assuming a static edition for simplicity
        for (Author author : authors) {
            if (author != null) {
                sb.append("Author:\n").append(author.toString()).append("\n");
            }
        }
        return sb.toString();
    }
}


