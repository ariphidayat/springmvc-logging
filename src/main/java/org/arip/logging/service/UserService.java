package org.arip.logging.service;

import org.arip.logging.model.User;

import java.util.List;

/**
 * Created by Arip Hidayat on 12/9/2015.
 */
public interface UserService {

    void save(User user);

    void update(User user);

    void delete(String id);

    User getUser(String id);

    List<User> getAll();
}
