/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * @author tonykovanen
 */
public class ChatTest {
    static String osoite = "http://t-avihavai.users.cs.helsinki.fi/lets/Chat";
    private WebDriver webDriver;
    
    public ChatTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        webDriver = new HtmlUnitDriver();
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void test() {
        // haetaan haluttu osoite (aiemmin määritelty muuttuja)
        webDriver.get(osoite);

        // haetaan kenttä nimeltä tunnus
        WebElement element = webDriver.findElement(By.name("tunnus"));
        Assert.assertNotNull(element);

        // asetetaan kenttään arvo
        element.sendKeys("Arvo");

        // lähetetään lomake
        element.submit();

        // haetaan kenttä nimeltä "viesti"
        element = webDriver.findElement(By.name("viesti"));
        Assert.assertNotNull(element);
    }
    @Test
    public void toimiikoSopivanKokoisetTunnukset() {
        webDriver.get(osoite);
        
        WebElement element = webDriver.findElement(By.name("tunnus"));
        Assert.assertNotNull("Tunnus oli null", element);
        Assert.assertTrue("Ei ollut ensin loginissa", webDriver.getCurrentUrl().contains("Login"));
        element.sendKeys("tunnus");
        
        element.submit();
        
        String string = webDriver.getCurrentUrl();
        Assert.assertTrue("Ei siirtynyt onnistuneesti Chattiin", string.contains("Chat"));
        Assert.assertTrue("Sisälsi osoitteessa Login", !string.contains("Login"));
    }
    @Test
    public void liianIsoTunnusEiToimi() {
        webDriver.get(osoite);
        
        WebElement element = webDriver.findElement(By.name("tunnus"));
        Assert.assertNotNull("Tunnus oli null", element);
        Assert.assertTrue("Ei ollut ensin loginissa", webDriver.getCurrentUrl().contains("Login"));
        element.sendKeys("tamaonselvastiliianisotunnuseikapitaisimennalapi");
        
        element.submit();
        
        String string = webDriver.getCurrentUrl();
        Assert.assertFalse("Siirtyi onnistuneesti Chattiin", string.contains("Chat"));
        Assert.assertTrue("Ei sisältänyt osoitteessa Login", string.contains("Login"));
    }
    @Test
    public void liianPieniTunnusEiToimi() {
        webDriver.get(osoite);
        
        WebElement element = webDriver.findElement(By.name("tunnus"));
        Assert.assertNotNull("Tunnus oli null", element);
        Assert.assertTrue("Ei ollut ensin loginissa", webDriver.getCurrentUrl().contains("Login"));
        element.sendKeys("i");
        
        element.submit();
        
        String string = webDriver.getCurrentUrl();
        Assert.assertFalse("Siirtyi onnistuneesti Chattiin", string.contains("Chat"));
        Assert.assertTrue("Ei sisältänyt osoitteessa Login", string.contains("Login"));
    }
    @Test
    public void tunnusOttaaErikoismerkkeja() {
        webDriver.get(osoite);
        
        WebElement element = webDriver.findElement(By.name("tunnus"));
        Assert.assertNotNull("Tunnus oli null", element);
        Assert.assertTrue("Ei ollut ensin loginissa", webDriver.getCurrentUrl().contains("Login"));
        element.sendKeys("!?!/&%%");
        
        element.submit();
        
        String string = webDriver.getCurrentUrl();
        Assert.assertTrue("Siirtyi onnistuneesti Chattiin", string.contains("Chat"));
        Assert.assertFalse("Ei sisältänyt osoitteessa Login", string.contains("Login"));
    }
    @Test
    public void viestiEiSisallaAakkosia() {
        // haetaan haluttu osoite (aiemmin määritelty muuttuja)
        webDriver.get(osoite);

        // haetaan kenttä nimeltä tunnus
        WebElement element = webDriver.findElement(By.name("tunnus"));
        Assert.assertNotNull(element);

        // asetetaan kenttään arvo
        element.sendKeys("Arvo");

        // lähetetään lomake
        element.submit();

        // haetaan kenttä nimeltä "viesti"
        element = webDriver.findElement(By.name("viesti"));
        element.sendKeys("äöäöäööö");
        element.submit();
        String string = webDriver.getPageSource();
        Assert.assertFalse(string.contains("Ã"));
        Assert.assertNotNull(element);
    }
    @Test
    public void viestiMeneeLapiJosEiKirjaimistaPoikkeava() {
        // haetaan haluttu osoite (aiemmin määritelty muuttuja)
        webDriver.get(osoite);

        // haetaan kenttä nimeltä tunnus
        WebElement element = webDriver.findElement(By.name("tunnus"));
        Assert.assertNotNull(element);

        // asetetaan kenttään arvo
        element.sendKeys("Arvo");

        // lähetetään lomake
        element.submit();

        // haetaan kenttä nimeltä "viesti"
        element = webDriver.findElement(By.name("viesti"));
        element.sendKeys("Tama on viesti jonka pitaisi menna lapi");
        element.submit();
        Assert.assertTrue(webDriver.getPageSource().contains("Tama on viesti jonka pitaisi menna lapi"));
        Assert.assertNotNull(element);
    }
    @Test
    public void vasentaNuoltaEiVoiLaittaaViesteihin() {
        // haetaan haluttu osoite (aiemmin määritelty muuttuja)
        webDriver.get(osoite);

        // haetaan kenttä nimeltä tunnus
        WebElement element = webDriver.findElement(By.name("tunnus"));
        Assert.assertNotNull(element);

        // asetetaan kenttään arvo
        element.sendKeys("Arvo");

        // lähetetään lomake
        element.submit();

        // haetaan kenttä nimeltä "viesti"
        element = webDriver.findElement(By.name("viesti"));
        element.sendKeys("<-");
        element.submit();
        Assert.assertFalse(webDriver.getPageSource().contains("&lt;-"));
        Assert.assertNotNull(element);
    }
    @Test
    public void oikeaaNuoltaEiVoiLaittaaViestiin() {
        // haetaan haluttu osoite (aiemmin määritelty muuttuja)
        webDriver.get(osoite);

        // haetaan kenttä nimeltä tunnus
        WebElement element = webDriver.findElement(By.name("tunnus"));
        Assert.assertNotNull(element);

        // asetetaan kenttään arvo
        element.sendKeys("Arvo");

        // lähetetään lomake
        element.submit();

        // haetaan kenttä nimeltä "viesti"
        element = webDriver.findElement(By.name("viesti"));
        element.sendKeys("->");
        element.submit();
        Assert.assertFalse(webDriver.getPageSource().contains("-&gt;"));
        Assert.assertNotNull(element);
    }
    @Test
    public void viestiinEiVoiLaittaaYhtakaanAakkosta() {
        // haetaan haluttu osoite (aiemmin määritelty muuttuja)
        webDriver.get(osoite);

        // haetaan kenttä nimeltä tunnus
        WebElement element = webDriver.findElement(By.name("tunnus"));
        Assert.assertNotNull(element);

        // asetetaan kenttään arvo
        element.sendKeys("Arvo");

        // lähetetään lomake
        element.submit();

        // haetaan kenttä nimeltä "viesti"
        element = webDriver.findElement(By.name("viesti"));
        element.sendKeys("Tamä on viesti");
        element.submit();
//        webDriver.get(osoite);
        Assert.assertFalse(webDriver.getPageSource().contains("Ã"));
    }
}
