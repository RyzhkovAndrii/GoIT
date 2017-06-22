package module4.developer;

import module4.developer.view.DeveloperView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DeveloperApp {

    private static long insertID(BufferedReader reader) throws IOException {
        System.out.print("Please, insert ID: ");
        while (true) {
            String stringID = reader.readLine();
            try {
                return Long.valueOf(stringID);
            } catch (NumberFormatException e) {
                System.out.print("Incorrect input, try again: ");
            }
        }
    }

    private static String insertDeveloper(BufferedReader reader) throws IOException {
        System.out.println("Pleas, insert Developer data:");
        return reader.readLine();
    }

    public static void main(String[] args) {
        DeveloperView developerView = new DeveloperView();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String request;
            while (true) {
                developerView.showMainMenu();
                request = reader.readLine();
                switch (request) {
                    case "1":
                        developerView.getDeveloperByID(insertID(reader));
                        break;
                    case "2":
                        developerView.getAllDevelopers();
                        break;
                    case "3":
                        developerView.saveDeveloper(insertDeveloper(reader));
                        break;
                    case "4":
                        developerView.removeDeveloperByID(insertID(reader));
                        break;
                    case "5":
                        developerView.removeAllDevelopers();
                        break;
                    case "exit":
                        System.exit(0);
                    default:
                        break;
                }
            }
        } catch (IOException ignored) {
        }
    }

}
