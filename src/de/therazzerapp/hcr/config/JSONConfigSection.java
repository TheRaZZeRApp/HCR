package de.therazzerapp.hcr.config;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <description>
 *
 * @author The RaZZeR App <rezzer101@googlemail.com; e-mail@therazzerapp.de>
 * @author ar56te876mis <ar56te876mis@yahoo.de>
 * @since <version>
 */
public class JSONConfigSection {
    private final JsonObject object;

    public JSONConfigSection(JsonObject object) {
        this.object = object;
    }


    public String getString(String name) {
        return getString(name, null);
    }


    public String getString(String name, String def) {
        try {
            return object.getAsJsonPrimitive(name).getAsString();
        } catch (Exception e) {
        }
        return def;
    }


    public String[] getStringArray(String name) {
        List<String> values = new ArrayList<>();
        if (object.has(name)) {
            if (object.get(name).isJsonArray()) {
                for (JsonElement jsonElement : object.getAsJsonArray(name)) {
                    if (jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isString()) {
                        values.add(jsonElement.getAsString());
                    }
                }
            }
        }
        return values.toArray(new String[0]);
    }


    public String getAsString(String name) {
        return null;
    }


    public String getAsString(String name, String def) {
        return null;
    }


    public byte getByte(String name) {
        return getByte(name, (byte) 0);
    }


    public byte getByte(String name, byte def) {
        try {
            return object.getAsJsonPrimitive(name).getAsByte();
        } catch (Exception e) {
        }
        return def;
    }


    public byte[] getByteArray(String name) {
        List<Byte> values = new ArrayList<>();
        if (object.has(name)) {
            if (object.get(name).isJsonArray()) {
                for (JsonElement jsonElement : object.getAsJsonArray(name)) {
                    if (jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isNumber()) {
                        values.add(jsonElement.getAsByte());
                    }
                }
            }
        }
        byte[] array = new byte[values.size()];
        for (int i = 0; i < values.size(); i++) {
            array[i] = values.get(i);
        }
        return array;
    }


    public short getShort(String name) {
        return getShort(name, (short) 0);
    }


    public short getShort(String name, short def) {
        try {
            return object.getAsJsonPrimitive(name).getAsShort();
        } catch (Exception e) {
        }
        return def;
    }


    public short[] getShortArray(String name) {
        List<Short> values = new ArrayList<>();
        if (object.has(name)) {
            if (object.get(name).isJsonArray()) {
                for (JsonElement jsonElement : object.getAsJsonArray(name)) {
                    if (jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isNumber()) {
                        values.add(jsonElement.getAsShort());
                    }
                }
            }
        }
        short[] array = new short[values.size()];
        for (int i = 0; i < values.size(); i++) {
            array[i] = values.get(i);
        }
        return array;
    }


    public int getInt(String name) {
        return getInt(name, 0);
    }


    public int getInt(String name, int def) {
        try {
            return object.getAsJsonPrimitive(name).getAsInt();
        } catch (Exception e) {
        }
        return def;
    }


    public int[] getIntArray(String name) {
        List<Integer> values = new ArrayList<>();
        if (object.has(name)) {
            if (object.get(name).isJsonArray()) {
                for (JsonElement jsonElement : object.getAsJsonArray(name)) {
                    if (jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isNumber()) {
                        values.add(jsonElement.getAsInt());
                    }
                }
            }
        }
        int[] array = new int[values.size()];
        for (int i = 0; i < values.size(); i++) {
            array[i] = values.get(i);
        }
        return array;
    }


    public long getLong(String name) {
        return getLong(name, 0);
    }


    public long getLong(String name, long def) {
        try {
            return object.getAsJsonPrimitive(name).getAsLong();
        } catch (Exception e) {
        }
        return def;
    }


    public long[] getLongArray(String name) {
        List<Long> values = new ArrayList<>();
        if (object.has(name)) {
            if (object.get(name).isJsonArray()) {
                for (JsonElement jsonElement : object.getAsJsonArray(name)) {
                    if (jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isNumber()) {
                        values.add(jsonElement.getAsLong());
                    }
                }
            }
        }
        long[] array = new long[values.size()];
        for (int i = 0; i < values.size(); i++) {
            array[i] = values.get(i);
        }
        return array;
    }


    public float getFloat(String name) {
        return getFloat(name, 0);
    }


    public float getFloat(String name, float def) {
        try {
            return object.getAsJsonPrimitive(name).getAsFloat();
        } catch (Exception e) {
        }
        return def;
    }


    public float[] getFloatArray(String name) {
        List<Float> values = new ArrayList<>();
        if (object.has(name)) {
            if (object.get(name).isJsonArray()) {
                for (JsonElement jsonElement : object.getAsJsonArray(name)) {
                    if (jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isNumber()) {
                        values.add(jsonElement.getAsFloat());
                    }
                }
            }
        }
        float[] array = new float[values.size()];
        for (int i = 0; i < values.size(); i++) {
            array[i] = values.get(i);
        }
        return array;
    }


    public double getDouble(String name) {
        return getDouble(name, 0);
    }


    public double getDouble(String name, double def) {
        try {
            return object.getAsJsonPrimitive(name).getAsDouble();
        } catch (Exception e) {
        }
        return def;
    }


    public double[] getDoubleArray(String name) {
        List<Double> values = new ArrayList<>();
        if (object.has(name)) {
            if (object.get(name).isJsonArray()) {
                for (JsonElement jsonElement : object.getAsJsonArray(name)) {
                    if (jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isNumber()) {
                        values.add(jsonElement.getAsDouble());
                    }
                }
            }
        }
        double[] array = new double[values.size()];
        for (int i = 0; i < values.size(); i++) {
            array[i] = values.get(i);
        }
        return array;
    }


    public boolean getBoolean(String name) {
        return getBoolean(name, false);
    }


    public boolean getBoolean(String name, boolean def) {
        try {
            return object.getAsJsonPrimitive(name).getAsBoolean();
        } catch (Exception e) {
        }
        return def;
    }


    public boolean[] getBooleanArray(String name) {
        List<Boolean> values = new ArrayList<>();
        if (object.has(name)) {
            if (object.get(name).isJsonArray()) {
                for (JsonElement jsonElement : object.getAsJsonArray(name)) {
                    if (jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isBoolean()) {
                        values.add(jsonElement.getAsBoolean());
                    }
                }
            }
        }
        boolean[] array = new boolean[values.size()];
        for (int i = 0; i < values.size(); i++) {
            array[i] = values.get(i);
        }
        return array;
    }


    public JSONConfigSection getConfigSection(String name) {
        if (object.has(name)) {
            if (object.get(name).isJsonObject()) {
                return new JSONConfigSection(object.getAsJsonObject(name));
            } else {
                return null;
            }
        } else {
            JsonObject cs = new JsonObject();
            object.add(name, cs);
            return new JSONConfigSection(cs);
        }
    }


    public JSONConfigSection[] getConfigSectionArray(String name) {
        List<JSONConfigSection> values = new ArrayList<>();
        if (object.has(name)) {
            if (object.get(name).isJsonArray()) {
                for (JsonElement jsonElement : object.getAsJsonArray(name)) {
                    if (jsonElement.isJsonObject()) {
                        values.add(new JSONConfigSection(jsonElement.getAsJsonObject()));
                    }
                }
            }
        }
        return values.toArray(new JSONConfigSection[0]);
    }


    public void setString(String name, String value) {
        object.addProperty(name, value);
    }


    public void setStringArray(String name, String[] values) {
        JsonArray array = new JsonArray();
        for (String value : values) {
            array.add(new JsonPrimitive(value));
        }
        object.add(name, array);
    }


    public void setByte(String name, byte value) {
        object.addProperty(name, value);
    }


    public void setByteArray(String name, byte[] values) {
        JsonArray array = new JsonArray();
        for (byte value : values) {
            array.add(new JsonPrimitive(value));
        }
        object.add(name, array);
    }


    public void setShort(String name, short value) {
        object.addProperty(name, value);
    }


    public void setShortArray(String name, short[] values) {
        JsonArray array = new JsonArray();
        for (short value : values) {
            array.add(new JsonPrimitive(value));
        }
        object.add(name, array);
    }


    public void setInt(String name, int value) {
        object.addProperty(name, value);
    }


    public void setIntArray(String name, int[] values) {
        JsonArray array = new JsonArray();
        for (int value : values) {
            array.add(new JsonPrimitive(value));
        }
        object.add(name, array);
    }


    public void setLong(String name, long value) {
        object.addProperty(name, value);
    }

    public void setLongArray(String name, long[] values) {
        JsonArray array = new JsonArray();
        for (long value : values) {
            array.add(new JsonPrimitive(value));
        }
        object.add(name, array);
    }

    public void setFloat(String name, float value) {
        object.addProperty(name, value);
    }

    public void setFloatArray(String name, float[] values) {
        JsonArray array = new JsonArray();
        for (float value : values) {
            array.add(new JsonPrimitive(value));
        }
        object.add(name, array);
    }

    public void setDouble(String name, double value) {
        object.addProperty(name, value);
    }

    public void setDoubleArray(String name, double[] values) {
        JsonArray array = new JsonArray();
        for (double value : values) {
            array.add(new JsonPrimitive(value));
        }
        object.add(name, array);
    }

    public void setBoolean(String name, boolean value) {
        object.addProperty(name, value);
    }

    public void setBooleanArray(String name, boolean[] values) {
        JsonArray array = new JsonArray();
        for (boolean value : values) {
            array.add(new JsonPrimitive(value));
        }
        object.add(name, array);
    }


    public JSONConfigSection addConfigSectionArrayEntry(String name) {
        JsonArray array;
        if (object.has(name)) {
            if (object.get(name).isJsonArray()) {
                array = object.getAsJsonArray(name);
            } else {
                return null;
            }
        } else {
            array = new JsonArray();
            object.add(name, array);
        }

        JsonObject jsonObject = new JsonObject();
        array.add(jsonObject);
        return new JSONConfigSection(jsonObject);
    }


    public boolean has(String name) {
        return object.has(name);
    }


    public void remove(String name) {
        object.remove(name);
    }


    public void clear() {
        for (Map.Entry<String, JsonElement> entrySet : object.entrySet()) {
            object.remove(entrySet.getKey());
        }
    }


    public boolean isEmpty() { //ja ist noch nicht richtig
        return object == null;
    }

    public JsonObject getObject() {
        return object;
    }
}
