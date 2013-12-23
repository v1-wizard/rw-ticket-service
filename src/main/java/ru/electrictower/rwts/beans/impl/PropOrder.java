package ru.electrictower.rwts.beans.impl;

import ru.electrictower.rwts.beans.PropPassengersConverter;
import ru.yandex.qatools.properties.PropertyLoader;
import ru.yandex.qatools.properties.annotations.Property;
import ru.yandex.qatools.properties.annotations.Resource;
import ru.electrictower.rwts.beans.Order;
import ru.electrictower.rwts.beans.Passenger;
import ru.yandex.qatools.properties.annotations.Use;

import java.util.List;

/**
 * @author Aliaksei Boole
 */
@Resource.Classpath("main.properties")
public class PropOrder implements Order
{

    @Property("order.station.departure")
    private String departureStation;

    @Property("order.station.destination")
    private String destinationStation;

    @Property("order.travel.date")
    private String travelDate;

    @Property("order.ticket.max.cost")
    private int ticketCost;

    @Property("order.travel.time")
    private String travelTime;

    @Use(PropPassengersConverter.class)
    @Property("order.passengers.file")
    private List<Passenger> passengers;

    @Property("order.passengers.inQueue")
    boolean isPassengersInQueue;

    public PropOrder()
    {
        PropertyLoader.populate(this);
    }

    @Override
    public List<Passenger> getPassengers()
    {
        return passengers;
    }

    @Override
    public int getAdultPassengersNumber()
    {
        int adultPassCount = 0;
        for (Passenger passenger : passengers)
        {
            if (passenger.isAdult())
            {
                adultPassCount++;
            }
        }
        return adultPassCount;
    }

    @Override
    public boolean isPassengersInQueue()
    {
        return isPassengersInQueue;
    }

    @Override
    public String getTravelDate()
    {
        return travelDate;
    }

    @Override
    public String getDepartureStation()
    {
        return departureStation;
    }

    @Override
    public String getDestinationStation()
    {
        return destinationStation;
    }

    @Override
    public int getCost()
    {
        return ticketCost;
    }

    @Override
    public String getTime()
    {
        return travelTime;
    }
}
