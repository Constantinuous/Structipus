
package de.constantinuous.structipus.metrics.sourcecode;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import static org.hamcrest.Matchers.*;
/**
 * Created by RichardG on 17.12.2015.
 */
public class SimpleMetricCounterTest {

    @Test
    public void testSimpleClassLinesOfCode() throws IOException {
        try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream("javacode/SimpleMetricCounter/SuperSimple.java.example")) {
            SimpleMetricCounter javaPrinter = new SimpleMetricCounter(inputStream);
            int linesOfCode = javaPrinter.getLinesOfCode();
            Assert.assertThat(linesOfCode, is(10));
        }
    }

    @Test
    public void testSimpleClassRealLinesOfCode() throws IOException {
        try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream("javacode/SimpleMetricCounter/SuperSimple.java.example")) {
            SimpleMetricCounter javaPrinter = new SimpleMetricCounter(inputStream);
            int realLinesOfCode = javaPrinter.getRealLinesOfCode();
            Assert.assertThat(realLinesOfCode, is(3));
        }
    }

    @Test
    public void testFooClassLinesOfCode() throws IOException {
        try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream("javacode/SimpleMetricCounter/Foo.java.example")) {
            SimpleMetricCounter javaPrinter = new SimpleMetricCounter(inputStream);
            int linesOfCode = javaPrinter.getLinesOfCode();
            Assert.assertThat(linesOfCode, is(33));
        }
    }

    @Test
    public void testFooClassRealLinesOfCode() throws IOException {
        try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream("javacode/SimpleMetricCounter/Foo.java.example")) {
            SimpleMetricCounter javaPrinter = new SimpleMetricCounter(inputStream);
            int realLinesOfCode = javaPrinter.getRealLinesOfCode();
            Assert.assertThat(realLinesOfCode, is(11));
        }
    }
}
