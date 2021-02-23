package com.gibran.marvelapp.mainfragment

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.gibran.marvelapp.RecyclerViewMatchers.atPosition
import com.gibran.marvelapp.R
import com.gibran.marvelapp.ui.screen.main.MainFragment
import com.squareup.rx2.idler.Rx2Idler
import io.reactivex.plugins.RxJavaPlugins
import org.hamcrest.CoreMatchers
import org.junit.Before
import org.junit.Test

class MainFragmentFragmentTest {

    //region [Setup]
    @Before
    fun setup() {
        RxJavaPlugins.setInitComputationSchedulerHandler(Rx2Idler.create("RxJava 2.x Computation Scheduler"))
        RxJavaPlugins.setInitIoSchedulerHandler(Rx2Idler.create("RxJava 2.x IO Scheduler"))
    }
    //endregion [Setup]

    //region [View]
    @Test
    fun shouldDisplayListItem() {
        //given
        val scenario = launchFragmentInContainer<MainFragment>(Bundle(), R.style.Theme_MarvelApp)

        //when
        scenario.moveToState(Lifecycle.State.RESUMED)

        //then
        onView(withId(R.id.loading_layout))
            .check(matches(CoreMatchers.not(isDisplayed())))
        /*Ideally I would mock the response from the service and checks if the mocked value is being
        Displayed in the recycler. to simplify I`m using the data from the service */
        onView(withId(R.id.heroesRecyclerView))
            .check(matches(isDisplayed()))
            .check(matches(atPosition(0, hasDescendant(withText("Title 1")))))
    }

    @Test
    fun shouldDisplaySearchBar() {
        //given
        val scenario = launchFragmentInContainer<MainFragment>(Bundle(), R.style.Theme_MarvelApp)

        //when
        scenario.moveToState(Lifecycle.State.RESUMED)

        //then
        onView(withId(R.id.search_bar))
            .check(matches(isCompletelyDisplayed()))
    }
 //endregion [View]
}