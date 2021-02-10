package com.igorwojda.showcase.feature.album.presentation

import androidx.fragment.app.Fragment
import coil.ImageLoader
import com.igorwojda.showcase.base.di.KotlinViewModelProvider
import com.igorwojda.showcase.feature.album.MODULE_NAME
import com.igorwojda.showcase.feature.album.presentation.albumdetail.AlbumDetailViewModel
import com.igorwojda.showcase.feature.album.presentation.albumlist.AlbumListViewModel
import com.igorwojda.showcase.feature.album.presentation.albumlist.recyclerview.AlbumAdapter
import org.kodein.di.DI
import org.kodein.di.android.x.AndroidLifecycleScope
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.scoped
import org.kodein.di.singleton

internal val presentationModule = DI.Module("${MODULE_NAME}PresentationModule") {

    // AlbumList
    bind<AlbumListViewModel>() with scoped<Fragment>(AndroidLifecycleScope).singleton {
        KotlinViewModelProvider.of(context) { AlbumListViewModel(instance(), instance()) }
    }

    bind() from singleton { AlbumAdapter() }

    bind() from singleton { ImageLoader(instance()) }

    // AlbumDetails
    bind<AlbumDetailViewModel>() with scoped<Fragment>(AndroidLifecycleScope).singleton {
        KotlinViewModelProvider.of(context) { AlbumDetailViewModel(instance(), instance()) }
    }
}
