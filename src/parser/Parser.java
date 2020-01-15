package parser;

import entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static final String EMAIL_REGEX = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}";
    private static final String PHONE_REGEX = "\\+\\d{3}\\(\\d{2}\\)\\d{3}-\\d{2}-\\d{2}";
    private static final String WORD_REGEX = "[A-Za-zА-Яа-я]+[_-]?[A-Za-zА-Яа-я]+|[A-Za-zА-Яа-я]+";
    private static final String SPLITTER_OF_PART = "(?<!^)\\b";
    private static final String DUPLICATES = "[\\s\\t]+";
    private static final String SPACE_STRING = " ";
    private static final char SPACE = ' ';

    private List<TextPart> textParts;

    public List<TextPart> getTextParts() {
        return textParts;
    }

    /*Remove double spaces and tabs*/
    public Book removeDuplicateSpaces(Book book) {
        for (Line line : book.getLines())
            line.setLine(line.getLine().replaceAll(DUPLICATES, SPACE_STRING));
        return book;
    }

    public List<TextPart> parseBook(Book book) {
        textParts = new ArrayList<>();
        int endLines = book.getLines().size() - 1;
        for (Line line : book.getLines()) {
            if (!line.getLine().isEmpty()) {
                textParts.addAll(parseLine(line));
            }
            if (endLines != 0)
                textParts.add(new Symbol('\n'));
            endLines--;
        }
        return textParts;
    }

    private List<TextPart> parseLine(Line line) {
        List<TextPart> lineParts = new ArrayList<>();
        if (line.getLine().charAt(0) == SPACE) {
            lineParts.add(new Symbol(SPACE));
        }
        for (String token : line.getLine().split(SPACE_STRING)) {
            if (!token.isEmpty()) {
                if (token.matches(EMAIL_REGEX) || token.matches(PHONE_REGEX) || token.matches(WORD_REGEX))
                    lineParts.add(new Word(token));
                else if (token.length() == 1) {
                    lineParts.add(new Symbol(token.charAt(0)));
                } else {
                    TextObject textObject = new TextObject(token);
                    lineParts.addAll(parseTextObject(textObject));
                }
                lineParts.add(new Symbol(SPACE));
            }
        }
        if (line.getLine().charAt(line.getLine().length() - 1) != SPACE) {
            lineParts.remove(lineParts.size() - 1);
        }
        return lineParts;
    }

    private List<TextPart> parseTextObject(TextObject textObject) {
        List<TextPart> textObjectParts = new ArrayList<>();
        Pattern pattern = Pattern.compile(WORD_REGEX);
        Matcher matcher = pattern.matcher(textObject.getTextObject());
        if (matcher.find()) {
            for (String token : textObject.getTextObject().split(SPLITTER_OF_PART)) {
                if (token.matches(WORD_REGEX))
                    textObjectParts.add(new Word(token));
                else if (token.length() == 1) {
                    textObjectParts.add(new Symbol(token.charAt(0)));
                } else textObjectParts.add(new TextObject(token));
            }
        } else {
            textObjectParts.add(new TextObject(textObject.getTextObject()));
        }
        return textObjectParts;
    }

}
