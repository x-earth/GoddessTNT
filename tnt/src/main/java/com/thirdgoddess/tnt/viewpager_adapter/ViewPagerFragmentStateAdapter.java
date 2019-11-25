package com.thirdgoddess.tnt.viewpager_adapter;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

/**
 * ViewPager加载Fragment适配器
 * ViewPager loads Fragment adapter.
 *
 * FragmentStatePagerAdapter：在每次切换页面的时候，是将fragment进行回收，适合页面较多的fragment使用，这样就不会消耗更多的内存。
 * FragmentStatePagerAdapter: Each time the page is switched, the fragment is recycled, which is suitable for the fragment with more pages, so that it does not consume more memory.
 *
 * @author ThirdGoddess
 * @email ofmyhub@gmail.com
 * @Github https://github.com/ThirdGoddess
 * @date :2019-11-25 22:19
 */
public class ViewPagerFragmentStateAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> fragmentList;

    public ViewPagerFragmentStateAdapter(@NonNull FragmentManager fm, List<Fragment> fragmentList) {
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
