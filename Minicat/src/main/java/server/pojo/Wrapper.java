package server.pojo;

import server.HttpServlet;

public class Wrapper {
    private HttpServlet httpServlet;

    public Wrapper() {

    }

    public HttpServlet getHttpServlet() {
        return httpServlet;
    }

    public void setHttpServlet(HttpServlet httpServlet) {
        this.httpServlet = httpServlet;
    }
}
