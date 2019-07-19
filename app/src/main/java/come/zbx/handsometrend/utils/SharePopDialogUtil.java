package come.zbx.handsometrend.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import come.zbx.handsometrend.R;

public class SharePopDialogUtil {

    public SharePopDialogUtil() {

    }

    private Dialog dialog;// 利用android自带的dialog类

    private View dialogView;// 弹窗的内容view


    public void showDialog(Activity activity) {
        dialog = new Dialog(activity,R.style.Theme_AppCompat_NoActionBar);//创建一个dialog实例，

        dialogView = LayoutInflater.from(activity).inflate(R.layout.window_share, null);//实例化一个view作为弹窗的内容view
//        popListView = dialogView.findViewById(R.id.popListView);

        dialog.setContentView(dialogView);//设置弹窗的内容view
        dialog.setCanceledOnTouchOutside(true);//设置是否可以在窗口之外点击屏幕让弹窗消失
        dialog.setCancelable(true);//是否可以被按下back而让弹窗消失
        Window window = dialog.getWindow();//获得弹窗的 window对象
        if (window != null) {
            WindowManager.LayoutParams params = window.getAttributes();
            params.gravity = Gravity.BOTTOM;//初始化弹窗的位置，在底部
            params.width = getScreenPixelsWidth(activity);//弹窗的宽度是整个屏幕的宽度

        }

        dialog.show();//显示弹窗
    }

    /**
     * 50      * 获取屏幕的宽度，单位是像素px
     * 51      * @param activity
     * 52      * @return
     * 53
     */
    private int getScreenPixelsWidth(Context activity) {
        return activity.getResources().getDisplayMetrics().widthPixels;

    }

}
