package org.anddev.andengine.audio.sound;

import java.io.FileDescriptor;
import java.io.IOException;

import android.content.Context;

/**
 * (c) 2010 Nicolas Gramlich 
 * (c) 2011 Zynga Inc.
 *
 * @author Nicolas Gramlich
 * @since 14:23:03 - 11.03.2010
 */
public class SoundFactory {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    private static String sAssetBasePath = "";

    // ===========================================================
    // Constructors
    // ===========================================================

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    /**
     * @param pAssetBasePath must end with '<code>/</code>' or have <code>.length() == 0</code>.
     */
    public static void setAssetBasePath(final String pAssetBasePath) {
        if(pAssetBasePath.endsWith("/") || pAssetBasePath.length() == 0) {
            SoundFactory.sAssetBasePath = pAssetBasePath;
        } else {
            throw new IllegalStateException("pAssetBasePath must end with '/' or be lenght zero.");
        }
    }

    public static void reset() {
        SoundFactory.setAssetBasePath("");
    }

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================

    public static Sound createSoundFromPath(final SoundManager pSoundManager, final String pPath) throws IOException {
        final int soundID = pSoundManager.getSoundPool().load(pPath, 1);
        final Sound sound = new Sound(pSoundManager, soundID);
        pSoundManager.add(sound);
        return sound;
    }

    public static Sound createSoundFromAsset(final SoundManager pSoundManager, final Context pContext, final String pAssetPath) throws IOException {
        final int soundID = pSoundManager.getSoundPool().load(pContext.getAssets().openFd(SoundFactory.sAssetBasePath + pAssetPath), 1);
        final Sound sound = new Sound(pSoundManager, soundID);
        pSoundManager.add(sound);
        return sound;
    }

    public static Sound createSoundFromResource(final SoundManager pSoundManager, final Context pContext, final int pSoundResID) {
        final int soundID = pSoundManager.getSoundPool().load(pContext, pSoundResID, 1);
        final Sound sound = new Sound(pSoundManager, soundID);
        pSoundManager.add(sound);
        return sound;
    }

    public static Sound createSoundFromFileDescriptor(final SoundManager pSoundManager, final FileDescriptor pFileDescriptor, final long pOffset, final long pLength) throws IOException {
        final int soundID = pSoundManager.getSoundPool().load(pFileDescriptor, pOffset, pLength, 1);
        final Sound sound = new Sound(pSoundManager, soundID);
        pSoundManager.add(sound);
        return sound;
    }

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================
}