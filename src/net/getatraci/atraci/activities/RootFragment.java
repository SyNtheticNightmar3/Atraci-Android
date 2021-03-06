package net.getatraci.atraci.activities;

import net.getatraci.atraci.R;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A fragment that is displayed when the application is started that shows a 
 * list of commits from the Github repo
 * @author Blake LaFleur
 */
public class RootFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_homenews, container, false);
		//Show playlists when app loads
		getFragmentManager().beginTransaction().replace(R.id.root_frame, new PlaylistSelectorFragment(HomeActivity.getDatabase())).addToBackStack("playlists").commit();
		return view;
	}
}
