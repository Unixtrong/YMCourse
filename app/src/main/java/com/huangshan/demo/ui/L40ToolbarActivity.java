package com.huangshan.demo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.huangshan.demo.R;
import com.huangshan.demo.utils.Tools;

public class L40ToolbarActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);
        initView();
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.l40_tb);
        setSupportActionBar(mToolbar);

        mToolbar.setTitle("Tony Stark");
        mToolbar.setSubtitle("Icon Man");
        // 设置导航图标
        mToolbar.setNavigationIcon(R.mipmap.ic_arrow_back_white);
        // 设置 logo
        mToolbar.setLogo(R.mipmap.ic_hearthstone_logo2);
        mToolbar.setTitleMarginStart(50);
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_edit:
                        onClickEdit();
                        break;
                    case R.id.action_share:
                        onClickShare();
                        break;
                    case R.id.action_settings:
                        onClickSettings();
                        break;
                }
                return false;
            }
        });
    }

    private void onClickSettings() {
        Tools.toast(this, "Settings!");
    }

    private void onClickShare() {
        Tools.toast(this, "Share!");
    }

    private void onClickEdit() {
        Tools.toast(this, "Edit!");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.l40_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
