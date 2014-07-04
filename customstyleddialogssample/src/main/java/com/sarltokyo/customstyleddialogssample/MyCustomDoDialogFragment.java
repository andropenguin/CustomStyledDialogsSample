/*
 * Copyright 2014 andropenguin@gmail.com (twitter id: @penguindaa )
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * This sample program is based on the sample of android-styled-dialogs's demo.
 */

package com.sarltokyo.customstyleddialogssample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by osabe on 14/07/03.
 */
public class MyCustomDoDialogFragment extends Fragment
        implements View.OnClickListener, ICustomDoDialogListener {

    private final static String TAG = MyCustomDoDialogFragment.class.getSimpleName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }
        return inflater.inflate(R.layout.fragment_sample, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Button button = (Button)getView().findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                CustomDoDialogFragment dialog = CustomDoDialogFragment
                        .newInstance("Do list:",
                                        new String[]{"Reply", "Retweet", "Favorite",
                                                "Manage list", "Open browser", "Share"});
                dialog.setTargetFragment(MyCustomDoDialogFragment.this, 0);
                dialog.show(getActivity().getSupportFragmentManager(),
                        "MyCustomDoDialogFragment");
                break;
            default:
                break;
        }
    }

    @Override
    public void onListItemSelected(String value, int number) {
        Log.d(TAG, "value = " + value);
        Log.d(TAG, "number = " + number);
        Toast.makeText(getActivity(), value + " was selected\n"
        + "number = " + number, Toast.LENGTH_SHORT).show();
    }
}
