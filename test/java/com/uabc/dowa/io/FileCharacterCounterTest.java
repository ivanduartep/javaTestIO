package com.uabc.dowa.io;

import org.junit.Test;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FileCharacterCounterTest {

    @Test
    public void testCountNumberOfCharacterInFile() throws Exception {
        assertEquals(0, FileCharacterCounter.countNumberOfOccurrencesInFile('x'));
        assertEquals(0, FileCharacterCounter.countNumberOfOccurrencesInFile('z'));

        assertEquals(0, FileCharacterCounter.countNumberOfOccurrencesInFile('2'));

        assertEquals(8, FileCharacterCounter.countNumberOfOccurrencesInFile(','));
        assertEquals(9, FileCharacterCounter.countNumberOfOccurrencesInFile('u'));
        assertEquals(51, FileCharacterCounter.countNumberOfOccurrencesInFile('a'));
        assertEquals(36, FileCharacterCounter.countNumberOfOccurrencesInFile('o'));

        assertEquals(52, FileCharacterCounter.countNumberOfOccurrencesInFile('e'));
        assertEquals(31, FileCharacterCounter.countNumberOfOccurrencesInFile('i'));
    }

    @Test
    public void testGetLinesInReverseOrder() throws Exception {
        LinkedList<String> linesInReverseOrder = FileCharacterCounter.getLinesInReverseOrder();
        assertNotNull(linesInReverseOrder);
        assertEquals(9, linesInReverseOrder.size());
        assertEquals("of Kashyyyk during the Clone Wars and during the Galactic Civil War.", linesInReverseOrder.get(0));
        assertEquals("Chewbacca (or \"Chewie\", as he was known by his friends)", linesInReverseOrder.get(8));
    }


}
