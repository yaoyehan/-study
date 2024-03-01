import java.util.HashMap;
import java.util.Map;

public class User {

    private String username;
    private Integer age;


    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }

    public User() {
    }

    public User(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    protected User clone() {
        User user = new User();
        user.setUsername(username);
        user.setAge(age);
        return user ;
    }
}
