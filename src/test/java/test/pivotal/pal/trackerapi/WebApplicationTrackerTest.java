package test.pivotal.pal.trackerapi;


import io.pivotal.pal.tracker.HelloService;
import io.pivotal.pal.tracker.PalTrackerApplication;
import io.pivotal.pal.tracker.WelcomeController;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WelcomeController.class)
@ContextConfiguration(classes = {PalTrackerApplication.class})
public class WebApplicationTrackerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HelloService helloService;

    @Test
    public void should_return_200_with_default_message() throws Exception {
        BDDMockito.given(helloService.getMessage()).willReturn("Hello from Cloud Foundry");

        this.mockMvc.perform(get("/")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello from Cloud Foundry")));


    }
}