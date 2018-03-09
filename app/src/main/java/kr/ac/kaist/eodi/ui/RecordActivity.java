package kr.ac.kaist.eodi.ui;

import android.app.Activity;
import android.content.Intent;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import java.util.ArrayList;

import kr.ac.kaist.eodi.R;


public class RecordActivity extends ActionBarActivity {

    private SpeechRecognizer mRecognizer;

    public static void startActivity(Activity activity) {
        Intent intent = new Intent(activity, RecordActivity.class);
        activity.startActivityForResult(intent, 0);
        activity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.record_activity);


        /**
         *
         */
        Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        i.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, getPackageName());
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "ko-KR");
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);

        /**
         *
         */
        mRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
        mRecognizer.setRecognitionListener(new RecognitionListener() {
            @Override
            public void onReadyForSpeech(Bundle params) {

            }

            @Override
            public void onBeginningOfSpeech() {

            }

            @Override
            public void onRmsChanged(float rmsdB) {

            }

            @Override
            public void onBufferReceived(byte[] buffer) {

            }

            @Override
            public void onEndOfSpeech() {

            }

            @Override
            public void onError(int error) {

            }

            @Override
            public void onResults(Bundle results) {
                String key = "";
                key = SpeechRecognizer.RESULTS_RECOGNITION;
                ArrayList<String> mResults = results.getStringArrayList(key);
                Intent intent = new Intent();
                intent.putStringArrayListExtra("arg_keyword", mResults);
                setResult(RESULT_OK, intent);
                onBackPressed();
            }

            @Override
            public void onPartialResults(Bundle partialResults) {

            }

            @Override
            public void onEvent(int eventType, Bundle params) {

            }
        });
        mRecognizer.startListening(i);
    }

    /**
     *
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

}
