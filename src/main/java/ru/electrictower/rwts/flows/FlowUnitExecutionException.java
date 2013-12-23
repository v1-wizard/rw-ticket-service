package ru.electrictower.rwts.flows;

/**
 * @author Serj Sintsov
 * @since  11/5/13 10:41 PM
 */
public class FlowUnitExecutionException extends Exception {

    public FlowUnitExecutionException(String msg, Object... params) {
        super(String.format(msg, params));
    }

}
