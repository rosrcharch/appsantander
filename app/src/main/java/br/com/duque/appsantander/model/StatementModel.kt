package br.com.duque.appsantander.model

import com.google.gson.annotations.SerializedName

data class StatementModel(
        @SerializedName("title")
        val title: String,
        @SerializedName("desc")
        val desc: String,
        @SerializedName("date")
        val date: String,
        @SerializedName("value")
        val value: String) {
}