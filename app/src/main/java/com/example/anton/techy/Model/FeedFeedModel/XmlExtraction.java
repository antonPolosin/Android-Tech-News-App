package com.example.anton.techy.Model.FeedFeedModel;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anton on 8/12/17.
 */

public class XmlExtraction {

    private static final String TAG = "XmlExtraction";

    private String tag;

    private String xml;

    public XmlExtraction(String xml, String tag) {
        this.tag = tag;
        this.xml = xml;
    }

    public List<String> start(){
        List<String> result = new ArrayList<>();

        String [] splitXML = xml.split(tag + "\"");

        int count = splitXML.length;

        for (int i = 1; i < count; i++){
            String temp = splitXML[i];
            int index = temp.indexOf("\"");
            Log.d(TAG, "start: index; " + index);
            Log.d(TAG, "start: extracted: " + temp);
            
            temp = temp.substring(0, index);
            Log.d(TAG, "start: snipped: " + temp);

            result.add(temp);
        }


        return result;
    }
}
