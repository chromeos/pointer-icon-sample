/*
 * Copyright 2020 Google LLC
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

package com.google.chromeos.samples.pointericon

import android.content.Context
import android.view.PointerIcon

class PointerIcons(private val context: Context) {

    // These are all the pointers available on Android.
    private val systemDefaultIcons = arrayOf(
        Pair(getIcon(PointerIcon.TYPE_ALIAS), "Alias"),
        Pair(getIcon(PointerIcon.TYPE_ALL_SCROLL), "All Scroll"),
        Pair(getIcon(PointerIcon.TYPE_ARROW), "Arrow"),
        Pair(getIcon(PointerIcon.TYPE_CELL), "Cell"),
        Pair(getIcon(PointerIcon.TYPE_CONTEXT_MENU), "Context Menu"),
        Pair(getIcon(PointerIcon.TYPE_COPY), "Copy"),
        Pair(getIcon(PointerIcon.TYPE_CROSSHAIR), "Crosshair"),
        Pair(getIcon(PointerIcon.TYPE_DEFAULT), "Default"),
        Pair(getIcon(PointerIcon.TYPE_GRAB), "Grab"),
        Pair(getIcon(PointerIcon.TYPE_GRABBING), "Grabbing"),
        Pair(getIcon(PointerIcon.TYPE_HAND), "Hand"),
        Pair(getIcon(PointerIcon.TYPE_HELP), "Help"),
        Pair(getIcon(PointerIcon.TYPE_HORIZONTAL_DOUBLE_ARROW), "Horizontal Double Arrow"),
        Pair(getIcon(PointerIcon.TYPE_NO_DROP), "No Drop"),
        Pair(getIcon(PointerIcon.TYPE_NULL), "null"),
        Pair(getIcon(PointerIcon.TYPE_TEXT), "Text"),
        Pair(
            getIcon(PointerIcon.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW),
            "Top Left Diagonal Double Arrow"
        ),
        Pair(
            getIcon(PointerIcon.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW),
            "Top Right Diagonal Double Arrow"
        ),
        Pair(getIcon(PointerIcon.TYPE_VERTICAL_DOUBLE_ARROW), "Vertical Double Arrow"),
        Pair(getIcon(PointerIcon.TYPE_VERTICAL_TEXT), "Vertical Text"),
        Pair(getIcon(PointerIcon.TYPE_WAIT), "Wait"),
        Pair(getIcon(PointerIcon.TYPE_ZOOM_IN), "Zoom In"),
        Pair(getIcon(PointerIcon.TYPE_ZOOM_OUT), "Zoom Out")
    )

    private var userIcons: ArrayList<Pair<PointerIcon, String>> = ArrayList()

    private fun getIcon(id: Int): PointerIcon {
        return PointerIcon.getSystemIcon(context, id)
    }

    fun addIcon(pointerIcon: PointerIcon, name: String) {
        userIcons.add(Pair(pointerIcon, name))
    }

    fun getIcons(): ArrayList<Pair<PointerIcon, String>> {
        val arrayList: ArrayList<Pair<PointerIcon, String>> = ArrayList()
        arrayList.addAll(systemDefaultIcons)
        arrayList.addAll(userIcons)
        return arrayList
    }
}
