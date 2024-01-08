package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Scanner; // Import the Scanner class

import library.LibrarySystem;

public class MainApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LibrarySystem librarySystem = new LibrarySystem();
            createAndShowGUI(librarySystem);
        });
    }

    private static void createAndShowGUI(LibrarySystem librarySystem) {
        JFrame frame = new JFrame("Library Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        // Create components
        JLabel titleLabel = new JLabel("Welcome to Library Management System");
        JButton viewBooksButton = new JButton("View Books");
        JButton viewMembersButton = new JButton("View Members");
        JButton registerMemberButton = new JButton("Register Member"); // New button for registering members

        // Add action listeners
        viewBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle view books action
                librarySystem.viewBooks();
            }
        });

        viewMembersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle view members action
                librarySystem.viewMembers();
            }
        });

        registerMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle register member action
                registerMember(librarySystem);
            }
        });

        // Set layout
        frame.setLayout(new GridLayout(5, 1)); // Increased rows to accommodate the new button

        // Add components to the frame
        frame.add(titleLabel);
        frame.add(viewBooksButton);
        frame.add(viewMembersButton);
        frame.add(registerMemberButton); // Add the new button

        // making the frame responsive
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Get the new size of the frame
                Dimension newSize = e.getComponent().getSize();

                // Assuming you have some components to resize
                int newButtonWidth = newSize.width / 4; // Adjust as needed
                int newButtonHeight = 30; // Adjust as needed

                // Adjust the size of buttons
                viewBooksButton.setPreferredSize(new Dimension(newButtonWidth, newButtonHeight));
                viewMembersButton.setPreferredSize(new Dimension(newButtonWidth, newButtonHeight));
                registerMemberButton.setPreferredSize(new Dimension(newButtonWidth, newButtonHeight));

                // Repaint the frame
                frame.revalidate();
                frame.repaint();
            }
        });

        // Display the frame
        frame.setVisible(true);
    }

    private static void registerMember(LibrarySystem librarySystem) {
        // Use Scanner to get input from the user
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Member ID: ");
        int memberId = scanner.nextInt(); // Read integer input

        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter Member Name: ");
        String memberName = scanner.nextLine(); // Read string input

        // Call the registerMember method with the provided input
        librarySystem.registerMember(memberId, memberName);

        // Display a message to indicate successful registration
        System.out.println("Member registered successfully!");

        // Close the Scanner
        scanner.close();
    }
}
