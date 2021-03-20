package com.how.vitamin.di

import com.how.vitamin.ui.HouseType
import com.how.vitamin.ui.detail.DetailViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { (type: HouseType) -> DetailViewModel(type, repository = get()) }
}