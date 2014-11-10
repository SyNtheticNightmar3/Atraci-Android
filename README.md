Atraci for Android
====================================
Atraci lets you instantly listen to more than 60 million songs; it requires no sign up, displays no ads and is 100% safe.

How does it work?
----------------------------
When searching, Atraci will use iTunes, Last.fm and SoundCloud to display song information, such as Album, Artist, or Song Title.
Atraci will then try to find the best match for this song on Youtube and stream the **highest quality video stream** by default.

No downloads, no torrents, and completely legal!

Building with the Android SDK (Ant)
----------------------------
Building Atraci requires the [Android SDK](https://developer.android.com/sdk/installing/index.html) and [Java 7](http://www.oracle.com/technetwork/java/javase/downloads/index.html).  
AndroidCentral has a [tutorial](http://www.androidcentral.com/installing-android-sdk-windows-mac-and-linux-tutorial) that can assist in setting up & exporting variables for the Android SDK.  
[WebUpd8's ppa](https://launchpad.net/~webupd8team/+archive/ubuntu/java) is recommended for Ubuntu/Debian users for installing Oracle's Java 7; for easy access between Oracle JDK versions & ease of updates.

Once JDK 7 and the Android SDK are installed, fetch the source code

    $ git clone https://github.com/Atraci/Atraci-Android.git -b dev

Change to Atraci-Android directory & generate local.properties using 'android update'

    $ cd Atraci-Android
    $ android update project --target [id] --path [path/to/Atraci-Android]

To build a 'debug' build

    $ ant debug

Donations
----------------------------
Want to donate to Atraci? [Click me](https://github.com/Atraci/Atraci/wiki/Donations)
