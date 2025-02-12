package com.powersindustries.gabriel.service;

import com.powersindustries.gabriel.util.FileReadingHelper;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkdownToHTMLService {

    private final Parser parser;
    private final HtmlRenderer renderer;

    private FileReadingHelper fileReadingHelper = new FileReadingHelper();

    public MarkdownToHTMLService() {
        this.parser = Parser.builder().build();
        this.renderer = HtmlRenderer.builder().build();
    }

    public String convertMarkdownFileToHTMLString(String file) {
        List<String> markdownList = fileReadingHelper.getFileLines(file);
        String markdownString = String.join("\n", markdownList);
        Node document = parser.parse(markdownString);
        return renderer.render(document);
    }

    public String convertMarkdownStringToHTMLString(String markdown) {
        Node document = parser.parse(markdown);
        return renderer.render(document);
    }
}
