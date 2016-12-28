package com.olkunmustafa.prettypreloaders.utils;

import android.content.res.Resources;
import android.util.TypedValue;

/**
 * Created by olkunmustafa on 28/12/2016.
 */

public class DensityUtils {

    public static int dpToPx( int dp ) {
        return ( int ) TypedValue.applyDimension( TypedValue.COMPLEX_UNIT_DIP, dp, Resources.getSystem().getDisplayMetrics() );
    }

    public static int pxToDp( float px ) {
        return ( int ) TypedValue.applyDimension( TypedValue.COMPLEX_UNIT_PX, px, Resources.getSystem().getDisplayMetrics() );
    }

}
