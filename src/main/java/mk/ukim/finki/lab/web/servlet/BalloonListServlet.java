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

@WebServlet(name = "balloon-list", urlPatterns = "/servlet")
public class BalloonListServlet extends HttpServlet {

    private final BalloonService balloonService;
    private final SpringTemplateEngine templateEngine;

    public BalloonListServlet(BalloonService balloonService, SpringTemplateEngine templateEngine) {
        this.balloonService = balloonService;
        this.templateEngine = templateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        WebContext webContext = new WebContext(req, resp, req.getServletContext());

        webContext.setVariable("balloons", this.balloonService.listAll());

        templateEngine.process("listBalloons.html", webContext, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getSession().invalidate();

        resp.sendRedirect("/");
    }
}
