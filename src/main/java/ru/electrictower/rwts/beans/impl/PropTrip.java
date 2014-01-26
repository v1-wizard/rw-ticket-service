package ru.electrictower.rwts.beans.impl;

import ru.yandex.qatools.properties.PropertyLoader;
import ru.yandex.qatools.properties.annotations.Property;
import ru.yandex.qatools.properties.annotations.Resource;
import ru.electrictower.rwts.beans.Trip;

/**
 * @author Aliaksei Boole
 */
@Resource.Classpath("conf.properties")
public class PropTrip implements Trip
{

    @Property("trip.station.departure")
    private String departureStation;

    @Property("trip.station.destination")
    private String destinationStation;

    @Property("trip.travel.date")
    private String travelDate;

    @Property("trip.ticket.max.cost")
    private int ticketCost;

    @Property("trip.travel.time")
    private String travelTime;

    public final static PropTrip INSTANCE = new PropTrip();

    private PropTrip()
    {
        PropertyLoader.populate(this);
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
