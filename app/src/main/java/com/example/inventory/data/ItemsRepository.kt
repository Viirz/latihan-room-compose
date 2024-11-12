/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.inventory.data

import kotlinx.coroutines.flow.Flow

/**
 * Repository that provides insert, update, delete, and retrieve of [Item] from a given data source.
 *
 * Membuat interface `ItemsRepository` yang mendefinisikan metode-metode untuk memasukkan, memperbarui, menghapus, dan mengambil data [Item]
 */
interface ItemsRepository {
    /**
     * Retrieve all the items from the the given data source.
     *
     * Mengambil semua item dari sumber data sebagai aliran (stream) `Flow`
     */
    fun getAllItemsStream(): Flow<List<Item>>

    /**
     * Retrieve an item from the given data source that matches with the [id].
     *
     * Mengambil satu item berdasarkan `id` dari sumber data, mengembalikan `Flow` yang akan
     *  ter-update otomatis jika data item berubah.
     */
    fun getItemStream(id: Int): Flow<Item?>

    /**
     * Insert item in the data source
     *
     * Memasukkan item baru ke dalam sumber data secara asynchronous, menggunakan `suspend`
     */
    suspend fun insertItem(item: Item)

    /**
     * Delete item from the data source
     *
     * Menghapus item dari sumber data secara asynchronous, menggunakan `suspend`
     */
    suspend fun deleteItem(item: Item)

    /**
     * Update item in the data source
     *
     * Memperbarui item yang sudah ada secara asynchronous, dengan `suspend`
     */
    suspend fun updateItem(item: Item)
}
