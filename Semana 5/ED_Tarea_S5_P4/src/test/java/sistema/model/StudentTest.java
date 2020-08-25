package sistema.model;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class StudentTest {

    Student s1, s2, s3, s4;

    @org.junit.Before
    public void setUp() throws Exception {
        s1 = new Student(null, null, 0);
        s2 = new Student("AsCraft", "Mundo", 6);
        s3 = new Student("Enrique", null, 1);
        s4 = new Student(null, "Ningún Lugar",2);
    }

    @org.junit.Test
    public void print() {
        PrintStream save_out=System.out;
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        s1.print();
        assertEquals("Strudent Name: Unregisted, Address: Unregisted, ID: 0.\n",out.toString());
        out.reset();
        s2.print();
        assertEquals("Strudent Name: AsCraft, Address: Mundo, ID: 6.\n",out.toString());
        out.reset();
        s3.print();
        assertEquals("Strudent Name: Enrique, Address: Unregisted, ID: 1.\n",out.toString());
        out.reset();
        s4.print();
        assertEquals("Strudent Name: Unregisted, Address: Ningún Lugar, ID: 2.\n",out.toString());
    }
}