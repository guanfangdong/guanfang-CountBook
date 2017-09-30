package com.example.counter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by guanfang on 2017/9/22.
 */

public class EachActivity {
    private String name;
    private String date;
    private int currentValue;
    private int initValue;
    private String comment;

    public EachActivity(String name, int currentValue, int initValue, String comment) {
        super();
        this.name = name;
        this.date = setDate();
        this.currentValue=currentValue;
        this.initValue=initValue;
        this.comment = comment;
    }


    public void setName(String whatName){
        this.name=whatName;
    }
    public String getName(){
        return this.name;
    }

    public String setDate(){
        Date initDate= new Date();
        DateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
        this.date=ft.format(initDate);
        return ft.format(initDate);
    }

    public String getDate(){
        return date;
    }

    public void plus(){
        this.currentValue=this.currentValue+1;
    }

    public void reset(){
        this.currentValue=this.initValue;
    }

    public void minus(){
        if (this.currentValue>0){
            this.currentValue=this.currentValue-1;}
    }


    public int getCurrentValue(){
        return this.currentValue;
    }

    public void setCount(int count){
        this.currentValue = count;
    }

    public int getInitValue(){
        return this.initValue;
    }

    public void setComment(String comment){
        this.comment=comment;
    }

    public String getComment(){
        return this.comment;
    }

    @Override
    public String toString(){
        return "Name: "+name+"\n"+"Date: "+date+"\n"+"Count: "+currentValue;
    }
}
