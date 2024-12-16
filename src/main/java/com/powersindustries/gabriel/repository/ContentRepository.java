package com.powersindustries.gabriel.repository;

import com.powersindustries.gabriel.model.Content;
import com.powersindustries.gabriel.util.FileReadingHelper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContentRepository {

    FileReadingHelper fileReadingHelper = new FileReadingHelper();

    // Returns a list of all users from the database.
    public Content getTestBody() {
        String id = "testEmailContent.html";
        List<String> html = fileReadingHelper.getFileLines(id);

        Content content = new Content();
        content.setId(id);
        content.setHtml(String.join("\n", html));

        return content;
    }
}
