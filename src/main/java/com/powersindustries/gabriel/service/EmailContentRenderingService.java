package com.powersindustries.gabriel.service;

import com.powersindustries.gabriel.model.Content;
import com.powersindustries.gabriel.repository.ContentRepository;
import org.springframework.stereotype.Service;

@Service
public class EmailContentRenderingService {

    private final ContentRepository contentRepository;

    public EmailContentRenderingService(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    // ToDo: Replace with actual call to content database.
    public Content getBodyTestHTML() {
        return contentRepository.getTestHTMLBody();
    }

    // ToDo: Replace with actual call to content database.
    public Content getBodyTestMarkdown() {
        return contentRepository.getTestMarkdownToHTMLBody();
    }


}
