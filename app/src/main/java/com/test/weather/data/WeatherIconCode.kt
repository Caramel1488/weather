package com.test.weather.data

import com.test.weather.R

enum class WeatherIconCode(val code: Int, val description: String, val icon: Int) {
    SUNNY(1000, "Sunny", R.drawable.icon_113),
    PARTLYCLOUD(1003, "Partly cloudy", R.drawable.icon_116),
    CLOUDY(1006, "Cloudy", R.drawable.icon_119),
    OVERCAST(1009, "Overcast", R.drawable.icon_122),
    MIST(1030, "Mist", R.drawable.icon_143),
    PATCHYRAINPOSSIBLE(1063, "Patchy rain possible", R.drawable.icon_176),
    PATCHYSNOWPOSSIBLE(1066, "Patchy snow possible", R.drawable.icon_179),
    PATHYSLEETPOSSIBLE(1069, "Patchy sleet possible", R.drawable.icon_182),
    PATCHYFREEZINGDRIZZLEPOSSIBLE(1072, "Patchy freezing drizzle possible", R.drawable.icon_185),
    THUNDERYOUTBREAKSPOSSIBLE(1087, "Thundery outbreaks possible", R.drawable.icon_200),
    BLOWINGSNOW(1114, "Blowing snow", R.drawable.icon_227),
    BLIZZARD(1117, "Blizzard", R.drawable.icon_230),
    FOG(1135, "Fog", R.drawable.icon_248),
    FREEZINGFOG(1147, "Freezing fog", R.drawable.icon_260),
    PATCHYLIGHTDRIZZLE(1150, "Patchy light drizzle", R.drawable.icon_263),
    LIGHTDRIZZLE(1153, "Light drizzle", R.drawable.icon_266),
    FREEZINGDRIZZLE(1168, "Freezing drizzle", R.drawable.icon_281),
    HEAVYFREEZINGDRIZZLE(1171, "Heavy freezing drizzle", R.drawable.icon_284),
    PATCHYLIGHTRAIN(1180, "Patchy light rain", R.drawable.icon_293),
    LIGHTRAIN(1183, "Light rain", R.drawable.icon_296),
    MODERATERAINATTIMES(1186, "Moderate rain at times", R.drawable.icon_299),
    MODERATERAIN(1189, "Moderate rain", R.drawable.icon_302),
    HEAVYRAINATTIMES(1192, "Heavy rain at times", R.drawable.icon_305),
    HEAVYRAIN(1195, "Heavy rain", R.drawable.icon_308),
    LIGHTFREEZINGRAIN(1198, "Light freezing rain", R.drawable.icon_311),
    MODERATEORHEAVYFREEZINGRAIN(1201, "Moderate or heavy freezing rain", R.drawable.icon_314),
    LIGHTSLEET(1204, "Light sleet", R.drawable.icon_317),
    MODERATEORHEAVYSLEET(1207, "Moderate or heavy sleet", R.drawable.icon_320),
    PATCHYLIGHTSNOW(1210, "Patchy light snow", R.drawable.icon_323),
    LIGHTSNOW(1213, "Light snow", R.drawable.icon_326),
    PATCHYMODERATESNOW(1216, "Patchy moderate snow", R.drawable.icon_329),
    MOERATESNOW(1219, "Moderate snow", R.drawable.icon_332),
    PATCHYHEAVYSNOW(1222, "Patchy heavy snow", R.drawable.icon_335),
    HEAVYSNOW(1225, "Heavy snow", R.drawable.icon_338),
    ICEPELLETS(1237, "Ice pellets", R.drawable.icon_350),
    LIGHTRAINSHOWER(1240, "Light rain shower", R.drawable.icon_353),
    MODERATEORHEAVYRAINSHOWER(1243, "Moderate or heavy rain shower", R.drawable.icon_356),
    TERRENTIALRAINSHOWER(1246, "Torrential rain shower", R.drawable.icon_359),
    LIGHTSLEETSHOWERS(1249, "Light sleet showers", R.drawable.icon_362),
    MODERATEORHEAVYSLEETSHOWERS(1252, "Moderate or heavy sleet showers", R.drawable.icon_365),
    LIGHTSNOWSHOWERS(1255, "Light snow showers", R.drawable.icon_368),
    MODERATEORHEAVYSNOWSHOWERS(1258, "Moderate or heavy snow showers", R.drawable.icon_371),
    LIGHTSHOWERSOFICEPELLETS(1261, "Light showers of ice pellets", R.drawable.icon_374),
    MODERATEORHEAVYSHOWERSOFICEPELLETS(1264, "Moderate or heavy showers of ice pellets", R.drawable.icon_377),
    PATCHYLIGHTRAINWITHTHUNDER(1273, "Patchy light rain with thunder", R.drawable.icon_386),
    MODERATEORHEAVYRAINWITHTHUNDER(1276, "Moderate or heavy rain with thunder", R.drawable.icon_389),
    PATCHYLIGHTSNOWWITHTHUNDER(1279, "Patchy light snow with thunder", R.drawable.icon_392),
    MODERATEORHEAVYSNOWWITHTHUNDER(1282, "Moderate or heavy snow with thunder", R.drawable.icon_395);

    open fun getIconByCode(code:Int): Int{
        var res = 0
        for (i in WeatherIconCode.values()){
            if (i.code == code){
                res = i.icon
            }
        }
        return res
    }
}