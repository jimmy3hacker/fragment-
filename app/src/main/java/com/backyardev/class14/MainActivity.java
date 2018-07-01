package com.backyardev.class14;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import org.json.JSONObject;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    String news,headline;
    RelativeLayout frag_head,frag_container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.news_articles );
        frag_head=findViewById( R.id.first );
        frag_container=findViewById( R.id.second );
        getSupportActionBar().setTitle( Html.fromHtml("<font color=\"black\">" + getString(R.string.app_name) + "</font>"));
        String json = null;
        try {
            InputStream is = getApplication().getAssets().open("news.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
            Log.d("TEST",json);
            JSONObject obj = new JSONObject(json);

            headline=obj.getString("headline");
            news=obj.getString("news");


        } catch (Exception ex) {
            ex.printStackTrace();}

        HeadlineFragment headObj=new HeadlineFragment();
        Bundle bundle=new Bundle();
        bundle.putString("headline",headline);
        headObj.setArguments(bundle);
        FragmentManager fragmentManager;
        fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().add(R.id.first,
                headObj).commit();
        frag_head.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentFragment newsObj=new ContentFragment();
                Bundle bundle=new Bundle(  );
                bundle.putString("news",news);
                newsObj.setArguments(bundle);
                FragmentManager fragmentManager=getFragmentManager();
                fragmentManager.beginTransaction().replace( R.id.second,
                        newsObj ).commit();
            }
        } );
 }
}
