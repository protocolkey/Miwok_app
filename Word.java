package com.example.android.miwok;

/**
 * Created by don on 9/20/16.
 */
public class Word {

    private String mDefaultWord;
    private String mMiwokWord;
    private int mImageviewId;
    private int mSoundId;


    public Word(String mDefaultWord, String mMiwokWord,int PicresourceId,int SoundId) {
        this.mDefaultWord = mDefaultWord;
        this.mMiwokWord = mMiwokWord;
        this.mImageviewId = PicresourceId;
        this.mSoundId= SoundId;
    }

    public Word(String mDefaultWord, String mMiwokWord,int SoundId) {

        this.mDefaultWord = mDefaultWord;
        this.mMiwokWord = mMiwokWord;
        this.mImageviewId=-99999;//no picture to display
        this.mSoundId= SoundId;
    }



    public int getmSoundId() {
        return mSoundId;
    }



    public String getmDefaultWord() {
        return mDefaultWord;
    }

    public String getmMiwokWord() {
        return mMiwokWord;
    }

    public int getmImageviewId() {
        return mImageviewId;
    }
}
