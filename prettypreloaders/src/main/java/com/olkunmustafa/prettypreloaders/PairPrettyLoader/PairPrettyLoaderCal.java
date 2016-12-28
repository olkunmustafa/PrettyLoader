package com.olkunmustafa.prettypreloaders.PairPrettyLoader;

/**
 * Created by olkunmustafa on 28/12/2016.
 * <p>
 * This is helper calculate class.
 * Uses to calculate the desired width and height.
 */
class PairPrettyLoaderCal {

    /**
     * @param radiusPx Radius dimension for each circle
     * @param strokePx Stroke dimension for each circle
     * @return The desired height dimension for {@link PairPrettyLoaderView}
     * @since 0.1.0
     */
    int pplDesiredHeight( int radiusPx, int strokePx ) {

        int circleDiameterPx = radiusPx * 2;
        return circleDiameterPx + strokePx;

    }

    /**
     * @param radiusPx Radius dimension for each circle
     * @param strokePx Stroke dimension for each circle
     * @return Desired total width dimension for {@link PairPrettyLoaderView}
     *
     * @since 0.1.0
     */
    int pplDesiredWidth( int radiusPx, int strokePx ){

        int circleDiameterPx = radiusPx * 2;
        int totalCircleWidth = ( circleDiameterPx + strokePx ) * 2;
        return totalCircleWidth * 2;

    }

}
