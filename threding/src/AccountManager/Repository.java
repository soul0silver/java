package AccountManager;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Repository {
    private FileReader reader;
    List<User> users;
    public List<User> read() throws IOException {
        reader=new FileReader("account.json");
        Type type=new TypeToken<List<User>>(){}.getType();
        users=new Gson().fromJson(reader,type);
        reader.close();
        return  users;
    }
}
