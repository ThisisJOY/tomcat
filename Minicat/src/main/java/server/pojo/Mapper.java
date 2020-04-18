package server.pojo;

public class Mapper {

    private String[] urls= new String[2]; //demo1/lagou, demo2/lagou
    private Host host;

    public Mapper() {

    }

    public String[] getUrls() {
        return urls;
    }

    public void setUrls(String[] urls) {
        this.urls = urls;
    }

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }
}
