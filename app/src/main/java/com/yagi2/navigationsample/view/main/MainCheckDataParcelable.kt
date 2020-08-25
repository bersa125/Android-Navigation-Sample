package com.yagi2.navigationsample.view.main


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class MainCheckDataParcelable(val checkFirst: Boolean, val checkSecond: Boolean) : Parcelable
