package com.pitipong.android.pigfarm;

import com.pitipong.android.pigfarm.dal.PreferenceManager;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by pw on 6/11/2017.
 */

public class Application extends android.app.Application {

    public static PreferenceManager pm;

    @Override
    public void onCreate() {
        super.onCreate();
        pm = new PreferenceManager(this);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/OpenSans-Light.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build() );
    }
}
