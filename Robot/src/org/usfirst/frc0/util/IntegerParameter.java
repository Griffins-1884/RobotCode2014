/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.usfirst.frc0.util;

import org.json.me.JSONException;
import org.json.me.JSONObject;

/**
 *
 * @author colinpoler
 */
public class IntegerParameter {
    public static IntegerParameter get(String name) {
        IntegerParameter p = (IntegerParameter) Parameter.existingParameters.get(name);
        if(p == null) {
            p = new IntegerParameter();
            p.value = 0;
            Parameter.existingParameters.put(name, p);
        }
        return p;
    }
    protected static void set(JSONObject jsonParameter) throws JSONException {
        String name = jsonParameter.getString("name");
        int value = jsonParameter.getInt("value");
        Object p = get(name);
        if(p != null && p instanceof IntegerParameter) {
            ((IntegerParameter) p).value = value;
        } else {
            p = new IntegerParameter();
            ((IntegerParameter) p).value = value;
            Parameter.existingParameters.put(name, p);
        }
    }
    protected int value;
    public int getValue() {
        return value;
    }
}