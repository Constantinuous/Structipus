
package de.constantinuous.structipus.metrics.sourcecode;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import static org.hamcrest.Matchers.*;
/**
 * Created by RichardG on 17.12.2015.
 */
public class SimpleMetricCounterTest {

    private final String prefix = "src/test/resources/";

    @Test
    public void testSimpleClassExists() throws IOException {
        URL url = getClass().getClassLoader().getResource(prefix + "javacode/SimpleMetricCounter/SuperSimple.java");
        url = getClass().getClassLoader().getResource("javacode/SimpleMetricCounter/SuperSimple.java");
        Assert.assertThat(url.getPath(), not(isEmptyOrNullString()));

    }

    @Test
    public void testSimpleClassLinesOfCode() throws IOException {
        try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream(prefix+"javacode/SimpleMetricCounter/SuperSimple.java")) {
            SimpleMetricCounter javaPrinter = new SimpleMetricCounter(inputStream);
            int linesOfCode = javaPrinter.getLinesOfCode();
            Assert.assertThat(linesOfCode, is(10));
        }
    }

    @Test
    public void testSimpleClassRealLinesOfCode() throws IOException {
        try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream(prefix+"javacode/SimpleMetricCounter/SuperSimple.java")) {
            SimpleMetricCounter javaPrinter = new SimpleMetricCounter(inputStream);
            int realLinesOfCode = javaPrinter.getRealLinesOfCode();
            Assert.assertThat(realLinesOfCode, is(3));
        }
    }

    @Test
    public void testFooClassLinesOfCode() throws IOException {
        try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream(prefix+"javacode/SimpleMetricCounter/Foo.java")) {
            SimpleMetricCounter javaPrinter = new SimpleMetricCounter(inputStream);
            int linesOfCode = javaPrinter.getLinesOfCode();
            Assert.assertThat(linesOfCode, is(33));
        }
    }

    @Test
    public void testFooClassRealLinesOfCode() throws IOException {
        try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream("javacode/SimpleMetricCounter/Foo.java")) {
            SimpleMetricCounter javaPrinter = new SimpleMetricCounter(inputStream);
            int realLinesOfCode = javaPrinter.getRealLinesOfCode();
            Assert.assertThat(realLinesOfCode, is(11));
        }
    }
}
