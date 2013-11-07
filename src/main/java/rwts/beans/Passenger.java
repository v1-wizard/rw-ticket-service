package rwts.beans;

/**
 * User: aliaksei.bul
 * Date: 28.10.13
 * Time: 17:48
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

    DocumentType getDocumentTypeId();

    String getDocumentNumber();

}
