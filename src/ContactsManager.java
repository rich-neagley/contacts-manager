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
      //  Path contactRecords = Paths.get("src/", "contacts.txt");
        do {
            int choice = mainMenu();

            if (choice == 1) {
                displayContact();
            } else if (choice == 2) {
              addContact();
            }
            else if (choice == 3){
                displayContact();
                System.out.println("Enter a name to search by:");
                sc.nextLine();
                String searchName = sc.nextLine();

                try {
                    List<String> allContacts = Files.readAllLines(contactRecords);
                    for (String contact: allContacts) {

                        if (contact.startsWith(searchName)) {
                            System.out.println(contact);
                        }
                        else System.out.println("No one by that name.");
                        break;
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            else if (choice == 4) {

                removeContact();

            } else if (choice == 5) {
                break;
            }
        } while (true);

    }






    public static void displayContact(){
        System.out.println("Name    |   Phone\n----------------------");
        try {
            List<String> allContacts = Files.readAllLines(contactRecords);
            for (String contact: allContacts) {
                int indexDash = contact.indexOf("-");
                String phoneNum = contact.substring(indexDash +1);
                System.out.println(phoneNum.length());
                if (phoneNum.length() == 10) {
                    System.out.println(contact.substring(0, indexDash) + " | (" + phoneNum.substring(0, 3) + ")" + phoneNum.substring(3, 6) + "-" + phoneNum.substring(6));
                }
                else if (phoneNum.length() == 7) {
                    System.out.println(contact.substring(0, indexDash) + " | " + phoneNum.substring(0, 3) + "-" + phoneNum.substring(3));
                }


            }
            System.out.println("----------------------\n");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static int mainMenu(){
        System.out.println("1. View contacts");
        System.out.println("2. Add a new contact");
        System.out.println("3. Search a contact by name");
        System.out.println("4. Delete an existing contact");
        System.out.println("5. Exit");
        System.out.println("Enter an option (1, 2, 3, 4 or 5):");
        Integer choice = sc.nextInt();
        return choice;
    }

    public static void addContact(){
        System.out.println("Please add the name of the contact.");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.println("Please add the phone number for the contact.");
        String phoneNum = sc.nextLine();
        String contactName = name;
        List<String> testList = Arrays.asList(contactName + "-" + phoneNum);

        try {
            Files.write(Paths.get("src/", "contacts.txt"), testList, StandardOpenOption.APPEND);
        } catch (Exception e) {
            System.out.println("error");
        }

    }

    public static void removeContact(){


        System.out.println("What is the name of the contact you would like to delete?");
        sc.nextLine();
        String deleteChoice = sc.nextLine();
        System.out.println(deleteChoice);

        List<String> contactsAfterDeleted = new ArrayList<>();

        try {
            List<String> allContacts = Files.readAllLines(contactRecords);
            for (String contact: allContacts) {

                int indexDash = contact.indexOf("-");
                if (contact.substring(0, indexDash).equalsIgnoreCase(deleteChoice)) {
                    continue;
                }

                contactsAfterDeleted.add(contact);
                Files.write(Paths.get("src/", "contacts.txt"), contactsAfterDeleted);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        displayContact();


    }


    public static void searchContact(){


    }

}
