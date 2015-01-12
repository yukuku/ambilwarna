package yuku.ambilwarna.demo;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class AmbilWarnaDemoPreferenceActivity extends PreferenceActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		addPreferencesFromResource(R.xml.demopreference);
	}
}