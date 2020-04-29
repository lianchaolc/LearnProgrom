package activity.ljsw.com.leanprogrom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import activity.ljsw.com.leanprogrom.netutils.CallBackUtil;
import activity.ljsw.com.leanprogrom.netutils.Constants;
import activity.ljsw.com.leanprogrom.netutils.OkhttpUtil;
import activity.ljsw.com.leanprogrom.netutils.ToastUtils;
import activity.ljsw.com.leanprogrom.widget.PhoenixToolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final Boolean DEBUG_MODE = true;
    private TextView tvmanCodeScanner;//  二维码扫面描
    @BindView(R.id.main_et)
    EditText editText;
    @BindView(R.id.main_et_password)
    EditText editTextPassWord;
    @BindView(R.id.toolbar)
    PhoenixToolbar mToolBar;
    private String userName;//
    private String userPassWord;///
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        tvmanCodeScanner = (TextView) findViewById(R.id.tvmanCodeScanner);
        initView();

    }

    /***
     * 组件
     */
    private void initView() {
        userName = editText.getText().toString().trim();
        userPassWord = editTextPassWord.toString().trim();
        mToolBar.setLeftButtonClickListener(this);
        mToolBar.setRightButtonClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvmanCodeScanner:

                break;

            case R.id.toolbar_leftButton:
                finish();
                break;
            case R.id.toolbar_rightButton:
                getCode();
                Toast.makeText(MainActivity.this, "11111", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void getCode() {
        Map<String, String> reginpostmap = new HashMap<String, String>();
        reginpostmap.put("username", userName);
        reginpostmap.put("password", userPassWord);
        OkhttpUtil.okHttpPost(Constants.Regin, reginpostmap, new CallBackUtil() {
            @Override
            public Object onParseResponse(Call call, Response response) {
                try {
                    String netresult = response.body().string();
                    if(DEBUG_MODE){
                        Log.d("Mainactivity",""+netresult);
                    }
                    Logger.getLogger("控制log"+netresult);
                    return netresult;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            public void onFailure(Call call, Exception e) {
                ToastUtils.show(MainActivity.this,"注册失败");
            }

            @Override
            public void onResponse(Object response) {
                String result = response.toString();

            }
        });

    }

}
