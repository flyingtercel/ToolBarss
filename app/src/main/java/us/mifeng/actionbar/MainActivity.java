package us.mifeng.actionbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import us.mifeng.actionbar.utils.ToastUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //查找控件
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        //设置logo
        toolbar.setLogo(R.mipmap.ic_launcher_round);
        //设置标题
        toolbar.setTitle("My Test");
        //设置副标题
        toolbar.setSubtitle("My Sub Title");
        //设置显示Toolbar
        setSupportActionBar(toolbar);
        //设置导航图标，导航图标只有在setSupportActionBar(toolbar);后显示
        toolbar.setNavigationIcon(R.mipmap.ic_launcher);
        //设置菜单的监听事件
        toolbar.setOnMenuItemClickListener(new OnMenuClickListener());
    }
    class OnMenuClickListener implements Toolbar.OnMenuItemClickListener {

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()){
                case R.id.add:
                    ToastUtils.ToastShow(MainActivity.this,"添加了");
                    break;
                case R.id.delete:
                    ToastUtils.ToastShow(MainActivity.this,"删除了");
                    break;
                case R.id.update:
                    ToastUtils.ToastShow(MainActivity.this,"修改了");
                    break;
            }
            return true;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //关联菜单
        getMenuInflater().inflate(R.menu.menu_main,menu);
        //return super.onCreateOptionsMenu(menu);
        return true;
    }

}
