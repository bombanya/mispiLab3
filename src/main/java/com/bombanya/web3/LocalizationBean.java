package com.bombanya.web3;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocalizationBean {
    private String language = "ru";
    private String country = "RU";

    private String name;
    private String group;
    private String variant;
    private String mainPage;

    private String startPage;
    private String radius;
    private String coordX;
    private String coordY;
    private String coordYPlaceholder;
    private String requiredMessage;
    private String validatorMessage;
    private String formButtonValue;
    private String mouseCoordsPlaceholder;
    private String timeOfRequestHeader;
    private String workTimeHeader;
    private String resultHeader;

    private String hitMessage;
    private String noHitMessage;
    private String checkerInitMessage;

    public void localize(){
        Locale currentLocale = new Locale(language, country);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("web3Resources", currentLocale);
        name = resourceBundle.getString("name");
        group = resourceBundle.getString("group");
        variant = resourceBundle.getString("variant");
        mainPage = resourceBundle.getString("mainPage");

        startPage = resourceBundle.getString("startPage");
        radius = resourceBundle.getString("radius");
        coordX = resourceBundle.getString("coordX");
        coordY = resourceBundle.getString("coordY");
        coordYPlaceholder = resourceBundle.getString("coordYPlaceholder");
        requiredMessage = resourceBundle.getString("requiredMessage");
        validatorMessage = resourceBundle.getString("validatorMessage");
        formButtonValue = resourceBundle.getString("formButtonValue");
        mouseCoordsPlaceholder = resourceBundle.getString("mouseCoordsPlaceholder");
        timeOfRequestHeader = resourceBundle.getString("timeOfRequestHeader");
        workTimeHeader = resourceBundle.getString("workTimeHeader");
        resultHeader = resourceBundle.getString("resultHeader");
        hitMessage = resourceBundle.getString("hitMessage");
        noHitMessage = resourceBundle.getString("noHitMessage");
        checkerInitMessage = resourceBundle.getString("checkerInitMessage");
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
        localize();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
        localize();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public String getMainPage() {
        return mainPage;
    }

    public void setMainPage(String mainPage) {
        this.mainPage = mainPage;
    }

    public String getStartPage() {
        return startPage;
    }

    public void setStartPage(String startPage) {
        this.startPage = startPage;
    }

    public String getRadius() {
        return radius;
    }

    public void setRadius(String radius) {
        this.radius = radius;
    }

    public String getCoordX() {
        return coordX;
    }

    public void setCoordX(String coordX) {
        this.coordX = coordX;
    }

    public String getCoordY() {
        return coordY;
    }

    public void setCoordY(String coordY) {
        this.coordY = coordY;
    }

    public String getCoordYPlaceholder() {
        return coordYPlaceholder;
    }

    public void setCoordYPlaceholder(String coordYPlaceholder) {
        this.coordYPlaceholder = coordYPlaceholder;
    }

    public String getRequiredMessage() {
        return requiredMessage;
    }

    public void setRequiredMessage(String requiredMessage) {
        this.requiredMessage = requiredMessage;
    }

    public String getValidatorMessage() {
        return validatorMessage;
    }

    public void setValidatorMessage(String validatorMessage) {
        this.validatorMessage = validatorMessage;
    }

    public String getFormButtonValue() {
        return formButtonValue;
    }

    public void setFormButtonValue(String formButtonValue) {
        this.formButtonValue = formButtonValue;
    }

    public String getMouseCoordsPlaceholder() {
        return mouseCoordsPlaceholder;
    }

    public void setMouseCoordsPlaceholder(String mouseCoordsPlaceholder) {
        this.mouseCoordsPlaceholder = mouseCoordsPlaceholder;
    }

    public String getTimeOfRequestHeader() {
        return timeOfRequestHeader;
    }

    public void setTimeOfRequestHeader(String timeOfRequestHeader) {
        this.timeOfRequestHeader = timeOfRequestHeader;
    }

    public String getWorkTimeHeader() {
        return workTimeHeader;
    }

    public void setWorkTimeHeader(String workTimeHeader) {
        this.workTimeHeader = workTimeHeader;
    }

    public String getResultHeader() {
        return resultHeader;
    }

    public void setResultHeader(String resultHeader) {
        this.resultHeader = resultHeader;
    }

    public String getHitMessage() {
        return hitMessage;
    }

    public void setHitMessage(String hitMessage) {
        this.hitMessage = hitMessage;
    }

    public String getNoHitMessage() {
        return noHitMessage;
    }

    public void setNoHitMessage(String noHitMessage) {
        this.noHitMessage = noHitMessage;
    }

    public String getCheckerInitMessage() {
        return checkerInitMessage;
    }

    public void setCheckerInitMessage(String checkerInitMessage) {
        this.checkerInitMessage = checkerInitMessage;
    }
}
