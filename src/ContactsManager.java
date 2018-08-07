import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ContactsManager {
    static Scanner sc = new Scanner(System.in);
    static List<> contactList = Arrays.asList();



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


            if (choice == 2) {
                System.out.println("Please add the name of the contact.");
                sc.nextLine();
                String name = sc.nextLine();
                System.out.println("Please add the phone number for the contact.");
                long phoneNum = sc.nextLong();
                System.out.println(phoneNum);
                String newcontact = name;
               // ContactConstructor newcontact = new ContactConstructor(name, phoneNum);
             //   contactList.add(newcontact);

                try {
                    Files.write(Paths.get("src/", "contacts.txt"), newcontact);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }


            if (choice == 5) {
                break;
            }
        } while (true);

    }

}
