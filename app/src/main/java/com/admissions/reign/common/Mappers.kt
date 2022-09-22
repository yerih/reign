package com.admissions.reign.common

import com.admissions.domain.HackerNew
import com.admissions.reign.data.database.entity.HackerNewEntity

fun HackerNewEntity.toDomainModel() = HackerNew(title, url, author, date,)
fun List<HackerNewEntity>.toDomainModel(): List<HackerNew> = map { it.toDomainModel() }

fun HackerNew.toEntityDB() = HackerNewEntity(url, title, author, date,)
fun List<HackerNew>.toEntityDB(): List<HackerNewEntity> = map { it.toEntityDB() }

