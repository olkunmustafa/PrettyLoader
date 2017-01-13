package com.olkunmustafa.prettypreloaders.PairPrettyLoader;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.text.DecimalFormat;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import static org.junit.Assert.*;

/**
 * Created by olkunmustafa on 28/12/2016.
 */
@RunWith( JUnitParamsRunner.class )
public class PairPrettyLoaderCalTest {

    private static final double DELTA = 1e-15;

    private PairPrettyLoaderCal mPairPrettyLoaderCal;

    @Before
    public void setUp() throws Exception {
        this.mPairPrettyLoaderCal = new PairPrettyLoaderCal();

    }

    @Test
    @Parameters( { "10, 5, 25", "30, 10, 70", "5, 0, 10" } )
    public void pplDesiredHeightTest( int radius, int stroke, int expected ) throws Exception {

        int actual = this.mPairPrettyLoaderCal.pplDesiredHeight( radius, stroke );
        assertEquals( expected, actual );

    }

    @Test
    @Parameters( { "10, 1, 84", "5, 2, 48", "10, 0, 80" } )
    public void pplDesiredWidthTest( int radius, int stroke, int expected ) throws Exception {

        int actual = this.mPairPrettyLoaderCal.pplDesiredWidth( radius, stroke );
        assertEquals( expected, actual );

    }

    @Test
    @Parameters( { "10, 18", "1000, 1800", "1250, 2250" } )
    public void pplDesiredDurationTest( int t, int expected ) throws Exception {

        this.mPairPrettyLoaderCal.setAnimationPart( 0.2 );
        float actual = this.mPairPrettyLoaderCal.pplDesiredDuration( t );
        assertEquals( expected, actual, DELTA );

    }

    @Test
    public void pplCircleLifeTest() throws Exception {

        this.mPairPrettyLoaderCal.setAnimationPart( 0.4 );
        float get = this.mPairPrettyLoaderCal.pplCircleLife( 1000 );
        double actual = this.mPairPrettyLoaderCal.round( get, 2 );

        assertEquals( 0.63, actual, DELTA );
    }

    @Test
    @Parameters( { "1, 10, 0.5, 0.6" } )
    public void pplCircleStartPositionTest( int start, int end, double percentage, double expected ) throws Exception {

        this.mPairPrettyLoaderCal.setAnimationPart( percentage );
        float actual = this.mPairPrettyLoaderCal.pplCircleStartPosition( start, end );
        assertEquals( expected, actual, DELTA );

    }
}
