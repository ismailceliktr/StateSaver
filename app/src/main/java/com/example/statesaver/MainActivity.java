package com.example.statesaver;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final String KEY_COUNTER = "COUNTER";
    private int mCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickCounter(View view){
        mCounter++;
        ((TextView)findViewById(R.id.textViewCounter)).setText("Counter: "+Integer.toString(mCounter));
    }

    @Override //saveData
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COUNTER, mCounter);
    }

    //Telefonun sağa sola çevrilmesi dahi bu datayı kaybetmeye neden olduğu
    //için datayı bu üstteki ve alttaki iki metod ile saklamak zorundayız.
    //Uygulama UI'sinde yazılı olan data her zaman saklanır, çünkü bir
    //ID'si var o UI'nin ve her ID'si olan otomatik olarak tutulur.
    //AMA HEPSİ DEĞİL, BAZILARI TUTULMAYABİLİR, TEST EDİLMELİ.

    @Override //restoreData
    protected void onRestoreInstanceState(Bundle savedInstance){
        super.onRestoreInstanceState(savedInstance);
        mCounter = savedInstance.getInt(KEY_COUNTER);
    }
}
