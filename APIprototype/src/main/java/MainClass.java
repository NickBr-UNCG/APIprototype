import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.MalformedURLException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author tenni
 */
@SpringBootApplication
public class MainClass {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(MainClass.class, args);
       carModel();
       System.exit(0);
    }

    public static void carModel() throws MalformedURLException, IOException {
    URL url = new URL("https://api.api-ninjas.com/v1/cars?model=m235i");
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestProperty("accept", "application/json");
    InputStream responseStream = connection.getInputStream();
    ObjectMapper mapper = new ObjectMapper();
    JsonNode root = mapper.readTree(responseStream);
    System.out.println(root.path("fact").asText());
    }
}
