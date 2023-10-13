package AccountManager;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) throws IOException {
        Gson gson=new Gson();
        BufferedWriter writer= Files.newBufferedWriter(Paths.get("customer.json"));
        Map<String,Object> map=new HashMap<>();
        map.put("id",3);
        map.put("username","ssss");
        map.put("email","ccc.gg.com");
        map.put("password","111111");
        BufferedReader reader=Files.newBufferedReader(Paths.get("customer.json"));
        JsonObject parser=JsonParser.parseReader(reader).getAsJsonObject();
        System.out.println(parser.get("id").getAsInt());

        writer.write(gson.toJson(map));
        writer.close();
        Controller controller=new Controller();
        controller.home();


    }

}
