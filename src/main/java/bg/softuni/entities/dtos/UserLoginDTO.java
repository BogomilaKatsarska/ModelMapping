package bg.softuni.entities.dtos;

import bg.softuni.entities.User;

public class UserLoginDTO {
    private String username;
    private String password;

    public UserLoginDTO() {
    }
//WITHOUT MAPPER
//    public UserLoginDTO(User user) {
//        this.username = user.getUsername();
//        this.password = user.getPassword();
//    }

    @Override
    public String toString() {
        return "UserLoginDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
