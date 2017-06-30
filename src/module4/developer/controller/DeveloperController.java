package module4.developer.controller;

import module4.developer.dao.DeveloperDAO;
import module4.developer.model.Developer;

import java.util.Collection;

public class DeveloperController {

    private DeveloperDAO developerDAO = new DeveloperDAO();

    public Developer getDeveloperByID(long id) {
        return developerDAO.getDeveloperByID(id);
    }

    public Collection<Developer> getAllDevelopers() {
        return developerDAO.getAllDevelopers();
    }

    public boolean saveDeveloper(String stringRepresentationOfDeveloper) {
        String[] developerData = stringRepresentationOfDeveloper.split(",");
        for (int i = 0; i < developerData.length; i++) {
            developerData[i] = developerData[i].trim();
        }
        try {
            long id = Long.valueOf(developerData[0]);
            String firstName = developerData[1];
            String lastName = developerData[2];
            String specialty = developerData[3];
            int experience = Integer.valueOf(developerData[4]);
            double salary = Double.valueOf(developerData[5]);
            Developer developer = new Developer(id, firstName, lastName, specialty, experience, salary);
            return developerDAO.saveDeveloper(developer);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    public boolean removeDeveloperByID(long id) {
        return developerDAO.removeDeveloperByID(id);
    }

    public boolean removeAllDevelopers() {
        return developerDAO.removeAllDevelopers();
    }
}
