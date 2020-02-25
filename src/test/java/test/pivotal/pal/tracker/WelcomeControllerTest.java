package test.pivotal.pal.tracker;

import io.pivotal.pal.tracker.HelloService;
import io.pivotal.pal.tracker.WelcomeController;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;


public class WelcomeControllerTest {


    @Test
    public void itSaysHello() throws Exception {
        HelloService helloService = mock(HelloService.class);
        given(helloService.getMessage()).willReturn("Hello from test");

        WelcomeController controller = new WelcomeController(helloService);

        assertThat(controller.sayHello()).isEqualTo("Hello from test");
    }
}
