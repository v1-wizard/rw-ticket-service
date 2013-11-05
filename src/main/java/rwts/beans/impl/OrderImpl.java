package rwts.beans.impl;

import ru.yandex.qatools.properties.PropertyLoader;
import ru.yandex.qatools.properties.annotations.Property;
import ru.yandex.qatools.properties.annotations.Resource;
import rwts.beans.Order;
import rwts.beans.Passenger;

import java.util.List;

/**
 * User: aliaksei.bul
 * Date: 28.10.13
 * Time: 20:47
 */

@Resource.Classpath("main.properties")
public class OrderImpl implements Order
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

    public OrderImpl()
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
        return "вильнюс"; //todo
    }

    @Override
    public String getDestinationStation()
    {
        return "минск"; //todo
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
