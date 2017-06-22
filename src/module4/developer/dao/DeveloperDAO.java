package module4.developer.dao;

import module4.developer.model.Developer;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class DeveloperDAO {

    private final String dataPath = "D:\\GoIT\\IdeaProjects\\GoIT\\src\\module4\\developer\\developers.txt";

    private boolean collectionToFile(Collection<Developer> developers) {
        try (FileWriter fw = new FileWriter(dataPath, false)) {
            for (Developer developer : developers) {
                fw.write(developer.getId() + "," + developer.getFirstName() + "," +
                        developer.getLastName() + "," + developer.getSpecialty() + "," +
                        developer.getExperience() + "," + developer.getSalary() + System.lineSeparator());
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private Developer getDeveloperFromString(String developerDataString) {
        String[] developerData = developerDataString.split(",");
        long id = Long.valueOf(developerData[0]);
        String firstName = developerData[1];
        String lastName = developerData[2];
        String specialty = developerData[3];
        int experience = Integer.valueOf(developerData[4]);
        double salary = Double.valueOf(developerData[5]);
        return new Developer(id, firstName, lastName, specialty, experience, salary);
    }

    public Developer getDeveloperByID(long id) {
        try (BufferedReader reader = new BufferedReader(new FileReader(dataPath))) {
            String tmpDeveloperData;
            while ((tmpDeveloperData = reader.readLine()) != null) {
                if (tmpDeveloperData.split(",")[0].equals(String.valueOf(id))) {
                    return getDeveloperFromString(tmpDeveloperData);
                }
            }
        } catch (IOException e) {
            return null;
        }
        return null;
    }

    public Collection<Developer> getAllDevelopers() {
        Collection<Developer> developers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(dataPath))) {
            String stringDeveloper;
            while ((stringDeveloper = reader.readLine()) != null) {
                Developer developer = getDeveloperFromString(stringDeveloper);
                developers.add(developer);
            }
            return developers;
        } catch (IOException e) {
            return null;
        }
    }

    public boolean saveDeveloper(Developer developer) {
        Collection<Developer> developers = getAllDevelopers();
        for (Developer currentDeveloper : developers) {
            if (currentDeveloper.getId() == developer.getId()) {
                currentDeveloper.setFirstName(developer.getFirstName());
                currentDeveloper.setLastName(developer.getLastName());
                currentDeveloper.setSpecialty(developer.getSpecialty());
                currentDeveloper.setExperience(developer.getExperience());
                currentDeveloper.setSalary(developer.getSalary());
                return collectionToFile(developers);
            }
        }
        developers.add(developer);
        return collectionToFile(developers);
    }

    public boolean removeDeveloperByID(long id) {
        Collection<Developer> developers = getAllDevelopers();
        return developers.removeIf(developer -> developer.getId() == id) && collectionToFile(developers);
    }

    public boolean removeAllDevelopers() {
        try (FileWriter fw = new FileWriter(dataPath, false)) {
            fw.write("");
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
