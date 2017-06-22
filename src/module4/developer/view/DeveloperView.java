package module4.developer.view;

import module4.developer.controller.DeveloperController;
import module4.developer.model.Developer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;

public class DeveloperView {

    private DeveloperController developerController = new DeveloperController();

    private long insertID(BufferedReader reader) throws IOException {
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

    private String insertDeveloper(BufferedReader reader) throws IOException {
        System.out.println("Pleas, insert Developer data:");
        return reader.readLine();
    }

    private void getDeveloperByID(long id) {
        Developer developer = developerController.getDeveloperByID(id);
        if (developer != null) {
            System.out.println(developer);
        } else {
            System.out.println("Developer whit id:" + id + " isn't in DB!");
        }
    }

    private void getAllDevelopers() {
        Collection<Developer> developers = developerController.getAllDevelopers();
        if (developers.isEmpty()) {
            System.out.println("DB is empty");
        } else {
            for (Developer developer : developers) {
                System.out.println(developer);
            }
        }
    }

    private void saveDeveloper(String stringRepresentationOfDeveloper) {
        if (developerController.saveDeveloper(stringRepresentationOfDeveloper)) {
            System.out.println("Developer was saved/corrected in DB");
        } else {
            System.out.println("Can not save/correct DB!!!");
        }
    }

    private void removeDeveloperByID(long id) {
        if (developerController.removeDeveloperByID(id)) {
            System.out.println("Developer whit ID:" + id + " was removed from DB!");
        } else {
            System.out.println("Developer whit ID:" + id + " isn't in DB!");
        }
    }

    private void removeAllDevelopers() {
        if (developerController.removeAllDevelopers()) {
            System.out.println("All developers were deleted from DB!!!");
        } else {
            System.out.println("Can not deleted developers!!!");
        }
    }

    private void showMainMenu() {
        System.out.println("\n1 - get Developer by ID;");
        System.out.println("2 - get all Developers;");
        System.out.println("3 - create/correct(if ID exist) Developer;");
        System.out.println("4 - remove Developer by ID;");
        System.out.println("5 - remove all Developers;");
        System.out.println("exit - to exit.");
        System.out.println("Please, make your choice ");
    }

    public void running() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            showMainMenu();
            String request;
            while (!(request = reader.readLine()).equals("exit")) {
                switch (request) {
                    case "1":
                        getDeveloperByID(insertID(reader));
                        break;
                    case "2":
                        getAllDevelopers();
                        break;
                    case "3":
                        saveDeveloper(insertDeveloper(reader));
                        break;
                    case "4":
                        removeDeveloperByID(insertID(reader));
                        break;
                    case "5":
                        removeAllDevelopers();
                        break;
                    default:
                        break;
                }
                showMainMenu();
            }
        } catch (IOException ignored) {
        }
    }
}
