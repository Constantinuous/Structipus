package de.constantinuous.structipus.di;

import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;

/**
 * Created by RichardG on 13.01.2016.
 */
public class Binder {
    private MutablePicoContainer picoContainer;

    public Binder(){
        picoContainer = new DefaultPicoContainer();
    }

    public <T> Implementer bindInterface(Class<? extends T> port){
        return new Implementer<T>() {
            @Override
            public void toImplementation(Class<T> adapter) {
                picoContainer.addComponent(port, adapter);
            }
        };
    }

    public <T> T getImplementation(Class<T> port){
        return picoContainer.getComponent(port);
    }
}
