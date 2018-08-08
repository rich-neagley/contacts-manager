import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class WindowFrame {
    static Container con;
    static JFrame window;
    static JPanel titleNamePanel, buttonPanel, contactListPanel;
    static JTextArea contactListing;
    static JLabel titleNameLabel, buttonLabel;
    static JButton button1, button2, button3, button4;
    static Font titleFont = new Font("AppleGothic", Font.BOLD, 70);
    static Font normalFont = new Font("Times New Roman", Font.PLAIN, 22);





    static ChoiceHandler choiceHandler = new ChoiceHandler();

    static String choice;
    static Path contactRecords = Paths.get("src/", "contacts.txt");



    public static void main(String[] args) {


        window = new JFrame();
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        con = window.getContentPane();

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100,0,600,100);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("Contacts Manager");
        titleNameLabel.setForeground(Color.CYAN);
        titleNameLabel.setFont(titleFont);
        titleNamePanel.add(titleNameLabel);
        con.add(titleNamePanel);

        buttonPanel = new JPanel();
        buttonPanel.setBounds(100, 400, 600, 100);
        buttonPanel.setBackground(Color.black);
        buttonPanel.setLayout(new GridLayout(5, 1));
        buttonLabel = new JLabel("Please make a selection:");
        buttonLabel.setForeground(Color.green);
        buttonPanel.add(buttonLabel);
        con.add(buttonPanel);

        contactListPanel = new JPanel();
        contactListPanel.setBounds(100, 100, 600, 300);
        contactListPanel.setBackground(Color.red);
        con.add(contactListPanel);





        contactListing = new JTextArea("Contact List:");
        contactListing.setBounds(100, 100, 600, 300);
        contactListing.setEditable(false);
        contactListing.setBackground(Color.red);
        contactListing.setForeground(Color.white);
        contactListing.setFont(normalFont);
        contactListPanel.add(contactListing);


        button1 = new JButton("View all contacts");
        button1.setForeground(Color.black);
        button1.setFont(normalFont);
        button1.addActionListener(choiceHandler);
        button1.setActionCommand("button1");
        buttonPanel.add(button1);

        button2 = new JButton("Add a contact");
        button2.setForeground(Color.black);
        button2.setFont(normalFont);
        button2.addActionListener(choiceHandler);
        button2.setActionCommand("button2");
        buttonPanel.add(button2);

        button3 = new JButton("Search for a contact");
        button3.setForeground(Color.black);
        button3.setFont(normalFont);
        button3.addActionListener(choiceHandler);
        button3.setActionCommand("button3");
        buttonPanel.add(button3);

        button4 = new JButton("Remove a contact");
        button4.setForeground(Color.black);
        button4.setFont(normalFont);
        button4.addActionListener(choiceHandler);
        button4.setActionCommand("button4");
        buttonPanel.add(button4);

        window.setVisible(true);
    }

    public static class ChoiceHandler implements ActionListener {
        public void actionPerformed(ActionEvent event){
            choice = event.getActionCommand();

            switch (choice){
                case "button1":
                    displayContactsList();

                    break;
                case "button2":
                    try {
                        String name = JOptionPane.showInputDialog("Enter in the name of the contact");
                        String number = JOptionPane.showInputDialog("Enter in contacts number");
                        List<String> newContact = new ArrayList<>();
                        newContact.add(name + "-" + number);
                        if (name == null){

                        }
                        else {
                            Files.write(contactRecords, newContact, StandardOpenOption.APPEND);
                            displayContactsList();
                        }
                        break;


                    } catch (Exception e) {
                        System.out.println("error");
                        break;
                    }
                case "button3":
                    try {
                        String searchName = JOptionPane.showInputDialog("Enter the name you want to search");
                        List<String> allContacts = Files.readAllLines(contactRecords);
                        List<String> matchingContacts = new ArrayList<>();
                        for (String contact: allContacts) {

                            if (contact.toLowerCase().startsWith(searchName)) {
                                matchingContacts.add(contact);
                            }
                        }
                        if (matchingContacts.isEmpty()) {
                            contactListing.setText("No matches in our system");
                        } else {
                            contactListing.setText("");
                            for (String contact: matchingContacts) {
                                contactListing.append(contact + "\n");

                            }
                        }
                        break;
                    } catch (NullPointerException e) {
                        break;

                    } catch (Exception e) {
                        break;
                    }

                case "button4":

                    List<String> contactsAfterDeleted = new ArrayList<>();
                    String deleteChoice = JOptionPane.showInputDialog("Please enter the name you would likē to delete");
                    try {
                        List<String> eachContact = Files.readAllLines(contactRecords);
                        for (String contact: eachContact) {
                            if (!contact.contains(deleteChoice)) {
                                contactListing.setText("No matches found");
                            } else {
                                try {
                                    List<String> allContacts = Files.readAllLines(contactRecords);
                                    for (String contactN: allContacts) {

                                        int indexDash = contactN.indexOf("-");
                                        contactListing.setText("");
                                        if (contactN.substring(0, indexDash).equalsIgnoreCase(deleteChoice)) {
                                            continue;
                                        }
                                        contactsAfterDeleted.add(contactN);
                                    }
                                    Files.write(Paths.get("src/", "contacts.txt"), contactsAfterDeleted);
                                    displayContactsList();
                                    break;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    } catch (NullPointerException e) {
                        break;
                    } catch (Exception e){
                        break;
                    }

            }
        }
    }

    public static void displayContactsList() {
        try {
            List<String> allContacts = Files.readAllLines(contactRecords);
            contactListing.setText("");
            for (String contact: allContacts) {
                int indexDash = contact.indexOf("-");
                String phoneNum = contact.substring(indexDash +1);

                if (phoneNum.length() == 10) {
                    contactListing.append(contact.substring(0, indexDash) +"   (" + phoneNum.substring(0, 3) + ")" + phoneNum.substring(3, 6) + "-" + phoneNum.substring(6) + "\n");
                }
                else if (phoneNum.length() == 7) {
                    contactListing.append(contact.substring(0, indexDash) +"    "+ phoneNum.substring(0, 3) + "-" + phoneNum.substring(3) + "\n" );
                } else {
                    contactListing.append(contact.substring(0, indexDash)+"    "+ phoneNum + "\n");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
