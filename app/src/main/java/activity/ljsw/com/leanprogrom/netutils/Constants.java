package activity.ljsw.com.leanprogrom.netutils;

/**
 * Created by lianchao on 2019/11/12.
 * <p>
 * 网络请请求的总url 的工具类
 */

public class Constants {


    public static final int NET_ERROR = 0x0001;
    public static final int NET_OK = 0x0002;
    public static final int RESPONSE_ERROR = 0x0004;
    public static final int RESPONSE_OK = 0x0008;
    public static final int RESPONSE_SPINNER_OK = 0x0011;
    public static final int RESPONSE_LIST_OK = 0x0012;
    public static final int RESPONSE_FIRST_OK = 0x0111;
    public static final int RESPONSE_SECOND_OK = 0x0112;
    public static final int RESPONSE_THIRD_OK = 0x0114;
    public static final int RESPONSE_SUCCESS = 0x0009;
    public static final int SCANRESULT = 0x00010;

//    public static final String URl = "http://192.168.1.131:8880";//自己
//        public static final String URl = "http://192.168.1.240/api";//公司

    //    public static final String URl =  "http://120.234.23.250:8005";//公司
//    public static final String URl = "http://docker.poka.net.cn:8880";//公司  PC端

    public static final String URL = "http://192.168.160.:8888";//公司  移动端

    //    http://localhost:8888
    //    8004 是PC端的页面面接口
//    http://172.16.3.1:8880/swagger-ui.html#/
    public static final String login = URL + "/token";  //获取token
    public static final String loginpost = URL + "/pplogin";  //获取token
    public static final String getMenum = URL + "/Getmaplist";//获取菜单// 的url
    public static final String Regin = URL + "/regin";  //获取token

}
