public class ContactsManager {


    public static void main(String[] args) {
        do {
            int choice = MainMenu.mainMenu();
            if (choice == 1) {
                DisplayContact.displayContact();
            } else if (choice == 2) {
              AddContact.addContact();

            } else if (choice == 3){
                SearchContact.searchContact();
            } else if (choice == 4) {
                RemoveContact.removeContact();

            } else if (choice == 5) {
                break;
            }
        } while (true);
    }












}
