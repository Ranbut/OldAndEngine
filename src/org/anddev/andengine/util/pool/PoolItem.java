package org.anddev.andengine.util.pool;

/**
 * @author Valentin Milea
 * (c) 2010 Nicolas Gramlich 
 * (c) 2011 Zynga Inc.
 *
 * @author Nicolas Gramlich
 *
 * @since 23:02:47 - 21.08.2010
 */
public abstract class PoolItem {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    Pool<? extends PoolItem> mParent;
    boolean mRecycled = true;

    // ===========================================================
    // Constructors
    // ===========================================================

    public Pool<? extends PoolItem> getParent() {
        return this.mParent;
    }

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    public boolean isRecycled() {
        return this.mRecycled;
    }

    public boolean isFromPool(final Pool<? extends PoolItem> pPool) {
        return pPool == this.mParent;
    }

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================

    protected void onRecycle() {

    }

    protected void onObtain() {

    }

    public void recycle() {
        if(this.mParent == null) {
            throw new IllegalStateException("Item already recycled!");
        }

        this.mParent.recycle(this);
    }

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================
}