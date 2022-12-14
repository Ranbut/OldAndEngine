package org.anddev.andengine.entity.particle.emitter;

import static org.anddev.andengine.util.constants.Constants.VERTEX_INDEX_X;
import static org.anddev.andengine.util.constants.Constants.VERTEX_INDEX_Y;

import org.anddev.andengine.util.MathUtils;
import org.anddev.andengine.util.constants.MathConstants;

import android.util.FloatMath;

/**
 * (c) 2010 Nicolas Gramlich 
 * (c) 2011 Zynga Inc.
 *
 * @author Nicolas Gramlich
 * @since 20:18:41 - 01.10.2010
 */
public class CircleParticleEmitter extends BaseCircleParticleEmitter {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    // ===========================================================
    // Constructors
    // ===========================================================

    public CircleParticleEmitter(final float pCenterX, final float pCenterY, final float pRadius) {
        super(pCenterX, pCenterY, pRadius);
    }

    public CircleParticleEmitter(final float pCenterX, final float pCenterY, final float pRadiusX, final float pRadiusY) {
        super(pCenterX, pCenterY, pRadiusX, pRadiusY);
    }

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    @Override
    public void getPositionOffset(final float[] pOffset) {
        final float random = MathUtils.RANDOM.nextFloat() * MathConstants.PI * 2;
        pOffset[VERTEX_INDEX_X] = (float) (this.mCenterX + Math.cos(random) * this.mRadiusX * MathUtils.RANDOM.nextFloat());
        pOffset[VERTEX_INDEX_Y] = (float) (this.mCenterY + Math.sin(random) * this.mRadiusY * MathUtils.RANDOM.nextFloat());
    }

    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================
}


 


 