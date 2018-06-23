package ap.gui.util;

import java.lang.reflect.Array;

public class ArrayUtils {
    public static <T> void replaceNullWithNewObject(T[] arr, Class<T> type) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                try {
                    arr[i] = type.newInstance();
                } catch (Exception e) {}
            }
        }
    }

    public static <T> void replaceNullWithNewObject(T[][] arr, Class<T> type) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                try {
                    T[] temp = (T[]) Array.newInstance(type, arr[i - 1].length);
                    ArrayUtils.replaceNullWithNewObject(temp, type);
                    arr[i] = temp;
                } catch (Exception e) {}
            } else {
                ArrayUtils.replaceNullWithNewObject(arr[i], type);
            }
        }
    }
}
