package server.pojo;

public class Host {
    private String name;
    private String appBase;
    private Context[] contexts = new Context[2];

    public Host() {
    }

    public Host(String name, String appBase) {
        this.name = name;
        this.appBase = appBase;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAppBase() {
        return appBase;
    }

    public void setAppBase(String appBase) {
        this.appBase = appBase;
    }

    public Context[] getContexts() {
        return contexts;
    }

    public void setContexts(Context[] contexts) {
        this.contexts = contexts;
    }
}