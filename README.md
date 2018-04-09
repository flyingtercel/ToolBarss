# ActionBar
ToolBar学习
# 自定义颜色
![自定义颜色](https://github.com/flyingtercel/ToolBarss/blob/master/app/src/main/res/mipmap-xxhdpi/img01.png)
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
###沉浸式状态栏设置
注意！沉浸式状态栏只支持安卓4.4及以上的版本
状态栏：4.4上是渐变色，5.0上是完全透明，运行结果图
![运行效果图](https://github.com/flyingtercel/ToolBarss/blob/master/toolbarstatusbar/src/main/res/drawable/ss12.png)   </br>
![图片状态栏](https://github.com/flyingtercel/ToolBarss/blob/master/toolbarstatusbar/src/main/res/drawable/ss11.png)   </br>
![纯色状态栏](https://github.com/flyingtercel/ToolBarss/blob/master/toolbarstatusbar/src/main/res/drawable/ss22.png)   </br>
第一、首先在values、values-v19、values-v21文件夹下的styles.xml都设置一个 Translucent System Bar 风格的Theme，
values/style.xml：
```
<style name="BaseTheme" parent="Theme.AppCompat.Light.DarkActionBar">
    <!--在Android 4.4之前的版本上运行，直接跟随系统主题-->
</style>
<style name="TranslucentTheme" parent="BaseTheme">
    <!--在Android 4.4之前的版本上运行，直接跟随系统主题-->
</style>
```
values-v19/style.xml：
```
<style name="TranslucentTheme" parent="BaseTheme">
    <item name="android:windowTranslucentStatus">true</item>
    <item name="android:windowTranslucentNavigation">true</item>
</style>
```
values-v21/style.xml：
```
<style name="TranslucentTheme" parent="BaseTheme">
    <item name="android:windowTranslucentStatus">false</item>
    <item name="android:windowTranslucentNavigation">true</item>
    <!--Android 5.x开始需要把颜色设置透明，否则导航栏会呈现系统默认的浅灰色-->
    <item name="android:statusBarColor">@android:color/transparent</item>
</style>
```
第二、在清单文件中配置需要沉浸式状态栏的activity加入theme
```
<activity android:name=".ImageActivity" android:theme="@style/TranslucentTheme" />
<activity android:name=".ColorActivity" android:theme="@style/TranslucentTheme" />
```
第三、在Activity的布局文件中的跟布局加入“android:fitsSystemWindows=”true””，但是，这里需要区分一下，就是背景是图片还是纯色：

1.当背景为图片时，布局可以这么写：
```
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/imgs_bj"
    android:fitsSystemWindows="true">

</RelativeLayout>
```
