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

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.PointerIcon
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PointerRecyclerAdapter(pointerList: ArrayList<Pair<PointerIcon, String>>) :
    RecyclerView.Adapter<PointerViewHolder>() {

    private val mPointerList = pointerList

    @SuppressLint("InflateParams")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PointerViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.pointer_viewholder, parent, false)
        return PointerViewHolder(v)
    }

    override fun getItemCount(): Int {
        return mPointerList.size
    }

    override fun onBindViewHolder(holder: PointerViewHolder, position: Int) {
        holder.bind(mPointerList[position])
    }
}