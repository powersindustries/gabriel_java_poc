package com.powersindustries.gabriel.repository;

import com.powersindustries.gabriel.model.User;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    // Returns a list of all users from the database.
    public List<User> findAll() {
        List<String> emails = readFileLines("tempDatabase.txt");
        List<User> output = new ArrayList<User>();
        for (String email : emails) {
            User user = new User();
            user.setEmail(email);

            output.add(user);
        }

        return output;
    }

    // ToDo: Replace reading users from a txt file with queue to sql database.
    public List<String> readFileLines(String fileName) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                getClass().getClassLoader().getResourceAsStream(fileName), StandardCharsets.UTF_8))) {

            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lines;
    }
}