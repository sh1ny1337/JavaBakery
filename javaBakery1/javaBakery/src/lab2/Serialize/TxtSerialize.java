package lab2.Serialize;

import Model.Bakery;
import com.google.gson.Gson;

import java.io.*;

public class TxtSerialize implements BakerySerialize {
    @Override
    public void serialize(Bakery bakery, String path) throws IOException {
        Gson gson = new Gson();
        FileOutputStream file = new FileOutputStream(path);
        ObjectOutputStream out = new ObjectOutputStream(file);
        out.writeObject(gson.toJson(bakery));

        out.close();
        file.close();
    }

    @Override
    public Bakery deserialize(String path) throws Exception {
        FileInputStream file = new FileInputStream(path);
        ObjectInputStream in = new ObjectInputStream(file);

        String bakery = (String)in.readObject();

        in.close();
        file.close();
        return new Gson().fromJson(bakery, Bakery.class);
    }
}