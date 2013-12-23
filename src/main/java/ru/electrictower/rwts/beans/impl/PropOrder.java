package ru.electrictower.rwts.beans.impl;

import ru.yandex.qatools.properties.PropertyLoader;
import ru.yandex.qatools.properties.annotations.Property;
import ru.yandex.qatools.properties.annotations.Resource;
import ru.electrictower.rwts.beans.Order;
import ru.electrictower.rwts.beans.Passenger;

import java.util.List;

/**
 * User: aliaksei.bul
 * Date: 28.10.13
 * Time: 20:47
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

    @Property("order.passengers.file")
    private String passengersFileName;

    @Property("order.ticket.max.cost")
    int ticketCost;

    @Property("order.travel.time")
    private String travelTime;

    public PropOrder()
    {
        PropertyLoader.populate(this);
    }

    @Override
    public List<Passenger> getPassengers()
    {
        return null;  //todo
    }

    @Override
    public int getAdultPassengersNumber()
    {
        return 1;  //todo
    }

    @Override
    public String getTravelDate()
    {
        return travelDate;
    }

    @Override
    public String getDepartureStation()
    {
        return departureStation; //todo
    }

    @Override
    public String getDestinationStation()
    {
        return destinationStation; //todo
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
