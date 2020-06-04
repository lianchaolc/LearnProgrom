package activity.ljsw.com.leanprogrom;

import android.app.Application;

import activity.ljsw.com.leanprogrom.bean.RLoginResultX;

/**
 * Created by lianchao on 2020/6/4.
 */

public class MyApplication  extends Application{
    public RLoginResultX mRLoginResult;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public void setRLoginResult(RLoginResultX bean) {
        mRLoginResult=bean;
    }
}
