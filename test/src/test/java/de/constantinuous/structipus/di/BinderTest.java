package de.constantinuous.structipus.di;

import de.constantinuous.structipus.di.model.*;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.*;

/**
 * Created by RichardG on 13.01.2016.
 */
public class BinderTest {

    @Test
    public void shouldReturnBlackOrange(){
        Binder binder = new Binder();
        binder.bindInterface(Orange.class).toImplementation(BlackOrange.class);

        Orange blackOrange = binder.getImplementation(Orange.class);
        Assert.assertThat(blackOrange, instanceOf(BlackOrange.class));
    }

    @Test
    public void shouldReturnAnyOrange(){
        Binder binder = new Binder();
        binder.bindInterface(Orange.class).toImplementation(BlackOrange.class);

        Orange blackOrange = binder.getImplementation(Orange.class);
        Assert.assertThat(blackOrange, isA(Orange.class));
    }

    @Test(expected=ClassCastException.class)
    public void shouldReturnAnException(){
        Binder binder = new Binder();
        binder.bindInterface(BlackOrange.class).toImplementation(Orange.class);
    }

    @Test
    public void shouldReturnNull(){
        Binder binder = new Binder();
        binder.bindInterface(Orange.class).toImplementation(BlackOrange.class);

        Apple apple = binder.getImplementation(Apple.class);
        // binder could create this apple, because it knows how to create an orange but it does not
        Assert.assertNull(apple);
    }


    @Test
    public void shouldReturnRedApple(){
        Binder binder = new Binder();
        binder.bindInterface(Orange.class).toImplementation(BlackOrange.class);
        binder.bindInterface(Fruit.class).toImplementation(BlueApple.class);
        binder.bindInterface(Apple.class).toImplementation(RedApple.class);

        Apple apple = binder.getImplementation(Apple.class);

        Assert.assertThat(apple, instanceOf(RedApple.class));
    }
    @Test
    public void shouldReturnBlueApple(){
        Binder binder = new Binder();
        binder.bindInterface(Orange.class).toImplementation(BlackOrange.class);
        binder.bindInterface(Fruit.class).toImplementation(BlueApple.class);
        binder.bindInterface(Apple.class).toImplementation(RedApple.class);

        Fruit fruit = binder.getImplementation(Fruit.class);

        Assert.assertThat(fruit, instanceOf(BlueApple.class));
    }
}
