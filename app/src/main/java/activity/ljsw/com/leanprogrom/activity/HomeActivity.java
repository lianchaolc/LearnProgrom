package activity.ljsw.com.leanprogrom.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.View;
import android.widget.RadioGroup;

import activity.ljsw.com.leanprogrom.R;
import activity.ljsw.com.leanprogrom.fragment.BlankFragment;
import activity.ljsw.com.leanprogrom.fragment.CategoryFragment;
import activity.ljsw.com.leanprogrom.fragment.OneHomeFragment;

/****
 * https://blog.csdn.net/afei__/article/details/80950288
 * 底部导航栏
 */
public class HomeActivity extends AppCompatActivity {
    private RadioGroup mTabRadioGroup;
    private SparseArray<Fragment> mFragmentSparseArray;
    private OneHomeFragment   MoneHomeFragment;
    private  CategoryFragment  CategoryFragment ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
    }
    private void initView() {
        mTabRadioGroup = (RadioGroup) findViewById(R.id.tabs_rg);
        mFragmentSparseArray = new SparseArray<>();
        mFragmentSparseArray.append(R.id.today_tab, OneHomeFragment.newInstance("首11111"));
        mFragmentSparseArray.append(R.id.record_tab,  CategoryFragment.newInstance("222222222"));
        mFragmentSparseArray.append(R.id.contact_tab, BlankFragment.newInstance("通讯录"));
        mFragmentSparseArray.append(R.id.settings_tab, BlankFragment.newInstance("设置"));
        mTabRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // 具体的fragment切换逻辑可以根据应用调整，例如使用show()/hide()
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        mFragmentSparseArray.get(checkedId)).commit();
            }
        });
        // 默认显示第一个
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,
                mFragmentSparseArray.get(R.id.today_tab)).commit();
        findViewById(R.id.sign_iv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, CropImageViewActivity.class));
            }
        });
    }

}
