/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.chromeos.samples.pointericon

import android.view.PointerIcon
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PointerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(pointerPair: Pair<PointerIcon, String>) {
        val pointerText = itemView.findViewById<TextView>(R.id.pointer_name)
        pointerText.text = pointerPair.second

        itemView.setOnHoverListener { view, motionEvent ->
            view.pointerIcon = pointerPair.first
            false
        }
    }
}
