package com.example.peniliansiot;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AdapterImg  extends RecyclerView.Adapter {

    private static final String TAG = "RecyclerAdapter";
    List<ValueImg> unggahanList;
    public static final String URL = "http://retrofitbuos.000webhostapp.com/";

    public AdapterImg(List<ValueImg> unggahanList) {
        this.unggahanList = unggahanList;
    }

    @Override
    public int getItemViewType(int position) {

        return 1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view;


        view = layoutInflater.inflate(R.layout.row_image, parent, false);
        return new ViewHolderOne(view);




    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        AdapterImg.ViewHolderOne viewHolderOne = (AdapterImg.ViewHolderOne) holder;

        String img = unggahanList.get(position).getImg();
        byte[] decodestring = Base64.decode(img,Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(decodestring,0,decodestring.length);
        viewHolderOne.imageView.setImageBitmap(bitmap);

        viewHolderOne.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String img = unggahanList.get(position).getImg();
                Intent i = new Intent(v.getContext(), view.class);
                i.putExtra("STRING_I_NEED", img);
                v.getContext().startActivity(i);

            }
        });

    }

    @Override
    public int getItemCount() {
        return unggahanList.size();
    }

    class ViewHolderOne extends RecyclerView.ViewHolder {


        ImageView imageView;


        public ViewHolderOne(@NonNull View itemView) {
            super(itemView);

           imageView = itemView.findViewById(R.id.img_rw);
        }
    }
}
