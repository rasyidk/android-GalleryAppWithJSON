package com.example.peniliansiot;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Base64;
import android.widget.ImageView;

import uk.co.senab.photoview.PhotoViewAttacher;

public class view extends AppCompatActivity {

    PhotoViewAttacher photoViewAttacher ;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        imageView = findViewById(R.id.img_vw);

        String newString;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                newString= null;
            } else {
                newString= extras.getString("STRING_I_NEED");

                byte[] decodestring = Base64.decode(newString,Base64.DEFAULT);
                Bitmap bitmap = BitmapFactory.decodeByteArray(decodestring,0,decodestring.length);
                imageView.setImageBitmap(bitmap);
            }
        } else {
            newString= (String) savedInstanceState.getSerializable("STRING_I_NEED");
        }



        photoViewAttacher = new PhotoViewAttacher(imageView);

        photoViewAttacher.update();
    }
}
