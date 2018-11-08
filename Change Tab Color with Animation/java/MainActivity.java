import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewAnimationUtils;

public class MainActivity extends AppCompatActivity implements TabLayout.BaseOnTabSelectedListener {

    private AppBarLayout appBarLayout;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private View mRevealView;
    private View mRevealBackgroundView;

    private int fromColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appBarLayout = findViewById(R.id.main_appbar);
        toolbar = findViewById(R.id.main_toolbar);
        tabLayout = findViewById(R.id.main_tablayout);
        viewPager = findViewById(R.id.main_viewPager);
        mRevealView = findViewById(R.id.reveal);
        mRevealBackgroundView = findViewById(R.id.revealBackground);

        setUpTabs();

        setSupportActionBar(toolbar);

        fromColor = R.color.colorTabOne;
    }

    private void setUpTabs() {
        viewPager.setAdapter(new ViewPagerAdapter());
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(this);

        tabLayout.getTabAt(0).setText("TAB ONE");
        tabLayout.getTabAt(1).setText("TAB TWO");
        tabLayout.getTabAt(2).setText("TAB THREE");
    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        switch (tab.getPosition()) {

            case 0:
                animateAppAndStatusBar(0, R.color.colorTabOne);
            break;

            case 1:
                animateAppAndStatusBar(appBarLayout.getWidth() / 2, R.color.colorTabTwo);
                break;

            case 2:
                animateAppAndStatusBar(appBarLayout.getWidth(), R.color.colorTabThree);
                break;

        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    private void animateAppAndStatusBar(int cx, final int toColor) {
        Animator animator = ViewAnimationUtils.createCircularReveal(
                mRevealView,
                cx,
                appBarLayout.getBottom(), 0,
                appBarLayout.getWidth() / 2);

        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                mRevealView.setBackgroundColor(getResources().getColor(toColor));
            }
        });

        mRevealBackgroundView.setBackgroundColor(getResources().getColor(fromColor));
        animator.setStartDelay(200);
        animator.setDuration(125);
        animator.start();
        mRevealView.setVisibility(View.VISIBLE);
        fromColor = toColor;
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {

        ViewPagerAdapter() {
            super(MainActivity.this.getSupportFragmentManager());
        }

        @Override
        public Fragment getItem(int i) {
            switch (i) {
                case 0:
                    return new TabOneFragment();

                case 1:
                    return new TabTwoFragment();

                case 2:
                    return new TabThreeFragment();

                default:
                    throw new IllegalArgumentException("Invalid position " + i);
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
