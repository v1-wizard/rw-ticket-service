package ru.electrictower.rwts.beans;

import java.util.List;

/**
 * User: aliaksei.bul
 * Date: 28.10.13
 * Time: 20:35
 */
public interface Trip
{
    String getTravelDate();

    String getDepartureStation();

    String getDestinationStation();

    int getCost();

    String getTime();
}
