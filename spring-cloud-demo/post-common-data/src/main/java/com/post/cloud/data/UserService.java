package com.post.cloud.data;import java.util.List;

public interface UserService {
    User getUser(String name);

    User getUser(String name, int age);

    List<User> getUsers();

    void refreshUsers();
}
