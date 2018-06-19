package com.pitipong.android.pigfarm;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by pw on 6/11/2017.
 */

public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/OpenSans-Light.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build() );
    }
}
