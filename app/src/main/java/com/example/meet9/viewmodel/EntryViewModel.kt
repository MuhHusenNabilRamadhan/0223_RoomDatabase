package com.example.meet9.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.meet9.repositori.RepositoriSiswa
import com.example.meet9.room.Siswa

class EntryViewModel(private val repositoriSiswa: RepositoriSiswa): ViewModel() {

    