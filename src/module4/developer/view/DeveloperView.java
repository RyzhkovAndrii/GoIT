package module4.developer.view;

import module4.developer.controller.DeveloperController;
import module4.developer.model.Developer;

import java.util.Collection;

public class DeveloperView {

    private DeveloperController developerController = new DeveloperController();

    public void getDeveloperByID(long id) {
        Developer developer = developerController.getDeveloperByID(id);
        if (developer != null) {
            System.out.println(developer);
        } else {
            System.out.println("Developer whit id:" + id + " isn't in DB!");
        }
    }

    public void getAllDevelopers() {
        Collection<Developer> developers = developerController.getAllDevelopers();
        if (developers.isEmpty()) {
            System.out.println("DB is empty");
        } else {
            for (Developer developer : developers) {
                System.out.println(developer);
            }
        }
    }

    public void saveDeveloper(String stringRepresentationOfDeveloper) {
        if (developerController.saveDeveloper(stringRepresentationOfDeveloper)) {
            System.out.println("Developer was saved/corrected in DB");
        } else {
            System.out.println("Can not save/correct DB!!!");
        }
    }

    public void removeDeveloperByID(long id) {
        if (developerController.removeDeveloperByID(id)) {
            System.out.println("Developer whit ID:" + id + " was removed from DB!");
        } else {
            System.out.println("Developer whit ID:" + id + " isn't in DB!");
        }
    }

    public void removeAllDevelopers() {
        if (developerController.removeAllDevelopers()) {
            System.out.println("All developers were deleted from DB!!!");
        } else {
            System.out.println("Can not deleted developers!!!");
        }
    }

    public void showMainMenu() {
        System.out.println("\n1 - get Developer by ID;");
        System.out.println("2 - get all Developers;");
        System.out.println("3 - create/correct(if ID exist) Developer;");
        System.out.println("4 - remove Developer by ID;");
        System.out.println("5 - remove all Developers;");
        System.out.println("exit - to exit.");
        System.out.println("Please, make your choice ");
    }
}
