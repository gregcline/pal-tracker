package io.pivotal.pal.tracker;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
public class WelcomeControllerTest {

    @Test
   public void testRestTemplateTest() throws Exception {

        TestRestTemplate testRestTemplate = new TestRestTemplate();
        ResponseEntity<String> response = testRestTemplate.
                getForEntity("http://localhost:8080/", String.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }


}
