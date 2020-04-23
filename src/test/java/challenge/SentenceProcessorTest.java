package challenge;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SentenceProcessorTest {

    @Test
    public void testLongestWordHappyPath() {
        SentenceProcessor processor = new SentenceProcessor();
        String longestWord = processor.getLongestWordInSentence("The cow jumped over the moon.");
        assertThat(longestWord).isEqualTo("jumped 6");
    }

    @Test
    public void testOneWordSentence() {
        SentenceProcessor processor = new SentenceProcessor();
        String result = processor.getLongestWordInSentence("yes");
        assertThat(result).isEqualTo("yes 3");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  ", "   ", "."})
    public void testEmptyList(String sentence) {
        SentenceProcessor processor = new SentenceProcessor();
        Exception exception = assertThrows(RuntimeException.class, () -> processor.getLongestWordInSentence(sentence));
        String expectedMessage = "A sentence needs to have at least 1 word";
        assertThat(exception.getMessage()).isEqualTo(expectedMessage);
    }
}