package org.beyondpn.exam;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author beyondpn
 *         Create: 14-3-26 下午4:19
 */
@WebServlet(urlPatterns = "/", name = "home")
public class ExamServlet extends HttpServlet {

    private Exam exam = new Exam();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int paperId = 1;
        if (req.getParameter("paperId") != null) {
            paperId = Integer.parseInt(req.getParameter("paperId"));
        }
        Paper paper = exam.getPaper(paperId);//TODO:paperId
        String paperString = exam.getRenderedPaper(paper);
        req.setAttribute("paper", paperString);
        req.setAttribute("paperId", paperId);
        RequestDispatcher rd = req.getRequestDispatcher("/exam.jsp");
        rd.forward(req, resp);
    }
}
