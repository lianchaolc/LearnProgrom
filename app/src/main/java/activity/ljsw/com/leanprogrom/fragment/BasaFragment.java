package activity.ljsw.com.leanprogrom.fragment;

/**
 * Created by lianchao on 2020/5/19.
 */

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import activity.ljsw.com.leanprogrom.base.BaseController;
import activity.ljsw.com.leanprogrom.viewutils.IModeChaneListener;

/***
 * fragment 的基本类
 */
public abstract class BasaFragment  extends Fragment implements IModeChaneListener {

    protected BaseController mController;
    protected Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            handlerMessage(msg);
        }
    };
    public View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = initView(inflater);
        return view;

    }

    protected void initData() {

    }

    protected void handlerMessage(Message msg) {
    }


    @Override
    public void onModeChaned(int action, Object... values) {
        mHandler.obtainMessage(action, values[0]).sendToTarget();
    }

    public abstract View initView(LayoutInflater inflater);
}