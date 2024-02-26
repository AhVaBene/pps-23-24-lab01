import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tdd.CircularList;
import tdd.CircularListImpl;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    CircularList circularList;
    CircularList emptyCircularList;
    List<Integer> testList = new ArrayList<>(List.of(1,2));
    
    @BeforeEach
    void beforeEach() {
        this.circularList = new CircularListImpl(testList);
        this.emptyCircularList = new CircularListImpl();  
    }

    @Test
    public void testAdd() {
        this.emptyCircularList.add(0);
        assertEquals(0, this.emptyCircularList.next().get());
    }

    @Test
    public void testSize() {
        assertEquals(testList.size(), this.circularList.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(this.emptyCircularList.isEmpty());
    }

    @Test
    public void testGetFirst() {
        assertEquals(testList.get(0), this.circularList.next().get());
    }

    @Test
    public void testGetFirstEmpty() {
        assertEquals(Optional.empty(), this.emptyCircularList.next());
    }

    @Test
    public void testCircularNext() {
        assertAll(
            () -> assertEquals(testList.get(0), this.circularList.next().get()),
            () -> assertEquals(testList.get(1), this.circularList.next().get()),
            () -> assertEquals(testList.get(0), this.circularList.next().get()),
            () -> assertEquals(testList.get(1), this.circularList.next().get())
        );
    }

    @Test
    public void testGetLastEmpty() {
        assertEquals(Optional.empty(), this.emptyCircularList.previous());
    }

    @Test
    public void testCircularPrevious() {
        assertAll(
            () -> assertEquals(testList.get(1), this.circularList.previous().get()),
            () -> assertEquals(testList.get(0), this.circularList.previous().get()),
            () -> assertEquals(testList.get(1), this.circularList.previous().get()),
            () -> assertEquals(testList.get(0), this.circularList.previous().get())
        );
    }

    @Test
    public void testReset() {
        this.circularList.next();
        this.circularList.next();
        this.circularList.reset();
        assertEquals(this.testList.get(0), this.circularList.next().get());
    }
}
