package activity.ljsw.com.leanprogrom.activity

import activity.ljsw.com.leanprogrom.R
import android.app.Activity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_crop_image_view.*

/****
 * apply plugin: 'kotlin-android-extensions'    扩展组件
 * kotlin
 * 学习
 */
class CropImageViewActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crop_image_view)

        activity_croptv.text = "kotlin学习";
        activity_textview2.text="加油";
//        activity_textview2.text = "不好用";
//            activity_textview2.setText("890")//自动根据id找到相应的view
    }
}

