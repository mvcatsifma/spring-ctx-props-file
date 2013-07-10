import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(locations = "classpath*:/app-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AppTest {

    @Value("#{appProperties['prop.example']}")
    private String exampleProperty;

    @Autowired
    private ValueHolder valueHolder;

    @Test
    public void testFooVal(){
        assertEquals("bar", System.getProperty("foo"));
    }

    @Test
    public void testValueHolder() throws Exception {
        assertEquals("Hello world!", valueHolder.getValue());
    }

    @Test
    public void testExampleProp() {
        assertEquals("Hello world!", exampleProperty);
    }
}
