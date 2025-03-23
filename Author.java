public class Author {
    private String name;
    private String nationality;
    private int yearOfBirth;

    public Author(String name, String nationality, int yearOfBirth) {
        this.name = name;
        this.nationality = nationality;
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nNationality: " + nationality + "\nBorn: " + yearOfBirth;
    }
}



