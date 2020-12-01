package br.com.duque.appsantander.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "TABLE_USER")
data class User(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "COLUMN_ID")
        val id: Long = 0,
        var user: String = "",
        var password: String = "") {

}