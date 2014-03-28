package org.beyondpn.exam;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author beyondpn
 *         Create: 14-3-26 上午8:11
 */
public class Paper {

    private String paperName;

    private List<Question> questions;

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public Question getQuestion(int qid) {
        if (this.questions == null) return null;
        for (Question q : this.questions) {
            if (q.getQid() == qid) return q;
        }
        return null;
    }
}
