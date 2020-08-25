package ed.dci;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SetDemoTest {

    SetDemo setDemo;

    @Before
    public void prepare() {
        setDemo = new SetDemo(2, 0.7);
        setDemo.add(12);
    }

    @Test
    public void contiene() {
        Assert.assertEquals(false, setDemo.contiene(15));
        Assert.assertEquals(true, setDemo.contiene(12));
    }

    @Test
    public void add() {
        Assert.assertEquals(true, setDemo.add(15));
        Assert.assertEquals(false, setDemo.add(12));
    }

    @Test
    public void reinsertarTodo(){
        //15%4= 3
        //12%4 = 0
        setDemo.add(15);
        Assert.assertEquals(12,setDemo.buckets[0].get(0).intValue());
        Assert.assertEquals(15,setDemo.buckets[3].get(0).intValue());

        //13%8=5
        //12%8=4
        //15&8=7
        //2%8=2
        setDemo.add(13);
        setDemo.add(2);
        Assert.assertEquals(12,setDemo.buckets[4].get(0).intValue());
        Assert.assertEquals(13,setDemo.buckets[5].get(0).intValue());
        Assert.assertEquals(15,setDemo.buckets[7].get(0).intValue());
        Assert.assertEquals(2,setDemo.buckets[2].get(0).intValue());
    }


}