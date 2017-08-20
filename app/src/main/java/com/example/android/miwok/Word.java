package com.example.android.miwok;

/**
 * Created by preri on 4/9/2017.
 */

public class Word {

    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageResId;
    private boolean imageRes=false;
    private int mAudio;

    public Word(String defaultTranslation, String miwokTranslation, int miwokImage, int miwokAudio)
    {
        mMiwokTranslation=miwokTranslation;
        mDefaultTranslation=defaultTranslation;
        mImageResId=miwokImage;
        imageRes=true;
        mAudio = miwokAudio;
    }


    public Word(String defaultTranslation, String miwokTranslation,int miwokAudio)
    {
        mMiwokTranslation=miwokTranslation;
        mDefaultTranslation=defaultTranslation;
        mAudio=miwokAudio;

    }

    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public int getResId() {
        return mImageResId;
    }

    public boolean hasImage(){
        return imageRes;
    }

    public int getAudioId() {return mAudio;}
}
