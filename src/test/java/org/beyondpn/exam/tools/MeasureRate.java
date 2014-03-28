package org.beyondpn.exam.tools;

/**
 * Created with IntelliJ IDEA.
 *
 * @author beyondpn
 *         Create: 14-3-26 下午11:09
 */
public class MeasureRate {

    private String[] units;

    private int rate;

    public MeasureRate(String[] units, int rate) {
        this.units = units;
        this.rate = rate;
    }

    public String[] getUnits() {
        return units;
    }

    public void setUnits(String[] units) {
        this.units = units;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
