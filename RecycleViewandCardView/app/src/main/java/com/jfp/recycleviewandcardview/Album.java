package com.jfp.recycleviewandcardview;

/**
 * Created by jefferson on 3/24/2017.
 */

public class Album {
    private  String name;
    private int numofsong;
    private int thumbail;

    public Album() {

    }
    public Album(String name,int numofsong,int thumbail)
    {
        this.name=name;
        this.numofsong=numofsong;
        this.thumbail=thumbail;
    }
    public  String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }
    public int getNumofsong()
    {
        return numofsong;
    }
    public void setNumofsong(int numofsong)
    {
        this.numofsong=numofsong;
    }
    public int getThumbail()
    {
        return thumbail;
    }
    public void setThumbail(int thumbail)
    {
        this.thumbail=thumbail;
    }

}

