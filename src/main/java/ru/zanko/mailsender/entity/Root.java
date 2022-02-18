package ru.zanko.mailsender.entity;

import lombok.Data;

import java.util.List;

@Data
public class Root {
    private String name;
    private List<User> users;


    @Override
    public String toString() {
        return "Root{" +
                "name='" + name + '\'' +
                ", users=" + users +
                '}';
    }
}