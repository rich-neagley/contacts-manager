import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class DisplayContact {
    public static void displayContact(){
        Path contactRecords = Paths.get("src/", "contacts.txt");
        System.out.println("Name    |   Phone\n----------------------");
        try {
            List<String> allContacts = Files.readAllLines(contactRecords);
            for (String contact: allContacts) {
                int indexDash = contact.indexOf("-");
                String phoneNum = contact.substring(indexDash +1);
                if (phoneNum.length() == 10) {
                    System.out.println(contact.substring(0, indexDash) + " | (" + phoneNum.substring(0, 3) + ")" + phoneNum.substring(3, 6) + "-" + phoneNum.substring(6));
                }
                else if (phoneNum.length() == 7) {
                    System.out.println(contact.substring(0, indexDash) + " | " + phoneNum.substring(0, 3) + "-" + phoneNum.substring(3));
                } else {
                    System.out.println(contact.substring(0, indexDash) + " | " + phoneNum);
                }


            }
            System.out.println("----------------------\n");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
