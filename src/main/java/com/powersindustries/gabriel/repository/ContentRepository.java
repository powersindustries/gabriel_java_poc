package com.powersindustries.gabriel.repository;

import com.powersindustries.gabriel.model.Content;
import com.powersindustries.gabriel.util.FileReadingHelper;
import com.powersindustries.gabriel.service.MarkdownToHTMLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContentRepository {

    @Autowired
    private MarkdownToHTMLService markdownToHTMLService;
    private FileReadingHelper fileReadingHelper;

    public ContentRepository() {
        this.fileReadingHelper = new FileReadingHelper();
    }

    // Returns a sample HTML body from the database.
    public Content getTestHTMLBody() {
        String id = "testEmailContent.html";
        List<String> html = fileReadingHelper.getFileLines(id);

        Content content = new Content();
        content.setId(id);
        content.setHtml(String.join("\n", html));

        return content;
    }

    // Returns a sample HTML body from a converted markdown file that is in the database.
    public Content getTestMarkdownToHTMLBody() {
        String id = "testEmailContentMarkdown.md";
        String markdownAsHTML = markdownToHTMLService.convertMarkdownFileToHTMLString(id);

        Content content = new Content();
        content.setId(id);
        content.setHtml(markdownAsHTML);

        return content;
    }
}
