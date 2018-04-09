# ActionBar
ToolBar学习
# 自定义颜色
![自定义颜色](https://github.com/flyingtercel/ToolBarss/blob/master/app/src/main/res/mipmap-hdpi/style.png)
```
<style name="AppTheme" parent="AppTheme.Base">
        <!--状态栏颜色-->
        <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
        <!--控制各个控件被选中时的颜色-->
        <item name="colorAccent">@color/colorAccent</item>
        <!--页面背景色-->
        <item name="android:windowBackground">@color/windowBackg</item>
        <!--底部导航栏颜色-->
        <item name="android:navigationBarColor">@color/navigationColor</item>
        <!--Appbar背景色-->
        <item name="android:colorPrimary">@color/colorPrimary</item>
        <!--ToolBar上的Title颜色-->
        <item name="android:textColorPrimary">@color/textColorPrimary</item>
        <!--各个控制控件的默认颜色-->
        <item name="android:colorControlNormal">@color/colorControlNormal</item>
</style>
```
ToolBar中添加文本图标如下图
![ToolBar样式](https://github.com/flyingtercel/ToolBarss/blob/master/app/src/main/res/mipmap-hdpi/toolbar.png)
```
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
```
