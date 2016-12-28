package com.olkunmustafa.prettypreloaders;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by olkunmustafa on 28/12/2016.
 */

public class BasePrettyLoaderView extends View {

    public BasePrettyLoaderView( Context context ) {
        super( context );
    }

    public BasePrettyLoaderView( Context context, AttributeSet attrs ) {
        super( context, attrs );
    }

    public BasePrettyLoaderView( Context context, AttributeSet attrs, int defStyleAttr ) {
        super( context, attrs, defStyleAttr );
    }

    @TargetApi( Build.VERSION_CODES.LOLLIPOP )
    public BasePrettyLoaderView( Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes ) {
        super( context, attrs, defStyleAttr, defStyleRes );
    }

}
