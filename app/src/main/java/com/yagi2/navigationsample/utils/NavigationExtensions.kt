package com.yagi2.navigationsample.utils


import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.NavDirections

/**
 * Navigate via the given {@link NavDirections} and clear the previous navigation stack
 * if you switch to another activity by specifying a list of actionIds.
 *
 * @param directions directions that describe this navigation operation
 * @param actionIds Ids of the actions related to new activities
 * @param currentActivity the activity related to the initial graph
 *
 */
fun NavController.navigate(directions: NavDirections, actionIds: List<Int>, currentActivity: FragmentActivity) {
    this.navigate(directions)
    if (actionIds.contains(directions.actionId)) {
        currentActivity.finish()
    }
}