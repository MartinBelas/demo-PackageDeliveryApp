package com.demo.parcelsInfoReader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;

import com.demo.Store;

class ParcelsInfoFromConsoleReaderTest {

    ParcelsInfoFromConsoleReader reader;

    @Mock
    Store store;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception {
        reader = new ParcelsInfoFromConsoleReader(store);
    }

    @Test
    void test_provideInputFile_withSpace() {

        String s = "123 abc";
        int expected = 3;

        assertEquals(expected, reader.getFirstWhiteSpaceIndex(s), "The only one white space is a space.");
    }

    @Test
    void test_provideInputFile_withTabulator() {

        String s = "123\tabc";
        int expected = 3;

        assertEquals(expected, reader.getFirstWhiteSpaceIndex(s), "The only one white space is a tabulator.");
    }

    @Test
    void test_provideInputFile_withFirstSpace() {

        String s = "123 \tabc";
        int expected = 3;

        assertEquals(expected, reader.getFirstWhiteSpaceIndex(s), "The first one white space is a space.");
    }

    @Test
    void test_provideInputFile_withFirstTabulator() {

        String s = "123\t abc";
        int expected = 3;

        assertEquals(expected, reader.getFirstWhiteSpaceIndex(s), "The first one white space is a tabulator.");
    }
}
