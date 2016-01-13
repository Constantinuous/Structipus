package de.constantinuous.structipus.sourcecode;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.is;

/**
 * Created by RichardG on 12.01.2016.
 */
public class NothingTest {

    @Test
    public void testFoo(){
        Assert.assertThat("Foo", is("Foo"));
    }
}
