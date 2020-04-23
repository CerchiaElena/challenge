package challenge;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SentenceProcessorTest {

    @Test
    public void testProcessorHappyPath() {
        SentenceProcessor processor = new SentenceProcessor();
        Assertions.assertThat(processor).isNotNull();
    }

}