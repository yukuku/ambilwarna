Android Color Picker
====================

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.yukuku/ambilwarna/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.yukuku/ambilwarna)

aka `AmbilWarna` library ("Pick a Color" in Indonesian)

moved from http://code.google.com/p/yuku-android-util/

This is a small library for your application to enable the users to select an arbitrary color. It is used in the free Bible applications for Android (http://www.bibleforandroid.com). 

It is also used by:
  * 1,000,000+ downloads app <a href='http://www.davidgoemans.com/mainsite/node/26'>DigiClock Widget</a>
  * 100,000+ downloads app <a href='https://play.google.com/store/apps/details?id=kenyu73.bannerwidget'>Banner</a>
  * 10,000+ downloads app <a href='https://play.google.com/store/apps/details?id=net.redwarp.widget.memento'>Memento</a>

If your application has a feature to customize the color of some background, text, or maybe for a painting application where the user can select different colors for painting or filling, then `AmbilWarna` is suitable for you.


Adding it to your project
===========

```groovy
dependencies {
    compile 'com.github.yukuku:ambilwarna:2.0.1'
}
```

Screenshots
===========

<img src='http://lh5.ggpht.com/_ODdyLCCXPpQ/TKsFBMSlhdI/AAAAAAAAu6o/vqpGqyCnywY/s800/r230-ambilwarna.png'>


How to use the dialog
=====================

Create a color picker dialog by calling the following constructor, and then show it.
```java
    AmbilWarnaDialog(Context context, int color, OnAmbilWarnaListener listener)
```
Alpha is also supported by passing the 3rd parameter `supportsAlpha`:
```java
    AmbilWarnaDialog(Context context, int color, boolean supportsAlpha, OnAmbilWarnaListener listener)
```
Example:
```java
    // initialColor is the initially-selected color to be shown in the rectangle on the left of the arrow.
    // for example, 0xff000000 is black, 0xff0000ff is blue. Please be aware of the initial 0xff which is the alpha.
    AmbilWarnaDialog dialog = new AmbilWarnaDialog(this, initialColor, new OnAmbilWarnaListener() {
    	@Override
    	public void onOk(AmbilWarnaDialog dialog, int color) {
    		// color is the color selected by the user.
    	}
    		
    	@Override
    	public void onCancel(AmbilWarnaDialog dialog) {
    		// cancel was selected by the user
    	}

    dialog.show();
```
How to use it as a Preference
=============================

![](http://s11.postimg.org/sfn41uh43/img.png)

Very simple. It works like a `DialogPreference` that stores an Integer to the shared preferences file.

Just add the following to the preferences xml file.
```xml
  	<yuku.ambilwarna.widget.AmbilWarnaPreference
  		android:key="your_preference_key"
  		android:defaultValue="0xff6699cc" 
  		android:title="Pick a color" />
```
To enable alpha, use the application attribute `supportsAlpha`, as follows:
```xml
    <PreferenceScreen
    	xmlns:android="http://schemas.android.com/apk/res/android"
    	xmlns:app="http://schemas.android.com/apk/res-auto">
    	
    	<yuku.ambilwarna.widget.AmbilWarnaPreference
    		android:key="your_preference_key"
    		android:defaultValue="0xff6699cc" 
    		app:supportsAlpha="true"
    		android:title="Pick a color with alpha" />
    </PreferenceScreen>
```
Contributors
============

* Pascal Cans (noobs.com)
* Justin Warner (One Rainboot Studio)

