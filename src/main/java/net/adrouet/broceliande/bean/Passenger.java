package net.adrouet.broceliande.bean;

import net.adrouet.broceliande.data.Feature;
import net.adrouet.broceliande.data.Target;

public class Passenger {

    private Integer passengerId;
    private Integer survived;
    private Integer pclass;
    private String name;
    private String sex;
    private Integer age;
    private Integer sibSp;
    private Integer parch;
    private String ticket;
    private Double fare;
    private String cabin;
    private String embarked;


    public Integer getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Integer passengerId) {
        this.passengerId = passengerId;
    }

    @Target
    public Integer getSurvived() {
        return survived;
    }

    public void setSurvived(Integer survived) {
        this.survived = survived;
    }

    @Feature
    public Integer getPclass() {
        return pclass;
    }

    public void setPclass(Integer pclass) {
        this.pclass = pclass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Feature
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Feature
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Feature
    public Integer getSibSp() {
        return sibSp;
    }

    public void setSibSp(Integer sibSp) {
        this.sibSp = sibSp;
    }

    @Feature
    public Integer getParch() {
        return parch;
    }

    public void setParch(Integer parch) {
        this.parch = parch;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Double getFare() {
        return fare;
    }

    public void setFare(Double fare) {
        this.fare = fare;
    }

    public String getCabin() {
        return cabin;
    }

    public void setCabin(String cabin) {
        this.cabin = cabin;
    }

    @Feature
    public String getEmbarked() {
        return embarked;
    }

    public void setEmbarked(String embarked) {
        this.embarked = embarked;
    }
}