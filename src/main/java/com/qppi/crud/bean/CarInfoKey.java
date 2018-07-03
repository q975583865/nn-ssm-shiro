package com.qppi.crud.bean;

public class CarInfoKey {
    private String id;

    private String carnum1;

    private String carnum2;

    private String carnum3;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCarnum1() {
        return carnum1;
    }

    public void setCarnum1(String carnum1) {
        this.carnum1 = carnum1 == null ? null : carnum1.trim();
    }

    public String getCarnum2() {
        return carnum2;
    }

    public void setCarnum2(String carnum2) {
        this.carnum2 = carnum2 == null ? null : carnum2.trim();
    }

    public String getCarnum3() {
        return carnum3;
    }

    public void setCarnum3(String carnum3) {
        this.carnum3 = carnum3 == null ? null : carnum3.trim();
    }
}