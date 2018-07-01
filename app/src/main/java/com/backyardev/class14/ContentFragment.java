package com.backyardev.class14;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ContentFragment extends Fragment {

    TextView idContent;
    String news;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate( R.layout.content_frag,container,false );
        idContent=v.findViewById( R.id.idContent );

        Bundle bundle=getArguments();

        idContent.setText( bundle.getString( "news"));

        return v;

    }
}
