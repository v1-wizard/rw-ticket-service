package rwts.flows.buyticket;

import rwts.flows.FlowUnit;
import rwts.flows.FlowUnitExecutionException;

/**
 * @author Serj Sintsov
 * @since  11/5/13 8:58 PM
 */
public abstract class BaseFlowUnit implements FlowUnit
{
    @Override
    public void execute() throws FlowUnitExecutionException
    {
        logMessage("START %s flow unit", getClass().getSimpleName());
        doExecute();
        logMessage("END %s flow unit", getClass().getSimpleName());
    }

    protected abstract void doExecute() throws FlowUnitExecutionException;

    protected void logMessage(String msg, Object... params)
    {
        System.out.println(String.format(msg, params));
    }
}
