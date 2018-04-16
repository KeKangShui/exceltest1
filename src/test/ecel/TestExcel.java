package ecel;

import java.io.IOException;

/**
 * Created by ASUS on 2018/4/15.
 */
public class TestExcel {
    public static void main(String[] args) {
        try {
            ReadExcel.read();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
