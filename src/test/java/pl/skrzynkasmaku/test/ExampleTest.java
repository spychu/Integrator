package pl.skrzynkasmaku.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Iterator;
import java.util.function.Consumer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;
import pl.skrzynkasmaku.integrator.prestashop.model.Order;

/**
 *
 * @author Spychu
 */
@RunWith(MockitoJUnitRunner.class)

public class ExampleTest {

    @Mock
    private Order order;

    public ExampleTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void iteratorContainsTreeStrings() {
        Iterator<String> i = mock(Iterator.class);
        when(i.hasNext()).thenReturn(true, true, true, false);
        when(i.next()).thenReturn("String 1", "String 2", "String 3");
        final StringBuilder stringBuilder = new StringBuilder();
        for (; i.hasNext();) {

            stringBuilder.append(i.next()).append(";");
        }
        i.forEachRemaining(new Consumer<String>() {
            @Override
            public void accept(String s) {
                stringBuilder.append(s).append(";");
            }
        });
        assertEquals("String 1;String 2;String 3;", stringBuilder.toString());
    }

    @Test
    public void hello() {
        assertTrue(true);
        Order o = Mockito.mock(Order.class);
        when(o.getId()).thenReturn(43);
        assertNotEquals(null, order);
        assertEquals(new Integer(43), o.getId());
        verify(o, times(1)).getId();

    }
}
