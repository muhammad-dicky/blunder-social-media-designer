package com.cupangsawah.blunder.Model

class Story {

    private var imageurl: String = ""
    private var timestart: Long = 0
    private var timeend: Long = 0
    private var storyid: String = ""
    private var userid: String = ""

    constructor()
    constructor(imageurl: String, timestart: Long, timeend: Long, storyid: String, userid: String) {
        this.imageurl = imageurl
        this.timestart = timestart
        this.timeend = timeend
        this.storyid = storyid
        this.userid = userid
    }


    //GET DATA
    fun getImageUrl(): String {
        return imageurl
    }

    fun getTimeStart(): Long {
        return timestart
    }
    fun getTimeEnd(): Long {
        return timeend
    }
    fun getStoryId(): String {
        return storyid
    }
    fun getUserId(): String {
        return userid
    }


    //SET DATA
    fun setImageUrl(imageurl: String)
    {
        this.imageurl = imageurl
    }
    fun setTimeStart(timestart: Long)
    {
        this.timestart = timestart
    }
    fun setTimeEnd(timeend: Long)
    {
        this.timeend = timeend
    }
    fun setStoryId(storyid: String)
    {
        this.storyid = storyid
    }
    fun setUserId(userid: String)
    {
        this.userid = userid
    }


}