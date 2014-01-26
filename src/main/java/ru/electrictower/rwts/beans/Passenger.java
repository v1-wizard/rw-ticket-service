package ru.electrictower.rwts.beans;

/**
 * @author Aliaksei Boole
 */
public interface Passenger
{
    public enum DocumentType
    {
        PASSPORT_BLR,
        PASSPORT_RUS_NEW,
        PASSPORT_RUS,
        FOREIGN_DOCUMENT,
        SEAMAN_PASSPORT,
        BIRTH_CERTIFICATE,
        MILITARY_ID,
        IDENTIFY_CARD,
        DOC_ABOUT_PASSPORT_LOST,
        PRISONER_DOC,
        RESIDENCE_PERMIT
    }

    String getPatronymic();

    String getFirstName();

    String getLastName();

    int getDocumentTypeId();

    String getDocumentId();

}
