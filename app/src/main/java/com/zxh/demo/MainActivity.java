package com.zxh.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.zxh.customview.floatview.FloatUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatUtil.getInstance().addActivity(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        FloatUtil.getInstance().showFloatView(this);
        FloatUtil.getInstance().setOnCLicekListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( FloatUtil.getInstance() .isDraging())
                Toast.makeText(MainActivity.this,"jfkdsjafkjksa",Toast.LENGTH_LONG);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        FloatUtil.getInstance().stopHandler(this);
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        FloatUtil.getInstance().removeActivity(this);
    }

    @Override
    public void finish(){
        super.finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
