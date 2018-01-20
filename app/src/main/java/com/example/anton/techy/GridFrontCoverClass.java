package com.example.anton.techy;

/**
 * Created by anton on 16/01/18.
 */

public class GridFrontCoverClass {

    private String name;

    private String thumbnail;

    public GridFrontCoverClass() {
    }

    public GridFrontCoverClass(String name, String thumbnail) {
        this.name = name;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
