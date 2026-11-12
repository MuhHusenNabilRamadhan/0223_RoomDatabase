package com.example.meet9.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.meet9.repositori.RepositoriSiswa
import com.example.meet9.room.Siswa

class EntryViewModel(private val repositoriSiswa: RepositoriSiswa): ViewModel() {

    /**
     * Berisi status Siswa saat ini
     */
    var uiStateSiswa by mutableStateOf(UIStateSiswa())
        private set

    /* Fungsi untuk memvalidasi input */
    private fun validasiInput(uiState: DetailsSiswa = uiStateSiswa.detailsSiswa ): Boolean {
        return with(uiState) {
            nama.isNotBlank() && alamat.isNotBlank() && telepon.isNotBlank()
        }
    }

    fun updateUiState(detailsSiswa: DetailsSiswa) {
        uiStateSiswa =
            UIStateSiswa(detailsSiswa = detailsSiswa, isEntryValid = validasiInput(detailsSiswa))
    }

    /* Fungsi untuk menyimpan data yang di-entry */
    suspend fun saveSiswa() {
        if (validasiInput()) {
            repositoriSiswa.insertSiswa(uiStateSiswa.detailsSiswa.toSiswa())
        }
    }
}
