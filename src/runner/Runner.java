package runner;

import entity.Book;
import vocabulary.VocabularyCreator;

public class Runner {

    public static void main(String[] args) {
        VocabularyCreator vocabularyCreator = new VocabularyCreator(new Book("text.txt"));
        vocabularyCreator.create().printToFile("vocabulary.txt");
        System.out.println("Vocabulary created!");

        /*Print all parsed text parts
        System.out.println(vocabularyCreator.getParser().getTextParts());*/
    }
}
