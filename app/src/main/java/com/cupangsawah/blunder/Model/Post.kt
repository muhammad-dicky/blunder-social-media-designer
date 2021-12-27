package com.cupangsawah.blunder.Model

class Post {

    private var postid : String = ""
    private var postimage : String = ""
    private var publisher : String = ""
    private var description : String = ""

    constructor()


    constructor(postid: String, postimage: String, publisher: String, description: String) {
        this.postid = postid
        this.postimage = postimage
        this.publisher = publisher
        this.description = description
    }

    //GET DATA
    fun getPostid(): String {
        return postid
    }

    fun getPostimage(): String {
        return postimage
    }

    fun getPublisher(): String {
        return publisher
    }

    fun getDescription(): String {
        return description
    }

    //SET DATA
    fun setPostid(postid: String)
    {
        this.postid = postid
    }
    fun setPostiimage(postimage: String)
    {
        this.postimage = postimage
    }
    fun setPostpublisher(publisher: String)
    {
        this.publisher = publisher
    }
    fun setDescription(description: String)
    {
        this.description = description
    }

}