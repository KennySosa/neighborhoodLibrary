package com.pluralsight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Book list (my personal "need to read/already read")
        Book[] books = {
                new Book(1, "978-1", "One Piece: Water 7 Saga - Eiichiro Oda"),
                new Book(2, "978-2", "The Lord of the Rings - J.R.R. Tolkien"),
                new Book(3, "978-3", "Mob Psycho 100 - ONE"),
                new Book(4, "978-4", "Dragon Ball Z: Buu Saga - Akira Toriyama"),
                new Book(5, "978-5", "Bleach - Tite Kubo"),
                new Book(6, "978-6", "Soul Eater - Atsushi Ohkubo"),
                new Book(7, "978-7", "Red Rising - Pierce Brown"),
                new Book(8, "978-8", "Daughter of Crows - Mark Lawrence"),
                new Book(9, "978-9", "A History of Central Banking and the Enslavement of ManKind - Stephen Mitford Goodson"),
                new Book(10, "978-10", "Dark Tower - Stephen King"),
                new Book(11, "978-11", "KAGURABACHI - Takeru Hokazono"),
                new Book(12, "978-12", "Invincible - Robert Kirkman"),
                new Book(13, "978-13", "Amongst the Many, Against the Few - KSL"),
                new Book(14, "978-14", "I, Medusa - Ayana Gray"),
                new Book(15, "978-15", "Infinite - Jeremy Robinson"),
                new Book(16, "978-16", "Malice - John Gwynne"),
                new Book(17, "978-17", "Notes from the Underground - Fyodor Dostoevsky"),
                new Book(18, "978-18", "The Infinite and The Divine - Robert Rath"),
                new Book(19, "978-19", "Wizard's First Rule - Terry Goodkind"),
                new Book(20, "978-20", "Artemis - Andy Weir")
        };

        boolean running = true;
        while (running) {

            System.out.println("\n=========================================");
            System.out.println("   The Good Book Neighborhood Library    ");
            System.out.println("===========================================");
            System.out.println("1: Available Books ");
            System.out.println("2: Checked Out Books ");
            System.out.println("3: Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine().trim();
            switch (choice) {

                case "1":
                    System.out.println("\n--- Available Books ---");
                    for (Book book : books) {
                        if (!book.isCheckedOut()) {
                            System.out.println("ID: " + book.getId() +
                                    " | ISBN: " + book.getIsbn() +
                                    " | Title: " + book.getTitle());
                        }
                    }

                    // Check out part
                    System.out.println("\nEnter the ID of the book to check out, or 0 to go back: ");
                    String availableInput = scanner.nextLine().trim();

                    if (!availableInput.equals("0")) {

                        try {
                            int bookId = Integer.parseInt(availableInput);

                            boolean found = false;

                            for (Book book : books) {
                                if (book.getId() == bookId && !book.isCheckedOut()) {
                                    found = true;
                                    System.out.print("Enter your name: ");
                                    String name = scanner.nextLine().trim();
                                    book.checkOut(name);
                                    System.out.println("Y \"" + book.getTitle() + "\" checked out to " + name);
                                    break;
                                }
                            }

                            // not found if book checked out already
                            if (!found) {
                                System.out.println("Book not found or already checked out.");
                            }

                        } catch (NumberFormatException e) {
                            System.out.println(" Invalid number, please enter a valid book ID.");
                        }
                    }
                    break;

                case "2":
                    // Show checked out books
                    System.out.println("\n--- Checked Out Books ---");
                    for (Book book : books) {
                        if (book.isCheckedOut()) {
                            System.out.println("ID: " + book.getId() +
                                    " | ISBN: " + book.getIsbn() +
                                    " | Title: " + book.getTitle() +
                                    " | Checked Out To: " + book.getCheckedOutTo());
                        }
                    }

                    // Check in prompt
                    System.out.println("\nC - Check in a book | X - Go back");
                    String checkedOutInput = scanner.nextLine().trim().toUpperCase();

                    if (checkedOutInput.equals("C")) {
                        System.out.print("Enter the ID of the book to check in: ");

                        try {
                            int returnId = Integer.parseInt(scanner.nextLine().trim());

                            boolean found = false;

                            for (Book book : books) {
                                if (book.getId() == returnId && book.isCheckedOut()) {
                                    found = true;
                                    book.checkIn();
                                    System.out.println("Y \"" + book.getTitle() + "\" has been checked in!");
                                    break;
                                }
                            }

                            if (!found) {
                                System.out.println(" Book not found or not checked out.");
                            }

                        } catch (NumberFormatException e) {
                            System.out.println(" Invalid number, please enter a valid book ID.");
                        }
                    } else if (checkedOutInput.equals("X")) {
                        System.out.println("Going back to home screen...");
                    }

                case "3":
                    System.out.println("\nGoodbye! Thanks for using The Good Book Neighborhood Library!");
                    running = false;
                    break;

                default:
                    System.out.println(" Invalid option, please try again.");
                    break;
            }
        }

        scanner.close();
    }
}