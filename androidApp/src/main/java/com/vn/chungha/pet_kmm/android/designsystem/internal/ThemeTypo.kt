package com.vn.chungha.pet_kmm.android.designsystem.internal

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.vn.chungha.pet_kmm.android.R

@Immutable
@Stable
class ThemeTypo {

  private val interFontFamily = FontFamily(
    Font(R.font.inter_regular),
    Font(R.font.inter_bold, FontWeight.Bold),
    Font(R.font.inter_light, FontWeight.Light),
    Font(R.font.inter_medium, FontWeight.Medium),
    Font(R.font.inter_semibold, FontWeight.SemiBold),
  )

  val h1 = TextStyle(
    fontFamily = interFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 42.sp,
    lineHeight = 42.sp,
  )

  val h2 = TextStyle(
    fontFamily = interFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 24.sp,
    lineHeight = 32.sp,
  )

  val h3 = TextStyle(
    fontFamily = interFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 24.sp,
    lineHeight = 32.sp,
  )

  val title = TextStyle(
    fontFamily = interFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 22.sp,
    lineHeight = 26.sp,
  )

  val heading = TextStyle(
    fontFamily = interFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 20.sp,
    lineHeight = 28.sp,
  )

  val body = TextStyle(
    fontFamily = interFontFamily,
    fontWeight = FontWeight.SemiBold,
    fontSize = 14.sp,
    lineHeight = 20.sp,
    textAlign = TextAlign.Start,
  )

  val body1 = TextStyle(
    fontFamily = interFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp,
    lineHeight = 24.sp,
  )

  val body2 = TextStyle(
    fontFamily = interFontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 14.sp,
    lineHeight = 20.sp,
  )

  val body3 = TextStyle(
    fontFamily = interFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 14.sp,
    lineHeight = 17.sp,
  )

  val body4 = TextStyle(
    fontFamily = interFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 13.sp,
    lineHeight = 17.sp,
  )

  val caption = TextStyle(
    fontFamily = interFontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 12.sp,
    lineHeight = 16.sp,
  )

  val subhead = TextStyle(
    fontFamily = interFontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 12.sp,
    lineHeight = 16.sp,
  )

  val subTitle = TextStyle(
    fontFamily = interFontFamily,
    fontWeight = FontWeight.SemiBold,
    fontSize = 16.sp,
    lineHeight = 24.sp,
  )

  val subTitle2 = TextStyle(
    fontFamily = interFontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 16.sp,
    lineHeight = 24.sp,
  )

  val button = TextStyle(
    fontFamily = interFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 16.sp,
    lineHeight = 24.sp,
  )

  val innerBoldSize12Line16 = TextStyle(
    fontFamily = FontFamily(
      Font(resId = R.font.inter_bold),
    ),
    fontSize = 12.sp,
    lineHeight = 16.sp,
  )

  val innerMediumSize12LineHeight16 = TextStyle(
    fontFamily = interFontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 12.sp,
    lineHeight = 16.sp,
  )

  val innerMediumSize14LineHeight20 = TextStyle(
    fontFamily = interFontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 14.sp,
    lineHeight = 20.sp,
  )

  val innerRegularSize14LineHeight20 = TextStyle(
    fontFamily = interFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 14.sp,
    lineHeight = 20.sp,
  )

  val innerSemiBoldSize14LineHeight20 = TextStyle(
    fontFamily = interFontFamily,
    fontWeight = FontWeight.SemiBold,
    fontSize = 14.sp,
    lineHeight = 20.sp,
  )

  val innerBoldSize16LineHeight24 = TextStyle(
    fontFamily = interFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 16.sp,
    lineHeight = 24.sp,
  )

  val innerBoldSize20LineHeight28 = TextStyle(
    fontFamily = interFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 20.sp,
    lineHeight = 28.sp,
  )

  val innerBoldSize24LineHeight28 = TextStyle(
    fontFamily = interFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 24.sp,
    lineHeight = 28.sp,
  )

  val font400_14sp = TextStyle(
    fontFamily = interFontFamily,
    fontWeight = FontWeight.W400,
    fontSize = 14.sp,
    lineHeight = 20.sp,
  )

  val font500_14sp = TextStyle(
    fontFamily = interFontFamily,
    fontWeight = FontWeight.W500,
    fontSize = 14.sp,
    lineHeight = 20.sp,
  )

  val font700_20sp = TextStyle(
    fontFamily = interFontFamily,
    fontWeight = FontWeight.W700,
    fontSize = 20.sp,
    lineHeight = 28.sp,
  )

  val font700_16sp = TextStyle(
    fontFamily = interFontFamily,
    fontWeight = FontWeight.W700,
    fontSize = 16.sp,
    lineHeight = 24.sp,
  )
}
