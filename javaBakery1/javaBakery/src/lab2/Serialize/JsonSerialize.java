package lab2.Serialize;

import Model.Bakery;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonSerialize  implements BakerySerialize {
    @Override
    public void serialize(Bakery bakery, String path) throws IOException {
        Gson gson = new Gson();
        File file = new File(path);
        FileWriter fl = new FileWriter(file);
        fl.write(gson.toJson(bakery));
        fl.close();
    }

    @Override
    public Bakery deserialize(String path) throws Exception {
        return new Gson().fromJson(new FileReader(path), Bakery.class);
    }
}