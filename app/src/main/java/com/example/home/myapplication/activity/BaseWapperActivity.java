package com.example.home.myapplication.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.example.home.myapplication.R;
import com.example.home.myapplication.application.ECApplication;
import com.example.home.myapplication.service.IECManager;

/**
 * Created by home on 2016/7/22.
 */
public abstract class BaseWapperActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView classify;
    private ImageView home;
    private ImageView more;
    protected ProgressDialog progressDialog;
    private ImageView search;
    private ImageView shopCar;

    protected Context context;
    private ECApplication application;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        application = (ECApplication)getApplication();
        application.addActvity(this);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        super.setContentView(R.layout.frame);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,R.layout.custom_title);
        context = getApplicationContext();
        initView();

    }

    private void initView() {
        if(isLoadBottomTab()){
            //loadButtomTab
        }
        loadViewLayout();
        findViewById();
        setListener();

    }
    /**
     *
     */
    protected abstract void loadViewLayout();

    /**
     *
     */
    protected abstract void findViewById();
    /**
     *
     */
    protected abstract void setListener();

    /**
     * 是否加载底部tab
     *
     * @return
     */
    protected Boolean isLoadBottomTab() {
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_home:
                startActivity(new Intent(BaseWapperActivity.this,HomeActivity.class));
                break;
            case R.id.menu_more:
                startActivity(new Intent(BaseWapperActivity.this,AboutActivity.class));
                break;
            case R.id.menu_exit:
                application.exit();
                break;
        }
        return true;
    }

    public IECManager getECManager() {
        return application.getEcManager();
    }

    @Override
    public void onClick(View v) {

    }
}
