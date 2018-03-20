package it.polito.did.app_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.larswerkman.holocolorpicker.ColorPicker;
import com.larswerkman.holocolorpicker.SaturationBar;

public class LuceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luce);

        Intent intent = getIntent();
        ColorPicker picker = (ColorPicker) findViewById(R.id.colorPicker);
//        SVBar svBar = (SVBar) findViewById(R.id.svbar);
        SaturationBar saturationBar = (SaturationBar) findViewById(R.id.saturationbar);

//        picker.addSVBar(svBar);

        picker.addSaturationBar(saturationBar);


//To get the color
        picker.getColor();

//To set the old selected color u can do it like this
        picker.setOldCenterColor(picker.getColor());
// adds listener to the colorpicker which is implemented
//in the activity
//        picker.setOnColorChangedListener((ColorPicker.OnColorChangedListener) this);

//to turn of showing the old color
        picker.setShowOldCenterColor(false);

//adding onChangeListeners to bars
//        saturationBar.setOnSaturationChangedListener(new SaturationBar.OnSaturationChangedListener() {
//            @Override
//            public void onSaturationChanged(int saturation) {
//
//            }
//        });


//        Toolbar myToolbar = findViewById(R.id.my_toolbar);
//        setSupportActionBar(myToolbar);
//        ActionBar bar = getActionBar();
//        bar.setDisplayShowHomeEnabled(true);

//        myToolbar.setNavigationIcon(R.drawable.backarrow);
//
//        myToolbar.setNavigationOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        startActivity(new Intent(LuceActivity.this, SecondaryActivity.class));
//                    }
//                }
//
//        );
    }
}
