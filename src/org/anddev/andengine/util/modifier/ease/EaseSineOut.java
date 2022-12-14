package org.anddev.andengine.util.modifier.ease;

import org.anddev.andengine.util.constants.MathConstants;

import android.util.FloatMath;

/**
 * (c) 2010 Nicolas Gramlich
 * (c) 2011 Zynga Inc.
 *
 * @author Gil
 * @author Nicolas Gramlich
 * @since 16:52:11 - 26.07.2010
 */
public class EaseSineOut implements IEaseFunction, MathConstants {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    private static EaseSineOut INSTANCE;

    // ===========================================================
    // Constructors
    // ===========================================================

    private EaseSineOut() {

    }

    public static EaseSineOut getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new EaseSineOut();
        }
        return INSTANCE;
    }

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    @Override
    public float getPercentage(final float pSecondsElapsed, final float pDuration) {
        return EaseSineOut.getValue(pSecondsElapsed / pDuration);
    }

    // ===========================================================
    // Methods
    // ===========================================================

    public static float getValue(final float pPercentage) {
        return (float) Math.sin(pPercentage * PI_HALF);
    }

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================
}