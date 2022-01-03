package mk.ukim.finki.lab.web.servlet;

import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "confirmation-info", urlPatterns = "/servlet/ConfirmationInfo")
public class ConfirmationInfoServlet extends HttpServlet {

    public final SpringTemplateEngine templateEngine;

    public ConfirmationInfoServlet(SpringTemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext webContext = new WebContext(req, resp, req.getServletContext());

        templateEngine.process("confirmationInfo.html", webContext, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        WebContext webContext = new WebContext(req, resp, req.getServletContext());

        webContext.setVariable("ipAddress", req.getRemoteAddr());
        webContext.setVariable("userAgent", req.getHeader("User-Agent"));
        req.getSession().setAttribute("clientName", req.getParameter("clientName"));
        req.getSession().setAttribute("clientAddress", req.getParameter("clientAddress"));

        templateEngine.process("confirmationInfo.html", webContext, resp.getWriter());
    }
}
