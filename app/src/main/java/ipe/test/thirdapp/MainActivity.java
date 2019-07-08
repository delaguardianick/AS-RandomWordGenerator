package ipe.test.thirdapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    TextView mainWord;
    Button button;
    RandomWordGenerator rwg = new RandomWordGenerator();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainWord = findViewById(R.id.mainWord);
        button = findViewById(R.id.button);

        //Random Word Generator from list R.string.word_list
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    InputStream is = readFrom(getString(R.string.word_list));
                    mainWord.setText(rwg.generateRandomWord(is));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // gets the parameter fileName from assets and returns an InputStream
    public InputStream readFrom(String fileName) throws IOException {
        AssetManager am = getApplicationContext().getAssets();
        InputStream is = am.open(fileName);

        return is;
    }
}