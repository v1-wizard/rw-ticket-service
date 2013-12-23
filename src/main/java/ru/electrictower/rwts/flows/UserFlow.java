package ru.electrictower.rwts.flows;

import java.util.List;

/**
 * @author Serj Sintsov
 */
public class UserFlow
{
    private List<FlowUnit> units;

    public void play() throws FlowExecutionException
    {
        try
        {
            for (FlowUnit action : units)
                if (action.isMandatory())
                    action.execute();
        }
        catch (FlowUnitExecutionException fe) {
            throw new FlowExecutionException(fe, "Flow execution is interrupted due to the flow unit exception");
        }
        catch (Exception ex) {
            throw new FlowExecutionException(ex, "Flow execution is interrupted");
        }
    }

    public void setActions(List<FlowUnit> actions)
    {
        this.units = actions;
    }
}
