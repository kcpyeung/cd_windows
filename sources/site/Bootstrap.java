package site;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.eclipse.jetty.server.*;
import org.eclipse.jetty.server.handler.*;

class Bootstrap {
    public static void main(String[] args) throws Exception {
        Server server = new Server(getPort());
        server.setHandler(new ResourceHandler() {
            {
                setResourceBase("static");
            }
            public void handle(String target, Request baseRequest,
                HttpServletRequest request, HttpServletResponse response)
                throws IOException, ServletException {
                if (target.startsWith("/time")) {
                    response.setHeader("Content-Type", "text/html");
                    response.getWriter().write("<p>" + new Date());
                    baseRequest.setHandled(true);
                } else {
                    super.handle(target, baseRequest, request, response);
                }
            }
        });
        server.start();
        server.join();
    }

    public static int getPort() throws Exception {
        int port = 9090;

        if (System.getProperty("APP_PORT") != null) {
            port = Integer.parseInt(System.getProperty("APP_PORT"));
        }

        return port;
    }
}
