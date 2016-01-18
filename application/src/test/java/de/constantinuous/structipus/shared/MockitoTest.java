package de.constantinuous.structipus.shared;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

/**
 * Created by RichardG on 18.01.2016.
 */
public class MockitoTest {

    @Test
    public void testMockito(){
        List list = Mockito.mock(List.class);
        Mockito.when(list.isEmpty()).thenReturn(Boolean.FALSE);
        Mockito.when(list.isEmpty());
        
    }
}
