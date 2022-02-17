package entity;

import lombok.Data;
import org.apache.maven.model.Model;
import entity.User;

import java.util.List;
@Data
public class Root {
    private String name;
    private List<User> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Root{" +
                "name='" + name + '\'' +
                ", users=" + users +
                '}';
    }
}
