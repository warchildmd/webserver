import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import me.homework.server.WebServer;
import me.homework.server.apps.FileServingApp;
import org.junit.*;

public class HttpTest {

    private Thread server;

    @Before
    public void setUp() {
        server = new Thread(new WebServer(52052, 4, new FileServingApp("web/")));
        server.start();
    }

    @After
    public void tearDown() {
        server.interrupt();
    }

    @Test
    public void testGetRequests() {
        final WebClient webClient = new WebClient();
        webClient.setThrowExceptionOnFailingStatusCode(false);

        try {
            Page unexpectedResult = webClient.getPage("http://127.0.0.1:52052");
            Assert.assertEquals(403, unexpectedResult.getWebResponse().getStatusCode());

            Page successfulResult = webClient.getPage("http://127.0.0.1:52052/index.html");
            Assert.assertEquals(200, successfulResult.getWebResponse().getStatusCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}