package com.example.scanlio

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * AdMob disabled so the project builds without the Play Services Ads SDK.
 *
 * To turn ads back on:
 * 1. Uncomment `implementation(libs.google.play.services.ads)` in `app/build.gradle.kts`
 * 2. Restore `AndroidManifest.xml`: `ACCESS_NETWORK_STATE`, `APPLICATION_ID` meta-data,
 *    and `android:name=".ScanlioApplication"` on `<application>`
 * 3. Restore `ScanlioApplication.kt` (MobileAds.initialize)
 * 4. Replace this file with the previous `AdMobBanner.kt` implementation from version control
 */
@Composable
fun AdMobBannerStripe(modifier: Modifier = Modifier) {
    // No-op: no banner while AdMob is commented out.
}
