package remix.myplayer.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.umeng.analytics.MobclickAgent;

import butterknife.BindView;
import butterknife.ButterKnife;
import remix.myplayer.R;
import remix.myplayer.ui.customview.playpause.PlayPauseView;

/**
 * Created by Remix on 2016/3/26.
 */
public class AboutActivity extends ToolbarActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolBar;
    @BindView(R.id.playbar_play_pause)
    PlayPauseView playPauseView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        ButterKnife.bind(this);
        initToolbar(mToolBar, getString(R.string.about));

        playPauseView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playPauseView.toggle(true);
            }
        });
    }

    public void onResume() {
        MobclickAgent.onPageStart(AboutActivity.class.getSimpleName());
        super.onResume();
    }
    public void onPause() {
        MobclickAgent.onPageEnd(AboutActivity.class.getSimpleName());
        super.onPause();
    }

}
