package com.dante.customview.hencoder;

import android.os.Bundle;

import android.view.Menu;

import androidx.annotation.LayoutRes;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.dante.customview.R;
import com.dante.customview.hencoder.practice7.Page7Fragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class Practice7Activity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager pager;
    List<PageModel> pageModels = new ArrayList<>();

    {
        pageModels.add(new PageModel(R.layout.sample7_argb_evaluator, R.string.title_argb_evaluator, R.layout.practice7_argb_evaluator));
        pageModels.add(new PageModel(R.layout.sample7_hsv_evaluator, R.string.title_hsv_evaluator, R.layout.practice7_hsv_evaluator));
        pageModels.add(new PageModel(R.layout.sample7_of_object, R.string.title_of_object, R.layout.practice7_of_object));
        pageModels.add(new PageModel(R.layout.sample7_property_values_holder, R.string.title_property_values_holder, R.layout.practice7_property_values_holder));
        pageModels.add(new PageModel(R.layout.sample7_animator_set, R.string.title_animator_set, R.layout.practice7_animator_set));
        pageModels.add(new PageModel(R.layout.sample7_keyframe, R.string.title_keyframe, R.layout.practice7_keyframe));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice7);

        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                PageModel pageModel = pageModels.get(position);
                return Page7Fragment.newInstance(pageModel.sampleLayoutRes, pageModel.practiceLayoutRes);
            }

            @Override
            public int getCount() {
                return pageModels.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return getString(pageModels.get(position).titleRes);
            }
        });

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(pager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    private class PageModel {
        @LayoutRes
        int sampleLayoutRes;
        @StringRes
        int titleRes;
        @LayoutRes
        int practiceLayoutRes;

        PageModel(@LayoutRes int sampleLayoutRes, @StringRes int titleRes, @LayoutRes int practiceLayoutRes) {
            this.sampleLayoutRes = sampleLayoutRes;
            this.titleRes = titleRes;
            this.practiceLayoutRes = practiceLayoutRes;
        }
    }
}
