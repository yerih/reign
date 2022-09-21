package com.admissions.empty_project.data.server.request_responses

import com.admissions.domain.HackerNew

data class HackerNewsResponse(
    val hits: List<Hit>,
) {
    data class Hit(
        val author: String?,
        val created_at: String?,
        val story_title: String?,
        val story_url: String?,
    )
}

fun List<HackerNewsResponse.Hit>.asHackerNewList(): List<HackerNew> = map { it.asHackerNew() }
fun HackerNewsResponse.Hit.asHackerNew(): HackerNew = HackerNew(
    title = story_title?:"not available",
    author = author?:"not available",
    date = created_at?:"not available",
    url = story_url?:"not available"
)
