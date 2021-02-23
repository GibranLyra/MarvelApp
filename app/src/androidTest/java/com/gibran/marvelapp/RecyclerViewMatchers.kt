package com.gibran.marvelapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.hamcrest.Description
import org.hamcrest.Matcher

object RecyclerViewMatchers {

    fun atPosition(
        position: Int,
        itemMatcher: Matcher<View>
    ) = object : BoundedMatcher<View, RecyclerView>(RecyclerView::class.java) {
        override fun describeTo(description: Description?) {
            description?.appendText("has item at position $position: ")
            itemMatcher.describeTo(description)
        }

        override fun matchesSafely(item: RecyclerView?): Boolean {
            val viewHolder = item?.findViewHolderForAdapterPosition(position) ?: return false
            return itemMatcher.matches(viewHolder.itemView)
        }
    }

    fun checkRecyclerViewItem(resId: Int, position: Int, withMatcher: Matcher<View>) {
        onView(withId(resId)).check(
            matches(atPosition(position, hasDescendant(withMatcher)))
        )
    }
}