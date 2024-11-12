package com.example.inventory.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object (DAO) untuk mengakses data dari tabel "items" menggunakan Room.
 * `insert`: Menambahkan item baru ke tabel, mengabaikan jika ada konflik.
 * `update`: Memperbarui data item yang ada dalam tabel.
 * `delete`: Menghapus item dari tabel.
 * `getItem`: Mengambil satu item berdasarkan `id`, mengembalikan hasil sebagai `Flow`
              untuk pemantauan data secara real-time.
 * `getAllItems`: Mengambil semua item dari tabel dan mengembalikan hasil sebagai `Flow`.
 */

@Dao
interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Item)

    @Update
    suspend fun update(item: Item)

    @Delete
    suspend fun delete(item: Item)

    @Query("SELECT * from items WHERE id = :id")
    fun getItem(id: Int): Flow<Item>

    @Query("SELECT * from items ORDER BY name ASC")
    fun getAllItems(): Flow<List<Item>>
}