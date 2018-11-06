package com.siberiadante.customview.hencoder;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

import com.siberiadante.customview.R;
import com.siberiadante.customview.hencoder.practice4.Page4Fragment;

import java.util.ArrayList;
import java.util.List;

public class Practice4Activity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager pager;
    List<PageModel> pageModels = new ArrayList<>();

    {
        pageModels.add(new PageModel(R.layout.sample4_clip_rect, R.string.title4_clip_rect, R.layout.practice4_clip_rect));
        pageModels.add(new PageModel(R.layout.sample4_clip_path, R.string.title4_clip_path, R.layout.practice4_clip_path));
        pageModels.add(new PageModel(R.layout.sample4_translate, R.string.title4_translate, R.layout.practice4_translate));
        pageModels.add(new PageModel(R.layout.sample4_scale, R.string.title4_scale, R.layout.practice4_scale));
        pageModels.add(new PageModel(R.layout.sample4_rotate, R.string.title4_rotate, R.layout.practice4_rotate));
        pageModels.add(new PageModel(R.layout.sample4_skew, R.string.title4_skew, R.layout.practice4_skew));
        pageModels.add(new PageModel(R.layout.sample4_matrix_translate, R.string.title4_matrix_translate, R.layout.practice4_matrix_translate));
        pageModels.add(new PageModel(R.layout.sample4_matrix_scale, R.string.title4_matrix_scale, R.layout.practice4_matrix_scale));
        pageModels.add(new PageModel(R.layout.sample4_matrix_rotate, R.string.title4_matrix_rotate, R.layout.practice4_matrix_rotate));
        pageModels.add(new PageModel(R.layout.sample4_matrix_skew, R.string.title4_matrix_skew, R.layout.practice4_matrix_skew));
        pageModels.add(new PageModel(R.layout.sample4_camera_rotate, R.string.title4_camera_rotate, R.layout.practice4_camera_rotate));
        pageModels.add(new PageModel(R.layout.sample4_camera_rotate_fixed, R.string.title4_camera_rotate_fixed, R.layout.practice4_measure_text));
        pageModels.add(new PageModel(R.layout.sample4_camera_rotate_hitting_face, R.string.title4_camera_rotate_hitting_face, R.layout.practice4_camera_rotate_hitting_face));
        pageModels.add(new PageModel(R.layout.sample4_flipboard, R.string.title4_flipboard, R.layout.practice4_flipboard));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice4);

        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                PageModel pageModel = pageModels.get(position);
                return Page4Fragment.newInstance(pageModel.sampleLayoutRes, pageModel.practiceLayoutRes);
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
