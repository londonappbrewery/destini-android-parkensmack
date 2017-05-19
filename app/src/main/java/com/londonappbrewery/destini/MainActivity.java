package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.londonappbrewery.destini.R.string.T1_Ans1;
import static com.londonappbrewery.destini.R.string.T1_Ans2;
import static com.londonappbrewery.destini.R.string.T1_Story;
import static com.londonappbrewery.destini.R.string.T2_Ans1;
import static com.londonappbrewery.destini.R.string.T2_Ans2;
import static com.londonappbrewery.destini.R.string.T2_Story;
import static com.londonappbrewery.destini.R.string.T3_Ans1;
import static com.londonappbrewery.destini.R.string.T3_Ans2;
import static com.londonappbrewery.destini.R.string.T3_Story;
import static com.londonappbrewery.destini.R.string.T4_End;
import static com.londonappbrewery.destini.R.string.T5_End;
import static com.londonappbrewery.destini.R.string.T6_End;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private TextView mStoryText;
    private Button mTopAnswer;
    private Button  mBottomAnswer;
    private Button mPlayAgain;
    private int mStoryIndex = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null){
            mStoryIndex = savedInstanceState.getInt("IndexKey");
        }else{
            mStoryIndex = 1;
        }


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryText = (TextView) findViewById(R.id.storyTextView);
        mTopAnswer = (Button) findViewById(R.id.buttonTop);
        mBottomAnswer = (Button) findViewById(R.id.buttonBottom);
        mPlayAgain = (Button) findViewById(R.id.againButton);
        mPlayAgain.setVisibility(View.GONE);




        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mTopAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mStoryIndex == 1) {
                    mStoryText.setText(T3_Story);
                    mTopAnswer.setText(T3_Ans1);
                    mBottomAnswer.setText(T3_Ans2);
                    mStoryIndex = 3;
                }else if (mStoryIndex == 2){
                    mStoryText.setText(T3_Story);
                    mTopAnswer.setText(T3_Ans1);
                    mBottomAnswer.setText(T3_Ans2);
                    mStoryIndex = 3;
                }else if(mStoryIndex == 3){
                    mStoryIndex = 6;
                    mStoryText.setText(T6_End);
                    mTopAnswer.setVisibility(View.GONE);
                    mBottomAnswer.setVisibility(View.GONE);
                    mPlayAgain.setVisibility(View.VISIBLE);
                }
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mBottomAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mStoryIndex == 1) {
                    mStoryText.setText(T2_Story);
                    mTopAnswer.setText(T2_Ans1);
                    mBottomAnswer.setText(T2_Ans2);
                    mStoryIndex = 2;
                } else if (mStoryIndex == 2) {
                    mStoryIndex = 4;
                    mStoryText.setText(T4_End);
                    mTopAnswer.setVisibility(View.GONE);
                    mBottomAnswer.setVisibility(View.GONE);
                    mPlayAgain.setVisibility(View.VISIBLE);
                } else if (mStoryIndex == 3) {
                    mStoryIndex = 5;
                    mStoryText.setText(T5_End);
                    mTopAnswer.setVisibility(View.GONE);
                    mBottomAnswer.setVisibility(View.GONE);
                    mPlayAgain.setVisibility(View.VISIBLE);
                }
            }


        });
        mPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStoryText.setText(T1_Story);
                mTopAnswer.setText(T1_Ans1);
                mBottomAnswer.setText(T1_Ans2);
                mStoryIndex = 1;
                mTopAnswer.setVisibility(View.VISIBLE);
                mBottomAnswer.setVisibility(View.VISIBLE);
                mPlayAgain.setVisibility(View.GONE);

            }
        });
    }



    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        outState.putInt("IndexKey", mStoryIndex);
    }

}
