package vocabulary;

import entity.Book;
import parser.Parser;

public class VocabularyCreator {
    private Book book;
    private Vocabulary vocabulary;
    private Parser parser;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Vocabulary getVocabulary() {
        return vocabulary;
    }

    public Parser getParser() {
        return parser;
    }

    public VocabularyCreator(Book book) {
        this.book = book;
    }

    public Vocabulary create() {
        vocabulary = new Vocabulary();
        parser = new Parser();
        vocabulary.addWordsFromParts(parser.parseBook(parser.removeDuplicateSpaces(book)));
        return vocabulary;
    }
}
