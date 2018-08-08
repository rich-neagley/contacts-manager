import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RemoveContact {
    public static void removeContact(){
        Scanner sc = new Scanner(System.in);
        Path contactRecords = Paths.get("src/", "contacts.txt");


        System.out.println("What is the name of the contact you would like to delete?");
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
        DisplayContact.displayContact();


    }


}
