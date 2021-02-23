package com.gibran.marvelapp.ext

import com.gibran.marvelservice.model.Thumbnail

fun Thumbnail.standardMediumAvatar() = path.plus("/portrait_medium.${extension}")

fun Thumbnail.landscapeLargeAvatar() = path.plus("/landscape_large.${extension}")