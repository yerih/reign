package com.admissions.reign.common

import com.admissions.domain.HackerNew
import com.admissions.reign.data.database.entity.HackerNewEntity

fun HackerNewEntity.toDomainModel() = HackerNew(title, url, author, date, id)
fun List<HackerNewEntity>.toDomainModel(): List<HackerNew> = map { it.toDomainModel() }

fun HackerNew.toEntityDB() = HackerNewEntity(url, title, author, date, id)
fun List<HackerNew>.toEntityDB(): List<HackerNewEntity> = map { it.toEntityDB() }

