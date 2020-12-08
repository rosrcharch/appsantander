package br.com.duque.appsantander.model

import com.google.gson.annotations.SerializedName

class UserAccount {

    var user: String = ""
    var password: String = ""
    @SerializedName("userId")
    var userId: Int = 0
    @SerializedName("name")
    var name: String = ""
    @SerializedName("bankAccount")
    var bankAccount: String = ""
    @SerializedName("agency")
    var agency: String = ""
    @SerializedName("balance")
    var balance: Int = 0
}