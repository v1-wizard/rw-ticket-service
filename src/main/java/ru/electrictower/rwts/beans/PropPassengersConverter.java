package ru.electrictower.rwts.beans;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.io.IOUtils;
import ru.electrictower.rwts.beans.impl.PropPassenger;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author Aliaksei Boole
 */
public class PropPassengersConverter implements Converter
{

    @Override
    public Object convert(Class aClass, Object o)
    {
        String path = (String) o;
        List<Passenger> passengers = Collections.<Passenger>emptyList();
        try
        {
            String json = IOUtils.toString(this.getClass().getClassLoader().getResourceAsStream(path));
            Gson gson = new Gson();
            Type collectionType = new TypeToken<List<PropPassenger>>(){}.getType();
            passengers = gson.fromJson(json, collectionType);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return passengers;
    }
}
