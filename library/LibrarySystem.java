package library;

import java.util.ArrayList;
import java.util.List;

public class LibrarySystem {
    private List<Book> books;
    private List<Member> members;
    private List<Transaction> transactions;

    public LibrarySystem() {
        // Initialize your lists or perform other setup tasks here
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    public void viewMembers() {
        // Implement the logic to display members
        for (Member member : members) {
            System.out.println("Member ID: " + member.getId());
            System.out.println("Member Name: " + member.getName());
            // Add more member details as needed
            System.out.println("--------------");
        }
    }

    public void viewBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    // Method to register a new member
    public void registerMember(int memberId, String memberName) {
        // Create a new Member instance and add it to the members list
        Member newMember = new Member(memberId, memberName);
        members.add(newMember);
        System.out.println("Member registered successfully.");
    }
}
