package activity.ljsw.com.leanprogrom.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.wyt.searchbox.SearchFragment;
import com.wyt.searchbox.custom.IOnSearchClickListener;

import activity.ljsw.com.leanprogrom.R;

public class testActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        SearchFragment searchFragment = SearchFragment.newInstance();
        searchFragment.setOnSearchClickListener(new IOnSearchClickListener() {
            @Override
            public void OnSearchClick(String keyword) {
                //这里处理逻辑
                Toast.makeText(testActivity.this, keyword, Toast.LENGTH_SHORT).show();
            }
        });
        searchFragment.showFragment(getSupportFragmentManager(),SearchFragment.TAG);
    }
}
