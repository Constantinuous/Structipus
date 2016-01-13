package de.constantinuous.structipus.metrics.sourcecode;

import com.github.javaparser.ParseException;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import static org.hamcrest.Matchers.*;

/**
 * Created by RichardG on 17.12.2015.
 */
public class AstMetricCounterTest {

    private final String prefix = "src/test/resources/";

    @Test
    public void testSimpleClassMcCabe() throws IOException, ParseException {
        try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream(prefix+"javacode/SimpleMetricCounter/SuperSimple.java")) {
            AstMetricCounter javaPrinter = new AstMetricCounter(inputStream);
            int mcCabe = javaPrinter.getMcCabe();
            Assert.assertThat(mcCabe, is(0));
        }

        // new ByteArrayInputStream(string.getBytes()); // transform a string to an inputstream
    }

    @Test
    public void testFooClassMcCabe() throws IOException, ParseException {
        try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream(prefix+"javacode/SimpleMetricCounter/Foo.java")) {
            AstMetricCounter javaPrinter = new AstMetricCounter(inputStream);
            int mcCabe = javaPrinter.getMcCabe();
            Assert.assertThat(mcCabe, is(0));
        }
    }

    @Test
    public void testCarClassMcCabe() throws IOException, ParseException {
        try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream(prefix+"javacode/Car.java")) {
            AstMetricCounter javaPrinter = new AstMetricCounter(inputStream);
            int mcCabe = javaPrinter.getMcCabe();
            Assert.assertThat(mcCabe, is(5));
        }
    }
}
