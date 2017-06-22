package module4.developer.model;

public class Developer {

    private long id;
    private String firstName;
    private String lastName;
    private String specialty;
    private int experience;
    private double salary;

    public Developer() {
    }

    public Developer(long id, String firstName, String lastName, String specialty,
                     Integer experience, Double salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
        this.experience = experience;
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + ". " + firstName + " " + lastName + " (" + specialty +
                "), exp: " + experience + ", salary=" + salary + "$";
    }
}
