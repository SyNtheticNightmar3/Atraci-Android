package net.getatraci.atraci.loaders;

import android.app.Service;

import java.net.MalformedURLException;

import net.getatraci.atraci.json.JSONParser;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.webkit.WebView;

/**
 * Bound Service for the Loading the WebView used in PlayerFragment.
 * @author Luis Cruz
 *
 */

public class PlayerLoaderService extends Service {

	private final IBinder mBinder = new PlayerBinder();

	public class PlayerBinder extends Binder {
        	public PlayerLoaderService getService() {
            		return PlayerLoaderService.this;
        	}
	}

	/**
	 * Keep Service running until explicitly stopped.
	 */
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		return START_STICKY;
	}

	@Override
	public IBinder onBind (Intent intent) {
		return mBinder;
	}

	/**
	 * Load Next Song for PLayerFragment's WebView
	 */
	public static void getNextSong(WebView wv, String ytLink) {
		try {
			wv.loadUrl("javascript:player.loadVideoById(\""+ JSONParser.extractYoutubeId(ytLink)+"\", 0, \"large\");");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}
