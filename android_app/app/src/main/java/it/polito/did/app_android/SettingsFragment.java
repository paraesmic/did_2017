package it.polito.did.app_android;

import android.os.Bundle;
import android.preference.PreferenceFragment;

public class SettingsFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preferences);
        }

//    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
//        Preference pref = findPreference(key);
//
//        if (pref instanceof ListPreference) {  //mostra elemento scelto al posto del summary ad esempio: lingua corrente
//            ListPreference listPref = (ListPreference) pref;
//            pref.setSummary(listPref.getEntry());
//        }
//    }
}
