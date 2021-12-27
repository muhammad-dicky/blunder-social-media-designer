package com.cupangsawah.blunder.Model

class User {
    private var username: String = ""
    private var fullname: String = ""
    private var bio: String = ""
    private var image: String = ""
    private var uid: String = ""

    constructor()

    constructor(username: String, fullname: String, bio: String, image: String, uid: String)
    {
        this.username = username
        this.fullname = fullname
        this.bio = bio
        this.image = image
        this.uid = uid
    }

    //get & set username
    fun getUsername(): String{
        return username
    }

    fun setUsername(username: String){
        this.username = username
    }

    //get & set full name
    fun getFullname(): String{
        return fullname
    }

    fun setFullname(fullname: String){
        this.fullname = fullname
    }

    //get & set bio
    fun getBio(): String{
        return bio
    }

    fun setBio(bio: String){
        this.bio = bio
    }

    //get & set image
    fun getImage(): String{
        return image
    }

    fun setImage(image: String){
        this.image = image
    }

    //get & set uid
    fun getUID(): String{
        return uid
    }

    fun setUID(uid: String){
        this.uid = uid
    }



}