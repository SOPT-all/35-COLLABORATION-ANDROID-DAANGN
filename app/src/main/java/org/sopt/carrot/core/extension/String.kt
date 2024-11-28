package org.sopt.carrot.core.extension

import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

fun String?.isJsonObject(): Boolean =
    try {
        this?.let { JSONObject(it) }
        true
    } catch (e: JSONException) {
        false
    }

fun String?.isJsonArray(): Boolean =
    try {
        this?.let { JSONArray(it) }
        true
    } catch (e: JSONException) {
        false
    }
