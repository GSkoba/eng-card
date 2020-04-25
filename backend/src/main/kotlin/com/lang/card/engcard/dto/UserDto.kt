package com.lang.card.engcard.dto

class UserDto {

    constructor(){}

    constructor(username: String, password: String) {
        this.username = username
        this.password = password
    }

    var id: String? = null
    var username: String = ""
    var password: String = ""

    override fun toString(): String {
        return "UserDto(id=$id, username='$username', password='$password')"
    }
}