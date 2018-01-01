package us.mifeng.actionbar.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by 黑夜之火 on 2018/1/1.
 */

public class ToastUtils {
    //Toast连续点击处理
    private static Toast toast;
    public static void ToastShow(Context context,String str){
        if (toast == null){
            toast = Toast.makeText(context,str,Toast.LENGTH_SHORT);
        }
        toast.setText(str);
        toast.show();
    }
}
