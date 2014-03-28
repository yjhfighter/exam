package org.beyondpn.exam.tools;


import org.beyondpn.exam.Question;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @author beyondpn
 *         Create: 14-3-26 下午10:57
 */
public class MeasureGenerator {

    private List<MeasureRate> rates;

    public MeasureGenerator() {
        rates = new ArrayList<>();
        rates.add(new MeasureRate(new String[]{"cm", "dm", "m"}, 10));//length
        rates.add(new MeasureRate(new String[]{"cm<sup>2</sup>", "dm<sup>2</sup>", "m<sup>2</sup>"}, 100));//area
        rates.add(new MeasureRate(new String[]{"cm<sup>3</sup>", "dm<sup>3</sup>", "m<sup>3</sup>"}, 1000));//volume
    }

    public Question randomOne() {
        MeasureRate rate = rates.get(new Random().nextInt(rates.size()));
        int unit1Rate = new Random().nextInt(rate.getUnits().length);
        int unit2Rate = new Random().nextInt(rate.getUnits().length);
        if (unit2Rate == unit1Rate) {
            if (unit1Rate == 0) {
                unit2Rate = rate.getUnits().length - 1;
            } else {
                unit2Rate = unit1Rate - 1;
            }
        }
        int between = Math.abs(unit1Rate - unit2Rate);
        BigDecimal betweenRate = new BigDecimal(1);
        for (int i = 0; i < between; i++) {
            if (unit1Rate > unit2Rate) {
                betweenRate = betweenRate.multiply(new BigDecimal(rate.getRate()));
            } else {
                betweenRate = betweenRate.divide(new BigDecimal(rate.getRate()));
            }
        }

        System.out.println(String.format("1%s = $%s", rate.getUnits()[unit1Rate], rate.getUnits()[unit2Rate]));
        System.out.println(String.format("%s",betweenRate));
        Question question = new Question();
        question.setQuestion(String.format("1%s = $%s", rate.getUnits()[unit1Rate], rate.getUnits()[unit2Rate]));
        question.setAnswer(Arrays.asList(String.format("%s", betweenRate)));
        return question;
    }

    public static void main(String[] args) {
        MeasureGenerator generator = new MeasureGenerator();
        for (int i = 0; i < 100; i++)
            generator.randomOne();
    }
}
