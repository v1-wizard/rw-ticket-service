/*
 * Copyright (C) 2005-2014 Alfresco Software Limited.
 *
 * This file is part of Alfresco
 *
 * Alfresco is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Alfresco is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Alfresco. If not, see <http://www.gnu.org/licenses/>.
 */
package ru.electrictower.rwts;

import ru.electrictower.rwts.beans.Customer;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Aliaksei Boole
 */
public final class Sms
{

    private Sms()
    {
    }

    public static void send(Customer customer, String text)
    {
        try
        {
            text = text.replace(" ","+");
            String url = String.format(
                    "http://sms.ru/sms/send?api_id=%s&to=%s&text=%s",
                    customer.getSmsServiceId(),
                    customer.getPhone(),
                    text
            );

            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            System.out.println("Sending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
