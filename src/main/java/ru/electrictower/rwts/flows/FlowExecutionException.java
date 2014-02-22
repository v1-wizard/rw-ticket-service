package ru.electrictower.rwts.flows;

/**
 * @author Serj Sintsov
 * @since  11/5/13 10:41 PM
 */
public class FlowExecutionException extends Exception {

    public FlowExecutionException(Throwable cause, String msg, Object... params) {
        super(String.format(msg, params), cause);
    }

}
