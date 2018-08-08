import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class DisplayContact {
    public static void displayContact(){
        Path contactRecords = Paths.get("src/", "contacts.txt");
        System.out.printf("%-20s %-5s %-10s",
                "Name:","|", "Phone Number:\n");
        System.out.println("----------------------------------------");
        try {
            List<String> allContacts = Files.readAllLines(contactRecords);
            for (String contact: allContacts) {
                int indexDash = contact.indexOf("-");
                String phoneNum = contact.substring(indexDash +1);
                if (phoneNum.length() == 10) {
                    System.out.printf("%-20s %-5s %s", contact.substring(0, indexDash),"|", "(" + phoneNum.substring(0, 3) + ")" + phoneNum.substring(3, 6) + "-" + phoneNum.substring(6) + "\n" );
                   // contact.substring(0, indexDash) + " | (" + phoneNum.substring(0, 3) + ")" + phoneNum.substring(3, 6) + "-" + phoneNum.substring(6)
                }
                else if (phoneNum.length() == 7) {
                    System.out.printf("%-20s %-5s %s", contact.substring(0, indexDash),"|", phoneNum.substring(0, 3) + "-" + phoneNum.substring(3) + "\n" );
                    //contact.substring(0, indexDash) + " | " + phoneNum.substring(0, 3) + "-" + phoneNum.substring(3)
                } else {
                    System.out.printf("%-20s %-5s %s", contact.substring(0, indexDash),"|", phoneNum + "\n" );
                    //contact.substring(0, indexDash) + " | " + phoneNum
                }


            }
            System.out.println("----------------------------------------\n");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
