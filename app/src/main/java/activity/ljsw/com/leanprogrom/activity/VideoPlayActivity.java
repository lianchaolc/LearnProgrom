package activity.ljsw.com.leanprogrom.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import activity.ljsw.com.leanprogrom.R;
import activity.ljsw.com.leanprogrom.videoUtils.AppContext;
import cn.ittiger.player.Config;
import cn.ittiger.player.FullScreenVideoPlayerView;
import cn.ittiger.player.PlayerManager;
import cn.ittiger.player.factory.ExoPlayerFactory;

/****
 * 实现视频播放功能
 *
 *
 * https://github.com/huyongli/TigerVideo/tree/master/Demo/src/main
 */

public class VideoPlayActivity extends Activity {
    private RecyclerView vido_play_recyclviews;
    private FullScreenVideoPlayerView mVideoPlayerView;
    String mVideoUrl = "http://gslb.miaopai.com/stream/oxX3t3Vm5XPHKUeTS-zbXA__.mp4";
    String mVideoTitle = "三字经";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_play);
        AppContext.init(this);
        PlayerManager.loadConfig(
                new Config.Builder(this)
                        .buildPlayerFactory(new ExoPlayerFactory(this))
                        .enableSmallWindowPlay()
                        .cache(false)
                        .build()
        );
        vido_play_recyclviews= (RecyclerView) findViewById(R.id.vido_play_recyclviews);
        mVideoPlayerView = (FullScreenVideoPlayerView) findViewById(R.id.video_player_view);
        mVideoPlayerView.bind(mVideoUrl, mVideoTitle);
        mVideoPlayerView.startPlayVideo();
    }


    @Override
    protected void onResume() {

        super.onResume();
        PlayerManager.getInstance().resume();
    }

    @Override
    protected void onPause() {

        super.onPause();
        PlayerManager.getInstance().pause();
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
        PlayerManager.getInstance().release();
    }
}
