package org.beyondpn.exam;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author beyondpn
 *         Create: 14-3-26 上午8:16
 */
public class Render {

    public String renderPaper(Paper paper) {
        StringBuilder builder = new StringBuilder();
        builder.append("<fieldset>");
        builder.append("<legend>").append(paper.getPaperName()).append("</legend>");
        builder.append(renderQuestions(paper.getQuestions()));
        builder.append("</fieldset>");
        return builder.toString();
    }

    public String renderQuestions(List<Question> questions) {
        StringBuilder builder = new StringBuilder();
        for (Question q : questions) {
            int qid = q.getQid();
            int bIdx = 0;
            String qStr = q.getQuestion();  //1厘米=$米
            builder.append("<div>");
            for (char ch : qStr.toCharArray()) {
                if (ch != '$') {
                    builder.append(ch);
                } else {
                    builder.append("<input type=\"text\" class=\"blank\" name=\"");
                    builder.append("b_").append(qid).append("_").append(bIdx);
                    builder.append("\" />");
                }
            }
            builder.append("</div>");
            builder.append("<br/>");
        }
        return builder.toString();
    }

    public String renderResult(List<Result> results) {
        StringBuilder builder = new StringBuilder();
        for (Result r : results) {
            Question q = r.getQuestion();
            int qid = q.getQid();
            int bIdx = 0;
            String qStr = q.getQuestion();  //1厘米=$米
            builder.append("<div>");
            for (char ch : qStr.toCharArray()) {
                if (ch != '$') {
                    builder.append(ch);
                } else {

                    String testA = r.getTestAnswer().get(bIdx);
                    boolean correct = testA != null && testA.trim().equals(q.getAnswer().get(bIdx));
                    if (testA == null || testA.length() == 0) {
                        testA = "未填写";
                    }
                    if(correct){
                        builder.append("<label>");
                    }else{
                        builder.append("<label class=\"incorrect\">");
                    }
                    builder.append("<input type=\"text\" class=\"blank\" name=\"");
                    builder.append("b_").append(qid).append("_").append(bIdx);
                    builder.append("\" value=\"");
                    builder.append(testA);
                    builder.append("\" />");
                    builder.append("</label>");
                    bIdx++;
                }
            }
            builder.append("</div>");
            builder.append("<br/>");
        }
        return builder.toString();
    }
}
