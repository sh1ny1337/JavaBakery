package Serialize;

import Model.Bakery;

import java.io.IOException;

public interface BakerySerialize {
    void serialize(Bakery bakery, String path) throws IOException;

    Bakery deserialize(String path) throws Exception;
}
