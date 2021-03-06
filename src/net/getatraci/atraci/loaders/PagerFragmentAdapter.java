package net.getatraci.atraci.loaders;

import net.getatraci.atraci.activities.PlayerFragment;
import net.getatraci.atraci.activities.RootFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;


public class PagerFragmentAdapter extends FragmentPagerAdapter {
	
	SparseArray<Fragment> registeredFragments = new SparseArray<Fragment>();
	
	public PagerFragmentAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int pos) {
		// TODO Auto-generated method stub
		switch(pos) {
		case 0:
			return new RootFragment();
		case 1:
			return new PlayerFragment();
		}
		return null;
	}

	@Override
	public int getCount() {
		return 2;
	}
	
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        registeredFragments.put(position, fragment);
        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        registeredFragments.remove(position);
        super.destroyItem(container, position, object);
    }

    public Fragment getRegisteredFragment(int position) {
        return registeredFragments.get(position);
    }
	
	
	
}
