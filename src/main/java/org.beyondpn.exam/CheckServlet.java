package org.beyondpn.exam;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author beyondpn
 *         Create: 14-3-26 下午5:26
 */
@WebServlet(urlPatterns = "/check", name = "check")
public class CheckServlet extends HttpServlet {

    private Exam exam = new Exam();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int paperId = Integer.parseInt(req.getParameter("paperId"));
        Paper paper = exam.getPaper(paperId);

        List<Result> results = new ArrayList<>();

        for (Question q : paper.getQuestions()) {
            Result r = new Result();
            r.setQuestion(q);
            List<String> testAnswers = new ArrayList<>();
            r.setTestAnswer(testAnswers);
            for (int i = 0; i < q.getAnswer().size(); i++) {
                testAnswers.add(req.getParameter(String.format("b_%d_%d",q.getQid(),i)));
            }
            results.add(r);
        }

        req.setAttribute("paper", exam.getRenderedResults(results));
        req.setAttribute("paperId", paperId);
        RequestDispatcher rd = req.getRequestDispatcher("/result.jsp");
        rd.forward(req,resp);
    }
}
