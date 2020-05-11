package activity.ljsw.com.leanprogrom.activity

import activity.ljsw.com.leanprogrom.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.yicooll.wanandroidkotlin.entity.ModelLogin
import com.yicooll.wanandroidkotlin.utils.PreferenceHelper
import kotlinx.android.synthetic.main.activity_login.*

/***
 * kotin 登陆验证代码
 */

class Login2Activity : BaseActivity() {
    //    private var vm: LoginViewModel? = null;
    override fun getContentViewLayoutId(): Int {
        return R.layout.activity_login
    }


    override fun initEvent() {
//        vm = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        //vm!!.init(et_usernmae.text.toString(), et_password.text.toString())

        tv_login.setOnClickListener {
            invalidateinfo()
        }
    }

    /***
     * 加载布局
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        invalidateinfo();
    }

    override fun initView() {
        var llMenu: LinearLayout? = getHeadMenu()
        var view: View = layoutInflater.inflate(R.layout.include_base_toolbar, llMenu)
//        var tvTitle: TextView = view.findViewById(TextView)(R.id.tv_menu_center);
        var tvTitle: TextView = findViewById(R.id.tv_menu_center) as TextView;
        tvTitle.text = "登录"

        tv_login.observer(et_usernmae, et_password)
    }

    /***
     * 判断当前组件是否有值并不为null
     */
    val it = null;

    private fun invalidateinfo() {
        if (et_usernmae.text.toString().trim() == "") {
            showToast("请输入用户名")
        }
        if (et_password.text.toString().trim() == "") {
            showToast("请输入密码")
        }
        if (et_password.text.toString().length < 6) {
            showToast("请输入6位以上密码")
            return
        }


//       doLogin(et_usernmae.text.toString().trim(), et_password.text.toString().trim())
//
//        vm!!.getLodinData()?.observe(this, Observer {
//            it?.let { it1 ->
//                if (it1.errorCode == 0) {
//                    loginSuccess(it1)
//                } else {
//                    showToast(it1.errorMsg)
//                }
//
//            }


        if (et_usernmae.text.toString().trim().equals("111111") && et_password.text.toString().trim().equals("1")) {
            val intent = Intent(this, MainWebActivity().javaClass)
            startActivity(intent)

        } else {

            val it = null;
        }
        if (it == null) {
            showToast("网络异常")
        }

    }

    fun loginSuccess(it1: ModelLogin?) {
        showToast("登录成功")
        PreferenceHelper.putBoolean(this, "isLogin", true)
        finish()
    }
}
