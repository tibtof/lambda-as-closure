package ro.tibtof.lambda.closure;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static ro.tibtof.lambda.closure.Closures.closure;

public class ClosuresTest {

    AGroovyClass groovyClass = new AGroovyClass();


    @Test
    public void closureNoParam() throws Exception {
        Object result = groovyClass.useClosure(closure(() -> "Called from Groovy!"));

        assertEquals("Called from Groovy!", result);
    }

    @Test
    public void typedClosureWithNoParam() {
        String result = groovyClass.useTypedClosure(closure(() -> "Called from Groovy!"));

        assertEquals("Called from Groovy!", result);
    }

    @Test
    public void closureWithParam() throws Exception {
        Object result = groovyClass.passToClosure(2, closure(val -> "Called from Groovy with param " + val));

        assertEquals("Called from Groovy with param 2", result);
    }

    @Test
    public void closureWithTwoParams() throws Exception {
        Object result = groovyClass.twoParamsClosure(5, "TEST",
                closure((a, b) -> "Params " + a + " and " + b));

        assertEquals("Params 5 and TEST", result);
    }

    @Test
    public void closureWithThreeParams() throws Exception {
        String result = groovyClass.threeParamsClosure(10, "second param", 1,
                closure((a, b, c) -> "Params " + a + " and " + b + " and " + c));

        assertEquals("Params 10 and second param and 1", result);
    }

}