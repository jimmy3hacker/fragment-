package com.backyardev.class14;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class HeadlineFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v= inflater.inflate( R.layout.headline_frag,container,false );
        TextView idHead=(TextView) v.findViewById( R.id.idHead );

        Bundle bundle=getArguments();
        String headline=bundle.getString( "headline" );
        idHead.setText( headline);


        return v;
    }

}
