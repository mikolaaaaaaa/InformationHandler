package com.mikola.handler.reader;

import com.mikola.handler.exception.InformationHandlingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FileReaderTest {
    private static final String VALID_FILE_PATH = "src/test/resources/data.txt";
    private static final String TEXT = "It has survived - not only (five) centuries, but also the leap into [13  2 +] electronic typesetting, remaining [3  5 +] essentially [15  3 /] unchanged. It was popularised in the [5 x *] with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum." +
            "\nIt is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using [2 3 * y +] Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using (Content here), content here, making it look like readable English." +
            "\nIt is a [1200  5 /] established fact that a reader will be of a page when looking at its layout." +
            "\nBye.";

    @Test
    public void testReadShouldReturnCorrectTextWhenFileIsValid() throws InformationHandlingException {
        //given
        FileReader textReader = new FileReader();
        String expected = TEXT;
        //when
        String actual = textReader.read(VALID_FILE_PATH);
        //then
        Assertions.assertEquals(expected, actual);
    }

}
