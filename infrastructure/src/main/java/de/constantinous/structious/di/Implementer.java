package de.constantinous.structious.di;

/**
 * Created by RichardG on 13.01.2016.
 */
public interface Implementer<T> {
    void toImplementation(Class<T> implementation);
}
