package org.beyondpn.exam;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author beyondpn
 *         Create: 14-3-26 下午6:02
 */
public class Result {

    private Question question;

    private List<String> testAnswer;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public List<String> getTestAnswer() {
        return testAnswer;
    }

    public void setTestAnswer(List<String> testAnswer) {
        this.testAnswer = testAnswer;
    }
}
