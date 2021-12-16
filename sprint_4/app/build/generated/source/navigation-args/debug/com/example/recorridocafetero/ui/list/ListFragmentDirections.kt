package com.example.recorridocafetero.ui.list

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.recorridocafetero.R
import com.example.recorridocafetero.model.LugarItem
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class ListFragmentDirections private constructor() {
  private data class ActionListFragmentToDetailFragment2(
    public val lugar: LugarItem
  ) : NavDirections {
    public override fun getActionId(): Int = R.id.action_listFragment_to_detailFragment2

    @Suppress("CAST_NEVER_SUCCEEDS")
    public override fun getArguments(): Bundle {
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
  }

  public companion object {
    public fun actionListFragmentToDetailFragment2(lugar: LugarItem): NavDirections =
        ActionListFragmentToDetailFragment2(lugar)

    public fun actionListFragmentToSettingsFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_listFragment_to_settingsFragment)
  }
}
