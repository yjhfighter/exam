package org.beyondpn.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author beyondpn
 *         Create: 14-3-26 下午4:23
 */
public class Exam {

    private Render render = new Render();

    public Paper getPaper(int paperId) {
        Paper paper = new Paper();
        String filePath = String.format("D:\\exams\\%d.txt",paperId);
        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath), StandardCharsets.UTF_8)) {
            int lineIdx = 1;
            int qId = 1;
            List<Question> questions = new ArrayList<Question>();
            Question q = null;
            for (String line = null; (line = br.readLine()) != null; lineIdx++) {
                if (lineIdx == 1) {
                    paper.setPaperName(line);
                } else if (lineIdx != 2) {
                    boolean isQ = lineIdx % 2 == 1;
                    if (isQ) {
                        q = new Question();
                        q.setQid(qId++);
                        q.setQuestion(line);
                        questions.add(q);
                    } else {
                        q.setAnswer(Arrays.asList(line.split("\\s+")));
                    }
                }
            }
            paper.setQuestions(questions);
        } catch (IOException ioe) {
            return null;
        }
        return paper;
    }

    public String getRenderedPaper(Paper paper) {
        return render.renderPaper(paper);
    }

    public String getRenderedResults(List<Result> results) {
        return render.renderResult(results);
    }

}
