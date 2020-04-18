package server;

import server.pojo.Context;
import server.pojo.Mapper;

import java.io.InputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

public class RequestProcessor extends Thread {

    private Socket socket;
    private Mapper mapper;

    public RequestProcessor(Socket socket, Mapper mapper) {
        this.socket = socket;
        this.mapper = mapper;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();

            // 封装Request对象和Response对象
            Request request = new Request(inputStream);
            Response response = new Response(socket.getOutputStream());

//            // 静态资源处理
////            ///lagou
////            if (mapper.get(request.getUrl()) == null) {
////                response.outputHtml(request.getUrl());
////            } else {
////                // 动态资源servlet请求
////                HttpServlet httpServlet = servletMap.get(request.getUrl());
////                httpServlet.service(request, response);
////            }

            // 静态资源处理
            // /demo1/index.html
            final String[] urls = mapper.getUrls();
            final List<String> list = Arrays.asList(urls);
            if (!list.contains(request.getUrl())) {
                response.outputHtml(mapper.getHost().getAppBase() + request.getUrl());  ///Users/liqiaoqiao/webapps/demo1/index.html
            } else {
                // 动态资源servlet请求
                // /demo1/lagou
                final Context[] contexts = mapper.getHost().getContexts();
                for (int i = 0; i < contexts.length; i++) {
                    Context context = contexts[i];
                    if (request.getUrl().contains(context.getUrl())) {
                        final HttpServlet httpServlet = context.getWrapper().getHttpServlet();
                        httpServlet.service(request, response);
                    }
                }
            }
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
