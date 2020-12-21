package Serialize;

import Model.Bakery;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;

public class XmlSerialize implements BakerySerialize {
    @Override
    public void serialize(Bakery bakery, String path)  throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writeValue(new File(path), bakery);
    }

    @Override
    public Bakery deserialize(String path) throws Exception {
        File file = new File(path);
        XmlMapper xmlMapper = new XmlMapper();
        String xml = inputStreamToString(new FileInputStream(file));
        Bakery bakery = xmlMapper.readValue(xml, Bakery.class);
        return bakery;
    }

    private String inputStreamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }
}