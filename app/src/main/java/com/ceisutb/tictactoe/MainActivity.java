package com.ceisutb.tictactoe;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.firebase.database.FirebaseDatabase;
import com.ceisutb.tictactoe.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = "MainActivity";
    private ActivityMainBinding binding;
    private String withId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG, "onCreate() Actividad creada exitosamente");
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        Bundle extras = getIntent().getExtras();
        String type = extras.getString("type");
        if (type.equals("wifi")) {
            withId = extras.getString("withId");
            binding.canvas.setWifiWith(withId);
            String gameId = extras.getString("gameId");
            binding.canvas.setGameId(gameId);
            binding.canvas.setMe(extras.getString("me"));
            FirebaseDatabase.getInstance().getReference().child("games")
                    .child(gameId)
                    .setValue(null);
        }
    }
}
