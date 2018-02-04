import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.HashMap;

class TestRunner
{

    private static final int max = 10, min = 2;
    private static final HashMap<String, Integer> penalties = new HashMap<>();

    static
    {
        penalties.put("test_hello_1", 5);
        penalties.put("test_hello_2", 5);
    }

    public static void main(String[] args)
    {
        Result result = JUnitCore.runClasses(HelloTest.class);

        int grade = max;

        for(Failure failure: result.getFailures())
        {
            String name = failure.getTestHeader().split("[(]")[0];
            System.err.printf("failed test: %s\n", name);
            grade -= penalties.get(name);
        }

        if(grade < min)
            grade = min;

        System.out.println(grade);
    }
}
