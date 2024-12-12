package bg.softuni.entities.dtos;

public class UserPublicInfoDTO {
    private String firstName;
    private String lastName;
    private int age;

    public UserPublicInfoDTO() {
    }

//WITHOUT MAPPER:
//    public UserPublicInfoDTO(User user) {
//        this.firstName = user.getFirstName();
//        this.lastName = user.getLastName();
//        this.age = user.getAge();
//    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
