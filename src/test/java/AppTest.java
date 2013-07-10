import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "classpath*:/app-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AppTest {

    @Value("#{appProperties['prop.example']}")
    private String exampleProperty;

    @Autowired
    private ValueHolder valueHolder;

    @Test
    public void testValueHolder() throws Exception {
        System.out.print(valueHolder.getValue());
    }

    @Test
    public void testExampleProp() {
        System.out.println(exampleProperty);
    }
}
