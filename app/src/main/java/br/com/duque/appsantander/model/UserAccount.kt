package br.com.duque.appsantander.model

import com.google.gson.annotations.SerializedName

class UserAccount {

    @SerializedName("token")
    var token: String = ""

    @SerializedName("personKey")
    var personKey: String = ""

    @SerializedName("name")
    var name: String = ""

}