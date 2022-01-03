package mk.ukim.finki.lab.web.servlet;

import mk.ukim.finki.lab.service.BalloonService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "select-balloon", urlPatterns = "/servlet/selectBalloonSize")
public class SelectBalloonServlet extends HttpServlet {

    private final SpringTemplateEngine templateEngine;

    public SelectBalloonServlet(SpringTemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        WebContext webContext = new WebContext(req, resp, req.getServletContext());

        templateEngine.process("selectBalloonSize.html", webContext, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        WebContext webContext = new WebContext(req, resp, req.getServletContext());

//        webContext.setVariable("color", req.getParameter("color"));

        req.getSession().setAttribute("color", req.getParameter("color"));

        templateEngine.process("selectBalloonSize.html", webContext, resp.getWriter());

    }
}
