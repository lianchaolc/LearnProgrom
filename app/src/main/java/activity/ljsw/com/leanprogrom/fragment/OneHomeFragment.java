package activity.ljsw.com.leanprogrom.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.youth.banner.Banner;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import activity.ljsw.com.leanprogrom.R;
import activity.ljsw.com.leanprogrom.activity.TwoCodeScannerActivity;
import activity.ljsw.com.leanprogrom.cons.IdiyMessage;
import activity.ljsw.com.leanprogrom.netutils.CallBackUtil;
import activity.ljsw.com.leanprogrom.netutils.Constants;
import activity.ljsw.com.leanprogrom.netutils.OkhttpUtil;
import activity.ljsw.com.leanprogrom.netutils.ToastUtils;
import activity.ljsw.com.leanprogrom.ui.FlashView;
import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by lianchao on 2020/5/19.
 */

public class OneHomeFragment extends Fragment implements View.OnClickListener{
    private static final String TAG ="OneHomeFragment" ;
//    private static final String ARG_SHOW_TEXT = "text";

    //    public View initView(LayoutInflater inflater) {
//        View rootView = inflater.inflate(R.layout.fragment_one_home, null);
//        TextView contentTv = (TextView) rootView.findViewById(R.id.content_tv);
//        contentTv.setText("OneHomeFragment");
//        return rootView;
//    }
//
//    public static BlankFragment newInstance(String param1) {
//        BlankFragment fragment = new BlankFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_SHOW_TEXT, param1);
//        fragment.setArguments(args);
//        return fragment;
//    }

    private TextView searchtv;//  搜索商品
    private  String  str_searchtv;//  字符串商品
    private ImageView  onehometwosan;//  二维码扫描
    private static final String ARG_SHOW_TEXT = "text";

    private String mContentText;

    private FlashView  fv_header;//  图片轮播时容器
    private LinkedList<String> bannerImages;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment BlankFragment.
     */
    public static OneHomeFragment newInstance(String param1) {
        OneHomeFragment fragment = new OneHomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_SHOW_TEXT, param1);
        fragment.setArguments(args);
        return fragment;
    }
    protected void handlerMessage(Message msg) {
        switch (msg.what){
            case IdiyMessage.ACTION_LOAD_AD1_RESULT:
                handleLoadAd1Result((List<Banner>) msg.obj);
                break;
//            case IdiyMessage.ACTION_LOAD_AD2_RESULT:
//                handleLoadAd2Result((List<Banner>) msg.obj);
//                break;
//            case IdiyMessage.SECOND_KILL_ACTION_RESULT:
//                handleSecondKill((List<RSecondKill>)msg.obj);
//                break;
//            case IdiyMessage.RECOMMEND_ACTION_RESULT:
//                handleRecommend((List<RRecommndProduct>)msg.obj);
//                break;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mContentText = getArguments().getString(ARG_SHOW_TEXT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_one_home, container, false);
//        TextView contentTv = (TextView) rootView.findViewById(R.id.content_tv);
//        contentTv.setText("11111");
          searchtv= (TextView) rootView.findViewById(R.id.et_search_alliance);
        str_searchtv=searchtv.getText().toString().trim();
        onehometwosan= (ImageView) rootView.findViewById(R.id.id_scan);
        onehometwosan.setOnClickListener(this);

        fv_header= (FlashView) rootView.findViewById(R.id.fv_header);
        fv_header.setPlaceholder(R.mipmap.ic_loading_36);
        LoadData();
        return rootView;
    }

    /***
     *
     */
    private  void  LoadData() {
        if(str_searchtv.isEmpty()){
            Log.d(TAG,searchtv+"str_searchtv");
            ToastUtils.show(OneHomeFragment.this.getActivity(),"您还没选择商品");
        }else{

            Map<String,String>  maptitle=new HashMap<>();
            maptitle.put("shopname",str_searchtv);
            OkhttpUtil.okHttpPut(Constants.Search, maptitle, new CallBackUtil() {
                @Override
                public Object onParseResponse(Call call, Response response) {
                    return null;
                }

                @Override
                public void onFailure(Call call, Exception e) {

                }

                @Override
                public void onResponse(Object response) {

                }
            });
        }
    }
    private void handleLoadAd1Result(final List<Banner> datas){
        if (datas.size()!=0) {
            bannerImages = new LinkedList<>();

            for (int i= 0;i<datas.size();i++){
                Banner banner = datas.get(i);
//                bannerImages.add(i,Constants.URL+banner.getAdUrl());
                bannerImages.add(i,Constants.URL);
            }
            fv_header.setImagesUrl(bannerImages);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case  R.id.id_scan:
                ToastUtils.show(OneHomeFragment.this.getActivity(),"即将打开二维码扫描请稍等");
//                startActivity(OneHomeFragment.this.getActivity(), TwoCodeScannerActivity.class);
                Intent intent = new Intent();
                intent.setClass(OneHomeFragment.this.getActivity(),TwoCodeScannerActivity.class);
                startActivityForResult(intent,0);
                break;
        }
    }

}
