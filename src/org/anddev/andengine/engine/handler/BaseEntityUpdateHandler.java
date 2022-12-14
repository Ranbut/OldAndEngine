package org.anddev.andengine.engine.handler;

import org.anddev.andengine.entity.IEntity;

/**
 * (c) 2010 Nicolas Gramlich 
 * (c) 2011 Zynga Inc.
 *
 * @author Nicolas Gramlich
 * @since 14:00:25 - 24.12.2010
 */
public abstract class BaseEntityUpdateHandler implements IUpdateHandler {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    private final IEntity mEntity;

    // ===========================================================
    // Constructors
    // ===========================================================

    public BaseEntityUpdateHandler(final IEntity pEntity) {
        this.mEntity = pEntity;
    }

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    protected abstract void onUpdate(final float pSecondsElapsed, final IEntity pEntity);

    @Override
    public final void onUpdate(final float pSecondsElapsed) {
        this.onUpdate(pSecondsElapsed, this.mEntity);
    }

    @Override
    public void reset() {

    }

    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================
}