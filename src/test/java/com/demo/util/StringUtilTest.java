package com.demo.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringUtilTest {

    StringUtil stringUtil;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception {
        stringUtil = new StringUtil();
    }

    @Test
    void test_provideInputFile_withSpace() {

        String s = "123 abc";
        int expected = 3;

        assertEquals(expected, stringUtil.getFirstWhiteSpaceIndex(s), "The only one white space is a space.");
    }

    @Test
    void test_provideInputFile_withTabulator() {

        String s = "123\tabc";
        int expected = 3;

        assertEquals(expected, stringUtil.getFirstWhiteSpaceIndex(s), "The only one white space is a tabulator.");
    }

    @Test
    void test_provideInputFile_withFirstSpace() {

        String s = "123 \tabc";
        int expected = 3;

        assertEquals(expected, stringUtil.getFirstWhiteSpaceIndex(s), "The first one white space is a space.");
    }

    @Test
    void test_provideInputFile_withFirstTabulator() {

        String s = "123\t abc";
        int expected = 3;

        assertEquals(expected, stringUtil.getFirstWhiteSpaceIndex(s), "The first one white space is a tabulator.");
    }
}
