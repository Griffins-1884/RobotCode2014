/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.usfirst.frc0.util;

import com.grt192.utils.GRTFileIO;
import java.util.Hashtable;
import org.json.me.JSONArray;
import org.json.me.JSONException;
import org.json.me.JSONObject;

/**
 *
 * @author colinpoler
 */
public class Parameter {
    private static Hashtable existingParameters = new Hashtable();
    public static Parameter getParameter(String name) {
        return (Parameter) existingParameters.get(name);
    }
    public static void readFile() {
        try {
            JSONArray fileContents = GRTFileIO.fromJSONFileAsArray("parameters.json");
            for(int i = 0; i < fileContents.length(); i++) {
                JSONObject jsonParameter = fileContents.getJSONObject(i);
                String name = jsonParameter.getString("name");
                double value = jsonParameter.getDouble("value");
                System.out.println(name);
                Parameter p = getParameter(name);
                if(p != null) {
                    p.value = value;
                } else {
                    p = new Parameter();
                    p.value = value;
                    existingParameters.put(name, p);
                }
            }
        } catch(JSONException ex) {
            ex.printStackTrace();
        }
    }
    
    private double value;
    public double getValue() {
        return value;
    }
}