import com.refactoringexample.my.ClassForMockingExamples;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MockitoExamples {
    @Test
    public void test1() {
        //  create mock
        ClassForMockingExamples test = mock(ClassForMockingExamples.class);

        // define return value for method getUniqueId()
        when(test.getUniqueId()).thenReturn(43);

        // use mock in test....
        assertEquals(test.getUniqueId(), 43);
    }


    // demonstrates the return of multiple values
   @Test
    public void testMoreThanOneReturnValue() {
        Iterator<String> i = mock(Iterator.class);
        when(i.next()).thenReturn("Mockito").thenReturn("rocks");
        String result = i.next() + " " + i.next();
        //assert
        assertEquals("Mockito rocks", result);
    }

    // this test demonstrates how to return values based on the input
   @Test
    public void testReturnValueDependentOnMethodParameter() {
        Comparable<String> c = mock(Comparable.class);
        when(c.compareTo("Mockito")).thenReturn(1);
        when(c.compareTo("Eclipse")).thenReturn(2);
        //assert
        assertEquals(1, c.compareTo("Mockito"));
    }





}