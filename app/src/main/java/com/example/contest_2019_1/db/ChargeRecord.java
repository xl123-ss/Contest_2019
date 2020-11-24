package com.example.contest_2019_1.db;

import org.litepal.crud.DataSupport;

public class ChargeRecord extends DataSupport {

    private int id;
    private String carNO;
    private String charge;
    private String date;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarNO() {
        return carNO;
    }

    public void setCarNO(String carNO) {
        this.carNO = carNO;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
