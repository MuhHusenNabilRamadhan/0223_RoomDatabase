package com.example.meet9.repositori

import kotlinx.coroutines.flow.Flow
import com.example.meet9.room.Siswa
import com.example.meet9.room.SiswaDao

interface RepositoriSiswa {
    fun getAllSiswaStream(): Flow<List<Siswa>>
    suspend fun insertSiswa(siswa: Siswa)
}

