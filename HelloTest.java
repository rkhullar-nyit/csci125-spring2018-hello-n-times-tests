import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class HelloTest
{

    private PrintStream std_out;
    private ByteArrayOutputStream mock_out;

    @Before
    public void setUp()
    {
        std_out = System.out;
        mock_out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(mock_out));
    }

    @After
    public void tearDown()
    {
        System.setOut(std_out);
    }

    private String helper(String message, int count)
    {
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<count; i++)
        {
            builder.append(message);
            builder.append('\n');
        }
        return builder.toString();
    }

    @Test
    public void test_hello_1()
    {
        String message="hello world"; int count = 4;
        Hello.hello(message, count);
        String y = mock_out.toString();
        String e = helper(message, count);
        assertEquals(e, y);
    }

    @Test
    public void test_hello_2()
    {
        String message="apple"; int count = 3;
        Hello.hello(message, count);
        String y = mock_out.toString();
        String e = helper(message, count);
        assertEquals(e, y);
    }
}