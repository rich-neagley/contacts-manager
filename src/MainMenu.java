import java.util.Scanner;

public class MainMenu {
    public static int mainMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("1. View contacts");
        System.out.println("2. Add a new contact");
        System.out.println("3. Search a contact by name");
        System.out.println("4. Delete an existing contact");
        System.out.println("5. Exit");
        System.out.println("Enter an option (1, 2, 3, 4 or 5):");
        Integer choice = sc.nextInt();
        System.out.println(choice);
        return choice;
    }
}
