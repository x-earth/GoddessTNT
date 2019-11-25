package com.thirdgoddess.tnt.viewpager_adapter;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * ViewPager加载Fragment适配器
 * ViewPager loads Fragment adapter.
 *
 * FragmentPagerAdapter：在每次切换页面的时候，是将fragment进行分离，适合页面较少的fragment使用以保存一些内存，对系统内存不会有太大影响。
 * FragmentPagerAdapter: Each time the page is switched, the fragment is separated, and the fragment is used for a small number of pages to save some memory, which does not have much impact on system memory.
 *
 * @author ThirdGoddess
 * @email ofmyhub@gmail.com
 * @Github https://github.com/ThirdGoddess
 * @date :2019-11-25 22:19
 */
public class ViewPagerFragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList;

    public ViewPagerFragmentAdapter(@NonNull FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
