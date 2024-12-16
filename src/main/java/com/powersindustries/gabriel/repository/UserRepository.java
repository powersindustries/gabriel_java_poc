package com.powersindustries.gabriel.repository;

import com.powersindustries.gabriel.model.User;
import com.powersindustries.gabriel.util.FileReadingHelper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private FileReadingHelper fileReadingHelper = new FileReadingHelper();

    // Returns a list of all users from the database.
    public List<User> findAll() {
        List<String> emails = fileReadingHelper.getFileLines("tempDatabase.txt");
        List<User> output = new ArrayList<User>();
        for (String email : emails) {
            User user = new User();
            user.setEmail(email);

            output.add(user);
        }

        return output;
    }
}