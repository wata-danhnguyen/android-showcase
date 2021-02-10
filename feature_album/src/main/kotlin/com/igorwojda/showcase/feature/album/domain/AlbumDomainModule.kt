package com.igorwojda.showcase.feature.album.domain

import com.igorwojda.showcase.feature.album.MODULE_NAME
import com.igorwojda.showcase.feature.album.domain.usecase.GetAlbumListUseCase
import com.igorwojda.showcase.feature.album.domain.usecase.GetAlbumUseCase
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

internal val domainModule = DI.Module("${MODULE_NAME}DomainModule") {

    bind() from singleton { GetAlbumListUseCase(instance()) }

    bind() from singleton { GetAlbumUseCase(instance()) }
}
