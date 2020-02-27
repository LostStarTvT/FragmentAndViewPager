# FragmentAndViewPager
仿知乎布局，实现左右滑动进行切换界面，其中界面是使用Fragement，界面滑动使用ViewPager进行实现  

### 实现效果
demo中实现了三个界面进行切换，上面有个导航栏可以很好的标注出来在哪个界面。  
[![308CIH.md.gif](https://s2.ax1x.com/2020/02/27/308CIH.md.gif)](https://imgchr.com/i/308CIH)


### 实现方式
总共有[导航栏](https://github.com/Devlight/NavigationTabStrip)和一个[viewPager](https://github.com/danilao/fragments-viewpager-example)，将两个项目进行结合形成以上的效果。 感谢贡献~   
### 实现代码
- MainActivity代码

需要一个activity作为容器进行承载三个fragment界面，然后使用viewPager这个类进行界面的切换，首先是activity代码： 将fragment和viewPager绑定。  

```java
 	static final int NUM_ITEMS = 3;

    ViewPager mPager;
    SlidePagerAdapter mPagerAdapter;

    private NavigationTabStrip mCenterNavigationTabStrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //找到可以自动切换的承载器。
        mPager = (ViewPager) findViewById(R.id.pager);

        mPagerAdapter = new SlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

        mCenterNavigationTabStrip = (NavigationTabStrip) findViewById(R.id.nts_center);
        //将导航栏与pager 绑定，并设置第几个界面，
        mCenterNavigationTabStrip.setViewPager(mPager, 0);

    }

    /* PagerAdapter class */
    public class SlidePagerAdapter extends FragmentPagerAdapter {
        SlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            //进行选择1 2 3
            if (position == 0)
                return new FirstFragment();
            else if (position ==1)
                return new SecondFragment();
            else
                return new ThirdFragment();
        }

        @Override
        public int getCount() {
            return NUM_ITEMS;
        }
    }
```

- MainActivity界面代码

整个界面包括两层结构**导航栏**和**显示界面**，这两个被一个大的<LinearLayout> 包含，然后这个大的<LinearLout>标签中又分别含有两个<FrameLayout>标签，分别包括导航栏和viewPager容器，形成真个布局。 mainActivity 容器将代二者进行连接，形成同步滑动切换界面。

```xml
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.proposeme.fragmentandviewpager.MainActivity">


    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">

        <FrameLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:background="#ff252e39">

            <View
                android:layout_width="match_parent"
                android:layout_height="4dp"
                android:layout_gravity="center"
                android:layout_marginTop="18dp"
                android:background="#182128"/>

            <com.gigamole.navigationtabstrip.NavigationTabStrip
                android:id="@+id/nts_center"
                android:layout_width="match_parent"
                android:layout_height="42dp"
                android:layout_gravity="center"
                android:layout_marginEnd="30dp"
                android:layout_marginLeft="30dp"
                android:layout_marginRight="30dp"
                android:layout_marginStart="30dp"
                app:nts_active_color="#fff"
                app:nts_color="#3cdedd"
                app:nts_corners_radius="3.5dp"
                app:nts_factor="0.8"
                app:nts_gravity="bottom"
                app:nts_inactive_color="#81ffffff"
                app:nts_titles="@array/titles"
                app:nts_type="point"
                app:nts_typeface="fonts/moon.otf"
                app:nts_weight="7dp">
            </com.gigamole.navigationtabstrip.NavigationTabStrip>


        </FrameLayout>

        <FrameLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:background="#ff252e39">

            <android.support.v4.view.ViewPager
                xmlns:android="http://schemas.android.com/apk/res/android"
                android:id="@+id/pager"
                android:layout_width="match_parent"
                android:layout_height="match_parent" />

        </FrameLayout>

    </LinearLayout>


</android.support.constraint.ConstraintLayout>
```

- Fragment界面

定义了三个fragment空白界面进行展示界面切换的效果，代码如下，其中有一点就是需要区别fragment和activity中对于界面的操作和声明周期。 xml布局文件不再赘述。   

```java
public class FirstFragment extends Fragment {
    private static final String TAG = "FirstFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        return view;
    }
}
```

万水千山总是情，点个star行不行~
