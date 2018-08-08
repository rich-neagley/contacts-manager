import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchContact {
    public static void searchContact(){
        Path contactRecords = Paths.get("src/", "contacts.txt");
        Scanner sc = new Scanner(System.in);
        DisplayContact.displayContact();
        System.out.println("Enter a name to search by:");
        String searchName = sc.nextLine().toLowerCase();

        try {
            List<String> allContacts = Files.readAllLines(contactRecords);
            List<String> matchingContacts = new ArrayList<>();
            for (String contact: allContacts) {

                if (contact.toLowerCase().startsWith(searchName)) {
                    matchingContacts.add(contact);
                }
            }
            if (matchingContacts.isEmpty()) {
                System.out.println("No matching contacts");
            } else {
                for (String contact: matchingContacts) {
                    System.out.println(contact);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
