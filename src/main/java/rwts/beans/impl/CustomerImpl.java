package rwts.beans.impl;

import ru.yandex.qatools.properties.PropertyLoader;
import ru.yandex.qatools.properties.annotations.Property;
import ru.yandex.qatools.properties.annotations.Resource;
import rwts.beans.Customer;

/**
 * User: aliaksei.bul
 * Date: 28.10.13
 * Time: 19:03
 */
@Resource.Classpath("main.properties")
public class CustomerImpl implements Customer
{
    @Property("customer.login")
    private String login;

    @Property("customer.password")
    private String password;

    @Property("customer.phone")
    private String phone;

    @Property("customer.sms-id")
    private String smsServiceId;

    public CustomerImpl()
    {
        PropertyLoader.populate(this);
    }

    @Override
    public String getLogin()
    {
        return login;
    }

    @Override
    public String getPassword()
    {
        return password;
    }

    @Override
    public String getPhone()
    {
        return phone;
    }

    @Override
    public String getSmsServiceId()
    {
        return smsServiceId;
    }
}
