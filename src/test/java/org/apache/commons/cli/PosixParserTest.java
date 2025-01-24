package org.apache.commons.cli;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

/**
 * Test case for the PosixParser with parameterized tests.
 */
public class PosixParserTest extends AbstractParserTestCase {

    @Override
    @SuppressWarnings("deprecation")
    @BeforeEach
    public void setUp() {
        super.setUp();
        parser = new PosixParser();
    }

    /**
     * Provides disabled test cases that are not supported by PosixParser.
     */
    private static Stream<Arguments> unsupportedTests() {
        return Stream.of(
            Arguments.of("testAmbiguousLongWithoutEqualSingleDash"),
            Arguments.of("testAmbiguousLongWithoutEqualSingleDash2"),
            Arguments.of("testAmbiguousPartialLongOption4"),
            Arguments.of("testDoubleDash2"),
            Arguments.of("testLongWithEqualSingleDash"),
            Arguments.of("testLongWithoutEqualSingleDash"),
            Arguments.of("testLongWithUnexpectedArgument1"),
            Arguments.of("testNegativeOption"),
            Arguments.of("testShortWithEqual"),
            Arguments.of("testUnambiguousPartialLongOption4")
        );
    }

    /**
     * Runs each disabled test and marks them as not supported.
     *
     * @param testName The name of the unsupported test.
     */
    @ParameterizedTest(name = "{0} is not supported by the PosixParser")
    @MethodSource("unsupportedTests")
    @Disabled("Not supported by the PosixParser")
    public void testUnsupportedByPosixParser(String testName) {
        // Each unsupported test is effectively a placeholder
        System.out.printf("%s is not supported by the PosixParser%n", testName);
    }
}
