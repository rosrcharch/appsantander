package br.com.duque.appsantander.repository.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.duque.appsantander.model.User

@Database(entities = [User::class],  version = 1)
abstract class UserDatabase: RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object{

        private var instance: UserDatabase? = null

        fun getDatabase(context: Context) : UserDatabase {

            if (instance == null){
                instance = Room.databaseBuilder(
                        context.applicationContext,
                        UserDatabase::class.java,
                        "database.db").build()
            }
            return instance as UserDatabase
        }

        fun destroyInstance(){
            instance = null
        }
    }


}