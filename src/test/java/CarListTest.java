
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class CarListTest {
    private CarList carList;

    @Before
    public void setUp() {
        carList = new CarLinkedList();
        for (int i = 0; i < 100; i++) {
            carList.add(new Car("Brand" + i, i));
        }
    }

    @Test
    public void whenAdded100ElementsThenSizeMustBe100() {
        assertEquals(100, carList.size());
    }

    @Test
    public void whenRemoveElementByIndexSizeMustBeDecreased() {
        assertTrue(carList.removeAt(2));
        assertEquals(99, carList.size());

    }

    @Test
    public void whenRemoveElementThenSizeMustBeDecreased() {
        Car car = new Car("Mercedes", 20);
        carList.add(car);
        assertEquals(101, carList.size());
        assertTrue(carList.remove(car));
        assertEquals(100, carList.size());
    }

    @Test
    public void whenNonExistenceElementRemovedThenReturnFalse() {
        Car car = new Car("Jily", 12);
        assertFalse(carList.remove(car));
        assertEquals(100, carList.size());
    }

    @Test
    public void whenClearedThenSizeMustBeZero() {
        carList.clear();
        assertEquals(0, carList.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenTryToGetElementOutOfBoundsThenThrowException() {
        carList.get(100);
    }

    @Test
    public void methodGetReturnedRightValue() {
        Car car = carList.get(0);
        assertEquals("Brand0", car.getBrand());
    }

    @Test
    public void insertIntoMiddle() {
        Car car = new Car("BMW", 1);
        carList.add(car,50);
        Car carFromList = carList.get(50);
        assertEquals("BMW", carFromList.getBrand());
    }
    @Test
    public void insertIntoFirstPosition() {
        Car car = new Car("BMW", 1);
        carList.add(car,0);
        Car carFromList = carList.get(0);
        assertEquals("BMW", carFromList.getBrand());
    }
    @Test
    public void insertIntoLastPosition() {
        Car car = new Car("BMW", 1);
        carList.add(car,100);
        Car carFromList = carList.get(100);
        assertEquals("BMW", carFromList.getBrand());
    }
}