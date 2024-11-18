package org.sopt.carrot.data.repositoryimpl

import org.sopt.carrot.data.Service.DummyService
import org.sopt.carrot.domain.repository.DummyRepository

class DummyRepositoryImpl(private val dummyService: DummyService) : DummyRepository {
}