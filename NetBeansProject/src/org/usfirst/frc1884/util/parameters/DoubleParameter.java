package org.usfirst.frc0.util.parameters;

import org.json.me.JSONException;
import org.json.me.JSONObject;

public class DoubleParameter {

    public static DoubleParameter get(String name) {
        DoubleParameter p = (DoubleParameter) ParameterFile.existingParameters.get(name);
        if (p == null) {
            p = new DoubleParameter();
            p.value = 0;
            ParameterFile.existingParameters.put(name, p);
        }
        return p;
    }

    protected static void set(JSONObject jsonParameter) throws JSONException {
        String name = jsonParameter.getString("name");
        double value = jsonParameter.getDouble("value");
        Object p = get(name);
        if (p != null && p instanceof DoubleParameter) {
            ((DoubleParameter) p).value = value;
        } else {
            p = new DoubleParameter();
            ((DoubleParameter) p).value = value;
            ParameterFile.existingParameters.put(name, p);
        }
    }
    protected double value;

    public double getValue() {
        return value;
    }
}
