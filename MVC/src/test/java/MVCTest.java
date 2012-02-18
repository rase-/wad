/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.server.MockMvc;
import org.springframework.test.web.server.request.MockMvcRequestBuilders;
import org.springframework.test.web.server.result.MockMvcResultMatchers;
import org.springframework.test.web.server.setup.MockMvcBuilders;

/**
 *
 * @author tonykovanen
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-context.xml", 
    "file:src/main/webapp/WEB-INF/spring-database.xml"})
public class MVCTest {
    MockMvc mockMvc;
    public MVCTest() {
    }

    
    @Before
    public void setUp() {
        String[] contextLoc = {"file:src/main/webapp/WEB-INF/spring-context.xml",
            "file:src/main/webapp/WEB-INF/spring-database.xml"};
        String warDir = "src/main/webapp";
        mockMvc = MockMvcBuilders.xmlConfigSetup(contextLoc).
                configureWebAppRootDir(warDir, false).build();
    }
    @Test
    public void requestToTeamRedirectsToHome() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/team")).
                andExpect(MockMvcResultMatchers.status().isOk()).
                andExpect(MockMvcResultMatchers.redirectedUrl("/home"));
    }
    @Test
    public void requestToPlayer() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/player")).
                andExpect(MockMvcResultMatchers.status().isOk()).
                andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/view/player.jsp")).
                andExpect(MockMvcResultMatchers.model().size(2)).
                andExpect(MockMvcResultMatchers.model().attributeExists("player")).
                andExpect(MockMvcResultMatchers.model().attributeExists("teams"));
    }
    @Test
    public void requestToHomeAddsAttribtuesPlayerAndTeamAndForwards() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/home")).
                andExpect(MockMvcResultMatchers.status().isOk()).
                andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/view/list.jsp")).
                andExpect(MockMvcResultMatchers.model().size(2)).
                andExpect(MockMvcResultMatchers.model().attributeExists("players")).
                andExpect(MockMvcResultMatchers.model().attributeExists("teams"));
    }
}
