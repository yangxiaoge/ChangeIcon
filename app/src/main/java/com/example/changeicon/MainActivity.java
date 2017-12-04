package com.example.changeicon;

import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ComponentName mDefaultIcon;
    ComponentName mIcon1;
    ComponentName mIcon2;

    PackageManager packageManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDefaultIcon = getComponentName();
        mIcon1 = new ComponentName(getBaseContext(),"com.example.changeicon.Icon1");
        mIcon2 = new ComponentName(getBaseContext(),"com.example.changeicon.Icon2");

        packageManager = getApplicationContext().getPackageManager();

        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn1:
                disableComponent(mDefaultIcon);
                disableComponent(mIcon2);
                enbaleComponent(mIcon1);
                break;
            case R.id.btn2:
                disableComponent(mDefaultIcon);
                disableComponent(mIcon1);
                enbaleComponent(mIcon2);
                break;
        }
    }

    private void enbaleComponent(ComponentName componentName){
        packageManager.setComponentEnabledSetting(componentName,PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
        PackageManager.DONT_KILL_APP);
    }

    private void disableComponent(ComponentName componentName){
        packageManager.setComponentEnabledSetting(componentName,PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP);
    }
}
