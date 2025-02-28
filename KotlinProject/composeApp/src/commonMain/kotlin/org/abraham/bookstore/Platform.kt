package org.abraham.bookstore

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform