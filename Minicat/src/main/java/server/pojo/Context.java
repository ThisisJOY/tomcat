package server.pojo;

public class Context {
    private String docBase;
    private String url;
    private Wrapper wrapper;

    public Context() {
    }

    public Context(String docBase, String url, Wrapper wrapper) {
        this.docBase = docBase;
        this.url = url;
        this.wrapper = wrapper;
    }

    public String getDocBase() {
        return docBase;
    }

    public void setDocBase(String docBase) {
        this.docBase = docBase;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Wrapper getWrapper() {
        return wrapper;
    }

    public void setWrapper(Wrapper wrapper) {
        this.wrapper = wrapper;
    }
}
