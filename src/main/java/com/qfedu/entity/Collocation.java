package com.qfedu.entity;

import com.qfedu.util.TimeFormatUtils;

import java.util.Date;

public class Collocation {
    private int id;
    private int viewsTimes;
    private String collocationImg;
    private String collocationName;
    private String collocationDetail;
    private Date time;
    private int designerId;
    private String showTime;
    private String collocationGoods;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getViewsTimes() {
        return viewsTimes;
    }

    public void setViewsTimes(int viewsTimes) {
        this.viewsTimes = viewsTimes;
    }

    public String getShowTime() {
        return TimeFormatUtils.getFormateTimes(time);
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public String getCollocationImg() {
        return collocationImg;
    }

    public void setCollocationImg(String collocationImg) {
        this.collocationImg = collocationImg;
    }

    public String getCollocationName() {
        return collocationName;
    }

    public void setCollocationName(String collocationName) {
        this.collocationName = collocationName;
    }

    public String getCollocationDetail() {
        return collocationDetail;
    }

    public void setCollocationDetail(String collocationDetail) {
        this.collocationDetail = collocationDetail;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getDesignerId() {
        return designerId;
    }

    public void setDesignerId(int designerId) {
        this.designerId = designerId;
    }

    public String getCollocationGoods() {
        return collocationGoods;
    }

    public void setCollocationGoods(String collocationGoods) {
        this.collocationGoods = collocationGoods;
    }
}
