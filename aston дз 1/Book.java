import java.util.Objects;

class Book implements Comparable<Book> {
    private String title;
    private String author;
    private int year;
    private int pages;

    public Book(String title, String author, int year, int pages) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.pages = pages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year && pages == book.pages && 
               Objects.equals(title, book.title) && 
               Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year, pages);
    }

    @Override
    public int compareTo(Book other) {
        return Integer.compare(this.pages, other.pages);
    }

    public int getYear() { return year; }
    public int getPages() { return pages; }

    @Override
    public String toString() {
        return String.format("%s (%d, %d стр.)", title, year, pages);
    }
}