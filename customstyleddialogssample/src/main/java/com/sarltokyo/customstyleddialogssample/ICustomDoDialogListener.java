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

/**
 * Created by osabe on 14/07/01.
 */
public interface ICustomDoDialogListener {
    /**
     *
     * @param value favorite character
     * @param number index
     */
    public void onListItemSelected(String value, int number);
}
