package br.com.duque.appsantander.repository.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import br.com.duque.appsantander.model.User

@Dao
interface UserDao {

    @Query("SELECT * from table_user WHERE COLUMN_ID")
    fun getAllUsers() : List<User>

    @Insert(onConflict = REPLACE)
    fun insertUser(user: User): Long
}