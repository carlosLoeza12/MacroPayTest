package com.example.macropaytest.di

import com.example.macropaytest.repository.Repository
import com.example.macropaytest.repository.RepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindRepoImpl(repositoryImp: RepositoryImp): Repository
}