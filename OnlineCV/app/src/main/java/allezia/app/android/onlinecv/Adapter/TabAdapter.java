package allezia.app.android.onlinecv.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import allezia.app.android.onlinecv.Pages.ProfilePages;
import allezia.app.android.onlinecv.Pages.SearchPages;
import allezia.app.android.onlinecv.Pages.SettingsPages;

/**
 * Created by Abdullah on 14.9.2016.
 */
public class TabAdapter extends FragmentPagerAdapter {
    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return  new SearchPages();
            case 1:
                return  new ProfilePages();
            case 2:
                return new SettingsPages();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
