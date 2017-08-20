package com.example.android.miwok;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.android.miwok.R.layout.list_view;

/**
 * Created by preri on 4/9/2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResId;

    static MediaPlayer mp=null;
    public WordAdapter(Activity context, ArrayList<Word>words, int colorResId){
        super(context, 0, words);
        mColorResId=colorResId;

    }


    public View getView(int position, View convertView, ViewGroup parent) {



        View listItemView = convertView;
        if(listItemView==null){
            listItemView= LayoutInflater.from(getContext()).inflate(list_view,parent,false);
        }


        final Word word = getItem(position);

        TextView miwok = (TextView) listItemView.findViewById(R.id.textmiwok);

        miwok.setText(word.getMiwokTranslation());

        TextView defaultname = (TextView) listItemView.findViewById(R.id.textwords);

        defaultname.setText(word.getDefaultTranslation());

        ImageView image = (ImageView) listItemView.findViewById((R.id.image_miwok));
        if(word.hasImage()){
            image.setImageResource(word.getResId());
        }
        else{
        image.setVisibility(View.GONE);
        }


        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(),mColorResId);
        textContainer.setBackgroundColor(color) ;
        textContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                releaseMediaPlayer();
                    mp = MediaPlayer.create(getContext(),word.getAudioId());
                    mp.start();
                    mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            if(mp!=null) {
                                releaseMediaPlayer();
                            }
                        }
                    });
                }

        });



        return listItemView;
    }


    public static void releaseMediaPlayer()
    {
        if(mp!=null){
            mp.release();
            mp=null;
        }
    }

}
