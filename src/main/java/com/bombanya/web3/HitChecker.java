package com.bombanya.web3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class HitChecker {

    private final int[] radii = new int[] {1, 2, 3, 4, 5};
    private ResultsListManager listManager;
    private LocalizationBean localizationBean;

    private int r = 1;
    private int sliderX = 0;
    private Double x = 0.0;
    private Double y;
    private Boolean boolResult;
    private String lastResult;
    private boolean iceBypass = false;

    public void setR(int r) {
        this.r = r;
    }

    public void setSliderX(int sliderX) {
        this.sliderX = sliderX;
        this.x = (double)sliderX;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public void setBoolResult(Boolean boolResult) {
        this.boolResult = boolResult;
    }

    public int getR() {
        return r;
    }

    public int[] getRadii() {
        return radii;
    }

    public int getSliderX() {
        return sliderX;
    }

    public Double getY() {
        return y;
    }

    public Double getX() {
        return x;
    }

    public Boolean getBoolResult() {
        return boolResult;
    }

    public String getLastResult() {
        return lastResult;
    }

    public void setLastResult(String lastResult) {
        this.lastResult = lastResult;
    }

    public ResultsListManager getListManager() {
        return listManager;
    }

    public void setListManager(ResultsListManager listManager) {
        this.listManager = listManager;
    }

    public boolean isIceBypass() {
        return iceBypass;
    }

    public void setIceBypass(boolean iceBypass) {
        this.iceBypass = iceBypass;
    }

    public LocalizationBean getLocalizationBean() {
        return localizationBean;
    }

    public void setLocalizationBean(LocalizationBean localizationBean) {
        this.localizationBean = localizationBean;
    }

    public void checkHit(){
        long start = System.nanoTime();
        TableRow newRow = new TableRow();

        String timeOfRequest = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT, FormatStyle.SHORT)
                .withLocale(new Locale(localizationBean.getLanguage(), localizationBean.getCountry()))
                .format(LocalDateTime.now());
        newRow.setTimeOfRequest(timeOfRequest);

        newRow.setX(x);
        newRow.setR(r);
        newRow.setY(y);

        String result;
        boolean boolResult;
        if ((x >= 0 && y >= 0 && x <= r && y <= r) ||
                (x >= 0 && y <= 0 && (x*x + y*y <= r*r/4.0)) ||
                (x <= 0 && y <= 0 && (y >= -2 * x - r))) {
            result = localizationBean.getHitMessage();
            boolResult = true;
        } else {
            result = localizationBean.getNoHitMessage();
            boolResult = false;
        }

        newRow.setResult(result);
        lastResult = result;
        this.boolResult = boolResult;
        newRow.setBoolResult(boolResult);

        double workTime = ((double) (System.nanoTime() - start)) / Math.pow(10, 9);
        newRow.setWorkTime(String.format("%.2g", workTime));

        listManager.addNewRow(newRow);

        iceBypass = true;
    }

}
