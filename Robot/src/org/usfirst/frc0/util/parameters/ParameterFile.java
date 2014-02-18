package org.usfirst.frc0.util.parameters;

import java.util.Hashtable;
import org.json.me.JSONArray;
import org.json.me.JSONException;
import org.json.me.JSONObject;

public class ParameterFile {

    protected static Hashtable existingParameters = new Hashtable();

    public static boolean readFile() {
        try {
            JSONArray fileContents = FileIO.fromJSONFileAsArray("parameters.json");
            if (fileContents == null) {
                return false;
            }
            for (int i = 0; i < fileContents.length(); i++) {
                JSONObject jsonParameter = fileContents.getJSONObject(i);
                String type = jsonParameter.getString("type");
                if (type.equals("double")) {
                    DoubleParameter.set(jsonParameter);
                } else if (type.equals("integer")) {
                    IntegerParameter.set(jsonParameter);
                }
            }
            return true;
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
