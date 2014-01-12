package ru.electrictower.rwts;

import org.junit.Assert;
import org.junit.Test;
import ru.electrictower.rwts.beans.Passenger;
import ru.electrictower.rwts.beans.impl.PropOrder;
import ru.electrictower.rwts.testdata.PropOrderWithOverrideFrom;

import java.util.List;

/**
 * @author Aliaksei Boole
 */
public class LoadPassengersTest extends Assert
{

    @Test
    public void checkThatPassengerConverterWork()
    {
        PropOrder order = new PropOrderWithOverrideFrom();
        List<Passenger> passengers = order.getPassengers();
        assertTrue(passengers.size()==2);
        Passenger father = passengers.get(0);
        Passenger daughter = passengers.get(1);
        assertEquals(father.getFirstName(),"Андрей");
        assertEquals(daughter.getPatronymic(),"Андреевна");
        assertEquals(father.getLastName(),"Кузькин");
        assertEquals(daughter.getDocumentTypeId(),5);
        assertEquals(father.getDocumentId(),"HB1651136");
        assertFalse(daughter.isAdult());
    }

}
