package com.udayalakmal.glideimagerotate;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

public class MainActivity extends AppCompatActivity {

    private Bitmap theBitmap;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = findViewById(R.id.image);
        Button bt = findViewById(R.id.button);
        Button bt_180 = findViewById(R.id.button_180);
        Button bt_270 = findViewById(R.id.button_270);
        Button bt_mirror = findViewById(R.id.button_mirror);

        Glide
                .with(getApplicationContext()).asBitmap()
                .load("https://source.unsplash.com/500x500/daily/?car")
                .into(new SimpleTarget<Bitmap>() {

                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        theBitmap =resource;
                        iv.setImageBitmap(theBitmap);
                    }
                });

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                theBitmap = RotateBitmap(theBitmap,90);
                iv.setImageBitmap(theBitmap);
            }
        });
        bt_180.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                theBitmap = RotateBitmap(theBitmap,180);
                iv.setImageBitmap(theBitmap);
            }
        });
        bt_270.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                theBitmap = RotateBitmap(theBitmap,270);
                iv.setImageBitmap(theBitmap);
            }
        });

        bt_mirror.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                theBitmap = flip(theBitmap);
                iv.setImageBitmap(theBitmap);
            }
        });

    }

    public static Bitmap RotateBitmap(Bitmap source, float angle)
    {
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        return Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), matrix, true);
    }

    Bitmap flip(Bitmap source)
    {
        Matrix m = new Matrix();
        m.preScale(-1, 1);
       return Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), m, false);
    }
}
