package de.constantinuous.structipus.metrics.sourcecode;

import com.github.javaparser.ParseException;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by RichardG on 12.01.2016.
 */
public class ResourceTest {

    @Test
    public void testResourceExistance() throws IOException, ParseException {
        File f = new File("src/test/resources/javacode/SimpleMetricCounter/SuperSimple.java");
        String absoluteFilePath = f.getAbsolutePath();
        Assert.assertTrue("File with location "+absoluteFilePath+" does not exist.", f.exists());
    }
}
