import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AddContact {

    public static void addContact(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please add the name of the contact.");
        String name = sc.nextLine();
        System.out.println("Please add the phone number for the contact.");
        String phoneNum = sc.nextLine();
        String contactName = name;
        List<String> testList = new ArrayList<>();
        testList.add(contactName + "-" + phoneNum);

        try {
            Files.write(Paths.get("src/", "contacts.txt"), testList, StandardOpenOption.APPEND);
        } catch (Exception e) {
            System.out.println("error");
        }
    }
}
