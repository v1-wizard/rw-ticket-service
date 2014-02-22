package ru.electrictower.rwts.beans.impl;

import ru.electrictower.rwts.beans.Passenger;

/**
 * @author Aliaksei Boole
 */
public class PropPassenger implements Passenger
{
    private String  firstName;
    private String  patronymic;
    private String  lastName;
    private String  documentType;
    private String  documentId;

    @Override
    public String getPatronymic()
    {
        return patronymic;
    }

    @Override
    public String getFirstName()
    {
        return firstName;
    }

    @Override
    public String getLastName()
    {
        return lastName;
    }

    @Override
    public int getDocumentTypeId()
    {
        return Passenger.DocumentType.valueOf(documentType).ordinal();
    }

    @Override
    public String getDocumentId()
    {
        return documentId;
    }
}
