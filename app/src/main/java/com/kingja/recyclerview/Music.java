package com.kingja.recyclerview;

/**
 * Description:TODO
 * Create Time:2017/4/14 15:08
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class Music {
    private String musicName;
    private String musicAuthor;
    private int resId;


    public String getMusicAuthor() {
        return musicAuthor;
    }

    public void setMusicAuthor(String musicAuthor) {
        this.musicAuthor = musicAuthor;
    }


    public Music(String musicName, String musicAuthor, int resId) {
        this.musicName = musicName;
        this.musicAuthor = musicAuthor;
        this.resId = resId;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public int getMusicResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

}
