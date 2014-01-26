package ru.electrictower.rwts;

import org.junit.Assert;
import org.junit.Test;
import ru.electrictower.rwts.beans.Passenger;
import ru.electrictower.rwts.beans.PassengersList;
import ru.electrictower.rwts.beans.impl.PropTrip;
import ru.electrictower.rwts.testdata.TestPropPassengerList;

import java.util.List;

/**
 * @author Aliaksei Boole
 */
public class LoadPassengersTest extends Assert
{

    @Test
    public void checkThatPassengerConverterWork()
    {
        PassengersList passengersList = new TestPropPassengerList();
        Passenger father = passengersList.getNext();
        Passenger daughter = passengersList.getNext();
        assertEquals(father.getFirstName(), "Андрей");
        assertEquals(daughter.getPatronymic(), "Андреевна");
        assertEquals(father.getLastName(), "Кузькин");
        assertEquals(daughter.getDocumentTypeId(), 5);
        assertEquals(father.getDocumentId(), "HB1651136");
    }

    @Test
    public void checkHasNextMethod()
    {
        PassengersList passengersList = new TestPropPassengerList();
        Assert.assertTrue(passengersList.hasNext());
        passengersList.getNext();
        Assert.assertTrue(passengersList.hasNext());
        passengersList.getNext();
        Assert.assertFalse(passengersList.hasNext());
    }

}
