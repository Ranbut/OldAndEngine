package org.anddev.andengine.entity.scene.menu.animator;

import java.util.ArrayList;

import org.anddev.andengine.entity.modifier.MoveModifier;
import org.anddev.andengine.entity.scene.menu.item.IMenuItem;
import org.anddev.andengine.util.HorizontalAlign;
import org.anddev.andengine.util.modifier.ease.IEaseFunction;

/**
 * (c) 2010 Nicolas Gramlich 
 * (c) 2011 Zynga Inc.
 *
 * @author Nicolas Gramlich
 * @since 11:04:35 - 02.04.2010
 */
public class SlideMenuAnimator extends BaseMenuAnimator {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    // ===========================================================
    // Constructors
    // ===========================================================

    public SlideMenuAnimator(){
        super();
    }

    public SlideMenuAnimator(final IEaseFunction pEaseFunction) {
        super(pEaseFunction);
    }

    public SlideMenuAnimator(final HorizontalAlign pHorizontalAlign) {
        super(pHorizontalAlign);
    }

    public SlideMenuAnimator(final HorizontalAlign pHorizontalAlign, final IEaseFunction pEaseFunction) {
        super(pHorizontalAlign, pEaseFunction);
    }

    public SlideMenuAnimator(final float pMenuItemSpacing) {
        super(pMenuItemSpacing);
    }

    public SlideMenuAnimator(final float pMenuItemSpacing, final IEaseFunction pEaseFunction) {
        super(pMenuItemSpacing, pEaseFunction);
    }

    public SlideMenuAnimator(final HorizontalAlign pHorizontalAlign, final float pMenuItemSpacing) {
        super(pHorizontalAlign, pMenuItemSpacing);
    }

    public SlideMenuAnimator(final HorizontalAlign pHorizontalAlign, final float pMenuItemSpacing, final IEaseFunction pEaseFunction) {
        super(pHorizontalAlign, pMenuItemSpacing, pEaseFunction);
    }

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    @Override
    public void buildAnimations(final ArrayList<IMenuItem> pMenuItems, final float pCameraWidth, final float pCameraHeight) {
        final IEaseFunction easeFunction = this.mEaseFunction;
        final float maximumWidth = this.getMaximumWidth(pMenuItems);
        final float overallHeight = this.getOverallHeight(pMenuItems);

        final float baseX = (pCameraWidth - maximumWidth) * 0.5f;
        final float baseY = (pCameraHeight - overallHeight) * 0.5f;

        float offsetY = 0;
        final int menuItemCount = pMenuItems.size();
        for(int i = 0; i < menuItemCount; i++) {
            final IMenuItem menuItem = pMenuItems.get(i);

            final float offsetX;
            switch(this.mHorizontalAlign) {
                case LEFT:
                    offsetX = 0;
                    break;
                case RIGHT:
                    offsetX = maximumWidth - menuItem.getWidthScaled();
                    break;
                case CENTER:
                default:
                    offsetX = (maximumWidth - menuItem.getWidthScaled()) * 0.5f;
                    break;
            }

            final MoveModifier moveModifier = new MoveModifier(DURATION, -maximumWidth, baseX + offsetX, baseY + offsetY, baseY + offsetY, easeFunction);
            moveModifier.setRemoveWhenFinished(false);
            menuItem.registerEntityModifier(moveModifier);

            offsetY += menuItem.getHeight() + this.mMenuItemSpacing;
        }
    }

    @Override
    public void prepareAnimations(final ArrayList<IMenuItem> pMenuItems, final float pCameraWidth, final float pCameraHeight) {
        final float maximumWidth = this.getMaximumWidth(pMenuItems);
        final float overallHeight = this.getOverallHeight(pMenuItems);

        final float baseY = (pCameraHeight - overallHeight) * 0.5f;

        final float menuItemSpacing = this.mMenuItemSpacing;

        float offsetY = 0;
        final int menuItemCount = pMenuItems.size();
        for(int i = 0; i < menuItemCount; i++) {
            final IMenuItem menuItem = pMenuItems.get(i);

            menuItem.setPosition(-maximumWidth, baseY + offsetY);

            offsetY += menuItem.getHeight() + menuItemSpacing;
        }
    }

    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================
}