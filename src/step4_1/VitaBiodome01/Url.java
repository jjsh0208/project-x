package step4_1.VitaBiodome01;

import java.net.URL;

public class Url implements  AutoCloseable{

    private URL url;

    public Url(URL url) {
        this.url = url;
    }

    public URL getUrl() {
        return url;
    }

    @Override
    public void close() throws Exception {

    }
}
