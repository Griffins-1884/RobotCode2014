package org.usfirst.frc0.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.microedition.io.Connector;

import org.json.me.JSONException;
import org.json.me.JSONObject;
import org.json.me.JSONTokener;

import com.sun.squawk.io.BufferedReader;
import com.sun.squawk.microedition.io.FileConnection;
import org.json.me.JSONArray;

public class FileIO {

    private static int previousHash = -1;

    public static String getFileContents(String filename) {
        String url = "file:///" + filename;
        StringBuffer contents = new StringBuffer();
        try {
            FileConnection c = (FileConnection) Connector.open(url);
            BufferedReader buf = new BufferedReader(new InputStreamReader(c.openInputStream()));
            int character = 0, hash = 17;
            while ((character = buf.read()) != -1) {
                contents.append(character);
                hash = 37 * hash + character;
            }
            c.close();
            if (hash == previousHash) {
                return null;
            }
            previousHash = hash;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contents.toString();
    }

    public static JSONObject fromJSONFileAsObject(String filename) {
        try {
            return new JSONObject(new JSONTokener(getFileContents(filename)));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static JSONArray fromJSONFileAsArray(String filename) {
        try {
            String fileContentsString = getFileContents(filename);
            if (fileContentsString == null) {
                return null;
            }
            return new JSONArray(new JSONTokener(fileContentsString));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void writeToFile(String filename, String contents) {
        String url = "file:///" + filename;
        try {
            FileConnection c = (FileConnection) Connector.open(url);
            OutputStreamWriter writer = new OutputStreamWriter(c
                    .openOutputStream());
            writer.write(contents);
            c.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
