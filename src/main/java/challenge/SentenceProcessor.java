package challenge;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;

public class SentenceProcessor {

    private static final String DELIMITER = " ";

    public String getLongestWordInSentence(String sentence) {
        TreeMap<Integer, String> sortedGroupings = getWordsGroupedByLength(sentence);
        return sortedGroupings.get(sortedGroupings.lastKey()) + " " + sortedGroupings.lastKey();
    }

    private TreeMap<Integer, String> getWordsGroupedByLength(String sentence) {
        validateSentence(sentence);
        String[] wordsInPhrase = sentence.split(DELIMITER);
        List<String> wordsAsList = Arrays.asList(wordsInPhrase);
        Map<Integer, String> wordsGroupedByLength = wordsAsList.stream()
                .collect(groupingBy(String::length, joining(" ")));

        TreeMap<Integer, String> sortedGroupings = new TreeMap<>(wordsGroupedByLength);
        return sortedGroupings;
    }

    private void validateSentence(String sentence) {
        if (sentence == null || sentence.trim().isEmpty() || !hasLetters(sentence)) {
            throw new RuntimeException("A sentence needs to have at least 1 word");
        }
    }

    private boolean hasLetters(String sentence) {
        for (char character : sentence.toCharArray()) {
            if  (Character.isLetter(character)) {
                return true;
            }
        }
        return false;
    }
}
