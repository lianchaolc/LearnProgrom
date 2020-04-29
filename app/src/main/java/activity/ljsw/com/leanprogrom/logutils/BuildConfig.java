package activity.ljsw.com.leanprogrom.logutils;

import android.util.Log;

/**
 * Created by lianchao on 2020/4/29.
 */

public final class BuildConfig {
    public static final boolean DEBUG = Boolean.parseBoolean("true");
    public static final String APPLICATION_ID = "com.yifeng.sample";
    public static final String BUILD_TYPE = "debug";
    public static final String FLAVOR = "";
    public static final int VERSION_CODE = 1;
    public static final String VERSION_NAME = "1.0";

    public static final Boolean DEBUG_MODE = true;

    public static void d(String message) {
        if (DEBUG_MODE) {
            Log.d("TAG", message);
        }
    }
}
