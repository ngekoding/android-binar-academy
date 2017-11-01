package com.ngekoding.androidbinaracademy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ngekoding.androidbinaracademy.cache.CacheManager;

import static android.R.attr.tag;

public class SharedPreferencesActivity extends AppCompatActivity {

    private EditText inputKey;
    private EditText inputValue;
    private Button buttonSave;
    private Button buttonGet;

    private CacheManager cache;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        inputKey = (EditText) findViewById(R.id.et_shared_pref_key);
        inputValue = (EditText) findViewById(R.id.et_shared_pref_value);
        buttonSave = (Button) findViewById(R.id.btn_shared_pref_save);
        buttonGet = (Button) findViewById(R.id.btn_shared_pref_get);

        cache = new CacheManager(this);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1. ambil data key
                String key = inputKey.getText().toString();

                // 2. ambil data value
                String value = inputValue.getText().toString();

                // 2.1 validasi
                if (key.isEmpty() || value.isEmpty()) {
                    Toast.makeText(SharedPreferencesActivity.this, "Form tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                    return;
                }

                // 3. simpan ke SharedPreferences
                cache.save(key, value);

                // 4. tampilkan value di Log
                printLog(key);

                // 5. clear form
                inputKey.setText("");
                inputValue.setText("");
            }
        });

        buttonGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String key = inputKey.getText().toString();
                printLog(key);
            }
        });
    }

    private void printLog(String key) {
        String storedValue = cache.get(key);

        Log.d("Sample-SharedPreference", "key: " + key);
        Log.d("Sample-SharedPreference", "value: " + storedValue);
        Log.d("Sample-SharedPreference", "======================");
    }
}
