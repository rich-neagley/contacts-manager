import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ContactsManager {
    static Scanner sc = new Scanner(System.in);
   static Path contactRecords = Paths.get("src/", "contacts.txt");




    public static void main(String[] args) {
        Path contactRecords = Paths.get("src/", "contacts.txt");
        do {
            System.out.println("1. View contacts");
            System.out.println("2. Add a new contact");
            System.out.println("3. Search a contact by name");
            System.out.println("4. Delete an existing contact");
            System.out.println("5. Exit");
            System.out.println("Enter an option (1, 2, 3, 4 or 5):");
            Integer choice = sc.nextInt();

            if (choice == 1) {
                try {
                    List<String> allContacts = Files.readAllLines(contactRecords);
                    for (String contact: allContacts) {
                        System.out.println(contact);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else if (choice == 2) {
                System.out.println("Please add the name of the contact.");
                sc.nextLine();
                String name = sc.nextLine();
                System.out.println("Please add the phone number for the contact.");
                String phoneNum = sc.nextLine();
                System.out.println(phoneNum);
                String contactName = name;
                List<String> testList = Arrays.asList(contactName + "-" + phoneNum);

                try {
                   Files.write(Paths.get("src/", "contacts.txt"), testList, StandardOpenOption.APPEND);
               } catch (Exception e) {
                   System.out.println("error");
               }

            } else if (choice == 4) {
                System.out.println("What is the name of the contact you would like to delete?");
                sc.nextLine();
                String deleteChoice = sc.nextLine();
                System.out.println(deleteChoice);

                List<String> contactsAfterDeleted = new ArrayList<>();

                try {
                    List<String> allContacts = Files.readAllLines(contactRecords);
                    for (String contact: allContacts) {

                        if (contact.startsWith(deleteChoice)) {
                            continue;
                        }

                        contactsAfterDeleted.add(contact);
                        Files.write(Paths.get("src/", "contacts.txt"), contactsAfterDeleted);

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }








            } else if (choice == 5) {
                break;
            }
        } while (true);

    }

}
