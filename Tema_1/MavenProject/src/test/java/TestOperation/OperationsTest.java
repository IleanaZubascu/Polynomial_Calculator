package TestOperation;
import org.example.Data.Polynom;
import org.example.Logic.Operatie;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class OperationsTest {
    @Test
    public void addTest(){
        Operatie o=new Operatie();
        Polynom polynom= o.add(new Polynom("x^1"), new Polynom("x^2"));
        String actualResult=polynom.toString();
        assertEquals("x^1+x^2",actualResult);
    }
    @Test
    public void addTestFail(){
        Operatie o=new Operatie();
        Polynom polynom= o.add(new Polynom("x^1"), new Polynom("x^2"));
        String actualResult=polynom.toString();
        assertEquals("x^1",actualResult);
    }
    @Test
    public void subTest(){
        Operatie o=new Operatie();
        Polynom polynom= o.sub(new Polynom("x^1-3x^2"), new Polynom("x^2"));
        String actualResult=polynom.toString();
        assertEquals("x^1-4.0x^2",actualResult);
    }
    @Test
    public void subTestFail(){
        Operatie o=new Operatie();
        Polynom polynom= o.sub(new Polynom("x^1-3x^2"), new Polynom("x^2"));
        String actualResult=polynom.toString();
        assertEquals("-4.0x^2",actualResult);
    }
    @Test
    public void multiplyTest(){
        Operatie o=new Operatie();
        Polynom polynom= o.multiplicate(new Polynom("x^5"), new Polynom("x^1"));
        String actualResult=polynom.toString();
        assertEquals("x^6",actualResult);
    }
    @Test
    public void multiplyTestFail(){
        Operatie o=new Operatie();
        Polynom polynom= o.multiplicate(new Polynom("x^5"), new Polynom("x^1"));
        String actualResult=polynom.toString();
        assertEquals("-1.0x^6",actualResult);
    }
    @Test
    public void divideTest(){
        Operatie o=new Operatie();
        Polynom[] polynom= o.divide(new Polynom("x^5"), new Polynom("x^1"));

        String actualResult="Q: "+polynom[0].toString()+" R: "+polynom[1].toString();
        assertEquals("Q: x^4 R: 0.0x^0",actualResult);
    }
    @Test
    public void divideTestFail(){
        Operatie o=new Operatie();
        Polynom[] polynom= o.divide(new Polynom("x^3"), new Polynom("x^5"));

        String actualResult="Q: "+polynom[0].toString()+" R: "+polynom[1].toString();
        assertEquals("Q: x^4 R: x^1",actualResult);
    }
    @Test
    public void derivationTest(){
        Operatie o=new Operatie();
        Polynom polynom= o.derivation(new Polynom("4x^2"));
        String actualResult=polynom.toString();
        assertEquals("8.0x^1",actualResult);
    }
    @Test
    public void derivationTestFail(){
        Operatie o=new Operatie();
        Polynom polynom= o.derivation(new Polynom("4x^2"));
        String actualResult=polynom.toString();
        assertEquals("10.0x^1",actualResult);
    }
    @Test
    public void integrationTest(){
        Operatie o=new Operatie();
        Polynom polynom= o.integral(new Polynom("4x^2"));
        String actualResult=polynom.toString();
        assertEquals("1.33x^3",actualResult);
    }
    @Test
    public void integrationTestFail(){
        Operatie o=new Operatie();
        Polynom polynom= o.integral(new Polynom("4x^2"));
        String actualResult=polynom.toString();
        assertEquals("1.33x^4",actualResult);
    }

}
