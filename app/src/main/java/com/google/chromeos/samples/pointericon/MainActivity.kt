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

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.PointerIcon
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.google.chromeos.samples.pointericon.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Number of DPs that I want each column to be in size
    private val columnDivider = 208

    // The size of the mouse cursor
    private val cursorWidth = 30
    private val cursorHeight = 32

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val root = binding.root
        setContentView(root)

        val pointerRecyclerView = binding.pointerRecycler

        // Loading a bitmap to use later as a pointer icon
        val chromeDinoBitmap = Bitmap.createScaledBitmap(
            BitmapFactory.decodeResource(this.resources, R.drawable.chrome_dino),
            cursorWidth, cursorHeight, false
        )

        val demoPointerIcons = PointerIcons(this)

        // Creating the pointer icon here and adding it to the list of samples
        demoPointerIcons.addIcon(
            PointerIcon.create(
                chromeDinoBitmap,
                (cursorWidth / 2).toFloat(), (cursorHeight / 2).toFloat()
            ),
            "Chrome Dino"
        )

        // Setting up the recycler view to display each of the icons
        val width = resources.configuration.screenWidthDp
        pointerRecyclerView.adapter = PointerRecyclerAdapter(demoPointerIcons.getIcons())
        pointerRecyclerView.layoutManager =
            GridLayoutManager(applicationContext, width / columnDivider)
        pointerRecyclerView.setOnHoverListener { view, _ ->
            view.pointerIcon =
                PointerIcon.getSystemIcon(applicationContext, PointerIcon.TYPE_DEFAULT)
            false
        }
    }
}
