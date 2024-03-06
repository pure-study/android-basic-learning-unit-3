package me.will.courses.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic (
    @StringRes val topicNameId: Int,
    @DrawableRes val topicImageId: Int,
    val associatedCoursesCount: Int
)