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
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import eu.inmite.android.lib.dialogs.BaseDialogFragment;

/**
 * Created by osabe on 14/07/01.
 */
public class CustomDoDialogFragment extends BaseDialogFragment {

    private final static String TAG = CustomDoDialogFragment.class.getSimpleName();
    private static String ARG_TITLE = "title";
    private static String ARG_ITEMS = "items";
    ICustomDoDialogListener mListener = null;

    public static CustomDoDialogFragment newInstance(String title, String[] items) {
        CustomDoDialogFragment frag = new CustomDoDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_TITLE, title);
        bundle.putStringArray(ARG_ITEMS, items);
        frag.setArguments(bundle);
        return frag;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final Fragment targetFragment = getTargetFragment();
        Log.d(TAG, "targetFragment = " + targetFragment);
        try {
            if (targetFragment != null && targetFragment instanceof ICustomDoDialogListener) {
                mListener = (ICustomDoDialogListener) targetFragment;
            } else if (getActivity() instanceof ICustomDoDialogListener) {
                mListener = (ICustomDoDialogListener) getActivity();
            }
        }
            catch (ClassCastException e) {
            Log.d(TAG, "not implement ICustomDoDialogListener");
        }
        Log.d(TAG, "mListener = " + mListener);
    }

    @Override
    public Builder build(Builder builder) {
        builder.setTitle(getTitle());
        builder.setIcon(R.drawable.ic_launcher);
        ListAdapter adapter = new ArrayAdapter<String>(getActivity(),
                R.layout.item_list, R.id.list_item_text, getItems());
        builder.setItems(adapter, 0, new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (mListener != null) {
                    mListener.onListItemSelected(getItems()[position], position);
                    dismiss();
                }
            }
        });
        builder.setPositiveButton("Cancel", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        return builder;
    }

//    private String getTitle() {
    protected String getTitle() {
        return getArguments().getString(ARG_TITLE);
    }

    private String[] getItems() {
        return getArguments().getStringArray(ARG_ITEMS);
    }

    /**

     * add listener
     *
     * @param listener
     */
    public void setDialogListener(ICustomDoDialogListener listener) {
        mListener = listener;
    }

    /**
     * remove listener
     */
    public void removeDialogListener() {
        mListener = null;
    }
}
