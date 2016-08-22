package com.example.hwhong.dialogfragmentexplore;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.DialogFragment;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by hwhong on 8/22/16.
 */
public class DialogFrag extends DialogFragment implements View.OnClickListener{

    private Button yes, no;
    Communicator communicator;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        communicator = (Communicator) activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //since the class (DialogFrag) is a completely seperate view, therefore no need to pass
        //the viewgroup or the parent into the second parameter.
        //null is passed

        View view = inflater.inflate(R.layout.dialog, null);

        yes = (Button) view.findViewById(R.id.yes);
        no = (Button) view.findViewById(R.id.no);

        yes.setOnClickListener(this);
        no.setOnClickListener(this);

        setCancelable(false);
        return view;
    }

    @Override
    public void onClick(View view) {

        switch(view.getId()) {
            case R.id.yes:
                communicator.onActivity("Image is Displayed", 1);
                dismiss();
                break;
            case R.id.no:
                communicator.onActivity("Image is not Displayed", 0);
                dismiss();
                break;
        }
    }

    interface Communicator {
        public void onActivity(String string, int drawable);
    }
}
