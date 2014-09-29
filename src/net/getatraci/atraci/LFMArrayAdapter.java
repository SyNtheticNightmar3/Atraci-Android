package net.getatraci.atraci;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LFMArrayAdapter extends BaseAdapter {

	private MusicTypeCategories m_data;
	LayoutInflater layoutInflater;
	Context m_Context;
	
	private final int TYPE_ARTIST_HEADER = 0;
	private final int TYPE_ARTIST = 1;
	private final int TYPE_ALBUM_HEADER = 2;
	private final int TYPE_ALBUM = 3;
	private final int TYPE_SONG_HEADER = 4;
	private final int TYPE_SONG = 5;
	
    public LFMArrayAdapter(Context context, MusicTypeCategories data) {
      super();
      m_Context = context;
      m_data = data;
      layoutInflater = LayoutInflater.from(context);
    }


	@Override
	public int getCount() {
		return m_data.getTotalSize()+3;
	}

	@Override
	public MusicItem getItem(int position) {
        switch(getItemViewType(position)) {
        case TYPE_SONG:
        	return m_data.getSong(Math.abs((m_data.getTotalSize()-m_data.getSongCount())-(position-3)));
        case TYPE_ALBUM:
        	return m_data.getAlbum(position-m_data.getArtistCount()-2);
        case TYPE_ARTIST:
        	return m_data.getArtist(position-1);
        }
        return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	
	
	@Override
	public int getItemViewType(int position) {
		if(position == 0) {
			return TYPE_ARTIST_HEADER;
		}
		if(position == m_data.getArtistCount() + 1) {
			return TYPE_ALBUM_HEADER;
		}
		if(position == m_data.getArtistCount() + m_data.getAlbumCount() + 2) {
			return TYPE_SONG_HEADER;
		}
		if(position <= m_data.getArtistCount()) {
			return TYPE_ARTIST;
		}
		if(position <= m_data.getArtistCount() + m_data.getAlbumCount()) {
			return TYPE_ALBUM;
		}
		return TYPE_SONG;
	}


	@Override
	public int getViewTypeCount() {
		return 6;
	}


	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		int type = getItemViewType(position);
		
		if(type == TYPE_ARTIST_HEADER || type == TYPE_ALBUM_HEADER || type == TYPE_SONG_HEADER) {
			if(convertView == null) {
				convertView = getHeaderView();
			}
			String text = type == TYPE_ARTIST_HEADER ? "Artists" : type == TYPE_ALBUM_HEADER ? "Albums" : "Songs";
			((TextView) ((ViewGroup) convertView).getChildAt(0)).setText(text);
			return convertView;
		}
		
		if(convertView == null)
			convertView = layoutInflater.inflate(R.layout.searchlist_item, parent, false);
		
		TextView txt = (TextView) convertView.findViewById(R.id.item1);
		ImageView img = (ImageView) convertView.findViewById(R.id.album_art);
		
		if(m_data.getTotalSize() < 1)
			return convertView;
		
		Log.d("ATRACI", "Position: " + position + " Artist Size: "+m_data.getArtistCount() + "Album Size: " + m_data.getAlbumCount() + "Song Size: "+ m_data.getSongCount() + " Total Size: " + m_data.getTotalSize());
        switch(type) {
        case TYPE_SONG:
			new ImageDownloader(img,m_data.getSong(Math.abs(position - m_data.getAlbumCount()- m_data.getArtistCount()-3)).getImage());
        	txt.setText(m_data.getSong(Math.abs(position - m_data.getAlbumCount()- m_data.getArtistCount()-3)).getTrack());
        	break;
        case TYPE_ALBUM:
        	new ImageDownloader(img,m_data.getAlbum(position-(m_data.getArtistCount()+2)).getImage());
        	txt.setText(m_data.getAlbum(position-m_data.getArtistCount()-2).getAlbum());
        	break;
        case TYPE_ARTIST:
        	new ImageDownloader(img,m_data.getArtist(position-1).getImage());
        	txt.setText(m_data.getArtist(position-1).getArtist());
        	break;
        }
		
		return convertView;
	}
	
	private ViewGroup getHeaderView() {
		LinearLayout layout = new LinearLayout(m_Context);
		layout.addView(new TextView(m_Context));
		return layout;
	}
	
	
}