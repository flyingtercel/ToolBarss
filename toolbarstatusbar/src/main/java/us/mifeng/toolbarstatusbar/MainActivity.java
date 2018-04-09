package us.mifeng.toolbarstatusbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    //https://www.cnblogs.com/guanhaoran/p/7049432.html?utm_source=tuicool&utm_medium=referral
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {
        switch (view.getId()){
            case R.id.imgStatus:
                startActivity(new Intent(this,ImageActivity.class));
                break;
            case R.id.colorStatus:
                startActivity(new Intent(this,ColorActivity.class));
                break;
        }
    }
}
