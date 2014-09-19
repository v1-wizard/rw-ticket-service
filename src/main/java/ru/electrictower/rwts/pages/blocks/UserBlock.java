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
package ru.electrictower.rwts.pages.blocks;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

import java.util.List;

/**
 * @author Aliaksei Boole
 */
@Name("Login Form on home page")
@Block(@FindBy(xpath = "//div[@class='user']"))
public class UserBlock extends HtmlElement
{
    @FindBy(xpath = ".//td[@class='status']/nobr/a[contains(@href,'/wps/myportal/home/rp/buyTicket/!ut/p')]")
    private List<Link> logOutLink;

    public void logOut()
    {
        logOutLink.get(0).click();
        if (logOutLink.size() != 0)
        {
            logOutLink.get(0).click();
        }
    }
}
