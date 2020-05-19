package activity.ljsw.com.leanprogrom.base;

import android.content.Context;

import activity.ljsw.com.leanprogrom.viewutils.IModeChaneListener;

/**
 * Created by lianchao on 2020/5/19.
 */

public abstract class BaseController {
    protected Context mContext;
    protected IModeChaneListener mListener;

    public void setIModeChangeListener(IModeChaneListener listener) {
        this.mListener=listener;
    }
    public BaseController(Context ctx) {
        this.mContext = ctx;
    }

    /**
     * 一个页面可能有多个网络请求  action区别网络请求
     * values 请求的数据
     */
    public void sendAsyncMessage(final int action, final Object... values) {
        new Thread() {
            @Override
            public void run() {
                handleMessage(action, values);
            }
        }.start();
    }

    protected abstract void handleMessage(int action, Object... values);
}
