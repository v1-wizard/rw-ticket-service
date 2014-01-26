package ru.electrictower.rwts.beans.impl;

import ru.electrictower.rwts.beans.Passenger;
import ru.electrictower.rwts.beans.PassengersList;
import ru.yandex.qatools.properties.PropertyLoader;
import ru.yandex.qatools.properties.annotations.Property;
import ru.yandex.qatools.properties.annotations.Resource;
import ru.yandex.qatools.properties.annotations.Use;

import java.util.List;

/**
 * @author Aliaksei Boole
 */
@Resource.Classpath("conf.properties")
public class PropPassengersList implements PassengersList
{

    @Use(PropPassengersConverter.class)
    @Property("passengers.file")
    private List<Passenger> passengers;

    private int index = -1;

    public final static PropPassengersList INSTANCE = new PropPassengersList();

    protected PropPassengersList()
    {
        PropertyLoader.populate(this);
    }

    @Override
    public Passenger getNext()
    {
        index++;
        return passengers.get(index);
    }

    @Override
    public boolean hasNext()
    {
        return index < passengers.size() - 1;
    }
}
