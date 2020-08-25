package sistema.model;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class CourseTest {

    Course c1,c2,c3,c4;

    @Before
    public void setUp() throws Exception {
        c1 = new Course("c1",4);
        c2 = new Course(null,6);
        c3 = new Course(null,0);
    }

    @Test
    public void print() {
        PrintStream save_out=System.out;
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        c1.print();
        assertEquals("Class Name: c1, hour: 4.\n",out.toString());
        out.reset();
        c2.print();
        assertEquals("Class Name: Unregisted, hour: 6.\n",out.toString());
        out.reset();
        c3.print();
        assertEquals("Class Name: Unregisted, hour: 0.\n",out.toString());
    }

    @Test
    public void getCredits() {

    }
}