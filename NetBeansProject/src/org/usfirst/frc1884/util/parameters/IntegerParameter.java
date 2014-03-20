package org.usfirst.frc1884.util.parameters;

import org.json.me.JSONException;
import org.json.me.JSONObject;

public class IntegerParameter {

    public static IntegerParameter get(String name) {
        IntegerParameter p = (IntegerParameter) ParameterFile.existingParameters.get(name);
        if (p == null) {
            p = new IntegerParameter();
            p.value = 0;
            ParameterFile.existingParameters.put(name, p);
        }
        return p;
    }

    protected static void set(JSONObject jsonParameter) throws JSONException {
        String name = jsonParameter.getString("name");
        int value = jsonParameter.getInt("value");
        Object p = get(name);
        if (p != null && p instanceof IntegerParameter) {
            ((IntegerParameter) p).value = value;
        } else {
            p = new IntegerParameter();
            ((IntegerParameter) p).value = value;
            ParameterFile.existingParameters.put(name, p);
        }
    }
    protected int value;

    public int getValue() {
        return value;
    }
}
