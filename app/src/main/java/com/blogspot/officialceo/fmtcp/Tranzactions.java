package com.blogspot.officialceo.fmtcp;

public class Tranzactions {

    private String transName, transCategory, date;
    private int amount;

    public Tranzactions(){

    }

    public Tranzactions(String transName, String transCategory, int amount, String date){

        this.transName = transName;
        this.transCategory = transCategory;
        this.amount = amount;
        this.date = date;

    }



    public String getTransName() {
        return transName;
    }

    public void setTransName(String transName) {
        this.transName = transName;
    }

    public String getTransCategory() {
        return transCategory;
    }

    public void setTransCategory(String transCategory) {
        this.transCategory = transCategory;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
