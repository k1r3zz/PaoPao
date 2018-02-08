package com.user.paopao.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.user.paopao.MyApplication;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.Set;

import static android.provider.Telephony.Mms.Part.FILENAME;

/**
 * author：lily
 * date：2017/12/11 10:00
 * description: 数据缓存类
 */
public class SharePrefrencesUtil {

    static SharePrefrencesUtil mInstance;
    static final String SP_NAME = "weyoo";
    private SharedPreferences sp;

    private SharePrefrencesUtil() {
        sp = MyApplication.getInstance().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
    }

    public static SharePrefrencesUtil getInstance() {
        if (mInstance == null) {
            mInstance = new SharePrefrencesUtil();
        }
        return mInstance;
    }

    public void putString(String key, String value) {
        Editor edit = sp.edit();
        edit.putString(key, value);
        edit.apply();
    }

    public void putInt(String key, int value) {
        Editor edit = sp.edit();
        edit.putInt(key, value);
        edit.apply();
    }

    public void putBoolean(String key, boolean value) {
        Editor edit = sp.edit();
        edit.putBoolean(key, value);
        edit.apply();
    }

    public void removeObject(String key) {
        Editor edit = sp.edit();
        edit.remove(key);
        edit.apply();
    }

    public void putLong(String key, long value) {
        Editor edit = sp.edit();
        edit.putLong(key, value);
        edit.apply();
    }

    public void putFloat(String key, float value) {
        Editor edit = sp.edit();
        edit.putFloat(key, value);
        edit.apply();
    }

    public void putSet(String key, Set<String> value) {
        Editor edit = sp.edit();
        edit.putStringSet(key, value);
        edit.apply();
    }

    public String getString(String key) {
        return sp.getString(key, "");
    }

    public int getInt(String key) {
        return sp.getInt(key, -1);
    }

    public long getLong(String key) {
        return sp.getLong(key, -1);
    }

    public float getFloat(String key) {
        return sp.getFloat(key, -1);
    }

    public boolean getBoolean(String key) {
        return sp.getBoolean(key, false);
    }

    public Set<String> getSet(String key) {
        return sp.getStringSet(key, null);
    }

    public void celars() {
        Editor edit = sp.edit();
        edit.clear();
        edit.apply();
    }

    public void setIsFirst(boolean isFirst) {
        sp.edit().putBoolean(SP_NAME + ".isFirst", isFirst).commit();
    }

    public boolean getIsFirst() {
        return sp.getBoolean(SP_NAME + ".isFirst", true);
    }

    /**
     * desc:保存对象
     *
     * @param key
     * @param obj     要保存的对象，只能保存实现了serializable的对象
     *                modified:
     */
    public static void saveObject(String key, Object obj) {
        try {
            // 保存对象
            Editor sharedata = MyApplication.getInstance().getSharedPreferences(FILENAME, 0).edit();
            //先将序列化结果写到byte缓存中，其实就分配一个内存空间
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream os = new ObjectOutputStream(bos);
            //将对象序列化写入byte缓存
            os.writeObject(obj);
            //将序列化的数据转为16进制保存
            String bytesToHexString = bytesToHexString(bos.toByteArray());
            //保存该16进制数组
            sharedata.putString(key, bytesToHexString);
            sharedata.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * desc:将数组转为16进制
     *
     * @param bArray
     * @return modified:
     */
    public static String bytesToHexString(byte[] bArray) {
        if (bArray == null) {
            return null;
        }
        if (bArray.length == 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer(bArray.length);
        String sTemp;
        for (int i = 0; i < bArray.length; i++) {
            sTemp = Integer.toHexString(0xFF & bArray[i]);
            if (sTemp.length() < 2)
                sb.append(0);
            sb.append(sTemp.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * desc:获取保存的Object对象
     *
     * @param key
     * @return modified:
     */
    public static Object getObject(String key) {
        try {
            SharedPreferences sharedata = MyApplication.getInstance().getSharedPreferences(FILENAME, 0);
            if (sharedata.contains(key)) {
                String string = sharedata.getString(key, "");
                if (TextUtils.isEmpty(string)) {
                    return null;
                } else {
                    //将16进制的数据转为数组，准备反序列化
                    byte[] stringToBytes = StringToBytes(string);
                    ByteArrayInputStream bis = new ByteArrayInputStream(stringToBytes);
                    ObjectInputStream is = new ObjectInputStream(bis);
                    //返回反序列化得到的对象
                    Object readObject = is.readObject();
                    return readObject;
                }
            }
        } catch (StreamCorruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //所有异常返回null
        return null;

    }

    /**
     * desc:将16进制的数据转为数组
     * <p>创建人：聂旭阳 , 2014-5-25 上午11:08:33</p>
     *
     * @param data
     * @return modified:
     */
    public static byte[] StringToBytes(String data) {
        String hexString = data.toUpperCase().trim();
        if (hexString.length() % 2 != 0) {
            return null;
        }
        byte[] retData = new byte[hexString.length() / 2];
        for (int i = 0; i < hexString.length(); i++) {
            int int_ch;  // 两位16进制数转化后的10进制数
            char hex_char1 = hexString.charAt(i); ////两位16进制数中的第一位(高位*16)
            int int_ch3;
            if (hex_char1 >= '0' && hex_char1 <= '9')
                int_ch3 = (hex_char1 - 48) * 16;   //// 0 的Ascll - 48
            else if (hex_char1 >= 'A' && hex_char1 <= 'F')
                int_ch3 = (hex_char1 - 55) * 16; //// A 的Ascll - 65
            else
                return null;
            i++;
            char hex_char2 = hexString.charAt(i); ///两位16进制数中的第二位(低位)
            int int_ch4;
            if (hex_char2 >= '0' && hex_char2 <= '9')
                int_ch4 = (hex_char2 - 48); //// 0 的Ascll - 48
            else if (hex_char2 >= 'A' && hex_char2 <= 'F')
                int_ch4 = hex_char2 - 55; //// A 的Ascll - 65
            else
                return null;
            int_ch = int_ch3 + int_ch4;
            retData[i / 2] = (byte) int_ch;//将转化后的数放入Byte里
        }
        return retData;
    }
}
