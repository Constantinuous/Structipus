package de.constantinuous.structipus.metrics.sourcecode;

import com.github.javaparser.ParseException;
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
public class AstMetricCounterTest {

    @Test
    public void testSimpleClassMcCabe() throws IOException, ParseException {
        try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream("javacode/SimpleMetricCounter/SuperSimple.java.example")) {
            AstMetricCounter javaPrinter = new AstMetricCounter(inputStream);
            int mcCabe = javaPrinter.getMcCabe();
            Assert.assertThat(mcCabe, is(0));
        }

        // new ByteArrayInputStream(string.getBytes()); // transform a string to an inputstream
    }

    @Test
    public void testFooClassMcCabe() throws IOException, ParseException {
        String location = "javacode/SimpleMetricCounter/Foo.java.example";
        URL url = getClass().getClassLoader().getResource(location);
//
//        String file = url.getFile();
//        String path = url.getPath();
//        Object content = url.getContent();
        File f = new File(location);
        String absoluteFilePath = f.getAbsolutePath();
        boolean exists = f.exists();


        try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream(location)) {
            AstMetricCounter javaPrinter = new AstMetricCounter(inputStream);
            int mcCabe = javaPrinter.getMcCabe();
            Assert.assertThat(mcCabe, is(0));
        }
    }

    @Test
    public void testCarClassMcCabe() throws IOException, ParseException {
        try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream("javacode/Car.java.example")) {
            AstMetricCounter javaPrinter = new AstMetricCounter(inputStream);
            int mcCabe = javaPrinter.getMcCabe();
            Assert.assertThat(mcCabe, is(5));
        }
    }
}
