package com.example.recorridocafetero.ui.detail

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavArgs
import com.example.recorridocafetero.model.LugarItem
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class DetailFragmentArgs(
  public val lugar: LugarItem
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
    val result = Bundle()
    if (Parcelable::class.java.isAssignableFrom(LugarItem::class.java)) {
      result.putParcelable("lugar", this.lugar as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(LugarItem::class.java)) {
      result.putSerializable("lugar", this.lugar as Serializable)
    } else {
      throw UnsupportedOperationException(LugarItem::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): DetailFragmentArgs {
      bundle.setClassLoader(DetailFragmentArgs::class.java.classLoader)
      val __lugar : LugarItem?
      if (bundle.containsKey("lugar")) {
        if (Parcelable::class.java.isAssignableFrom(LugarItem::class.java) ||
            Serializable::class.java.isAssignableFrom(LugarItem::class.java)) {
          __lugar = bundle.get("lugar") as LugarItem?
        } else {
          throw UnsupportedOperationException(LugarItem::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__lugar == null) {
          throw IllegalArgumentException("Argument \"lugar\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"lugar\" is missing and does not have an android:defaultValue")
      }
      return DetailFragmentArgs(__lugar)
    }
  }
}
