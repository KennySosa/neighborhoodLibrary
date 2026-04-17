package com.pluralsight;

public class Book {

    // remember to make properties private always
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;

    public Book(int id, String isbn, String title) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = false;
        this.checkedOutTo = "";
    }


    public int getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public void checkOut(String name) {
        if (!isCheckedOut) {
            this.isCheckedOut = true;
            this.checkedOutTo = name;
        } else {
            System.out.println("Book is already checked out.");
        }
    }

    public void checkIn() {
        this.isCheckedOut = false;
        this.checkedOutTo = "";
    }
    public String toString() {
        return "ID: " + id +
                " | ISBN: " + isbn +
                " | Title: " + title +
                " | Checked Out: " + isCheckedOut +
                " | User: " + checkedOutTo;
    }
}