package com.olkunmustafa.prettypreloaders.PairPrettyLoader;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

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
    @Parameters( { "10, 1, 63", "5, 0, 30" } )
    public void pplDesiredWidthTest( int radius, int stroke, int expected ) throws Exception {

        int actual = this.mPairPrettyLoaderCal.pplDesiredWidth( radius, stroke );
        assertEquals( expected, actual );

    }

    @Test
    @Parameters( { "10, 15", "5, 7.5", "0.25, 0" } )
    public void pplDesiredDurationTest( float t, double expected ) throws Exception {

        float actual = this.mPairPrettyLoaderCal.pplDesiredDuration( t );
        assertEquals( expected, actual, DELTA );

    }
    @Test
    @Parameters( { "10, 20", "5, 10" } )
    public void pplCircleStartPositionTest( int start, double expected ) throws Exception {

        double actual = this.mPairPrettyLoaderCal.pplCircleOneStartPosition( start );
        assertEquals( expected, actual, DELTA );

    }

    @Test
    @Parameters( { "5, 0.50, 15", "5, 1, 20" } )
    public void pplCircleFirstPartCurrentPositionTest( float radius, float time, float expected ) throws Exception {

        double actual = this.mPairPrettyLoaderCal.pplCircleFirstPartCurrentPosition( radius, time );
        assertEquals( expected, actual, DELTA );


    }


    @Test
    @Parameters( { "5, 1, 10", "5, 0.5, 5" } )
    public void pplCircleSecondPartCurrentPositionTest( float radius, float time, float expected ) throws Exception {

        double actual = this.mPairPrettyLoaderCal.pplCircleSecondPartCurrentPosition( radius, time );
        assertEquals( expected, actual, DELTA );


    }
}
