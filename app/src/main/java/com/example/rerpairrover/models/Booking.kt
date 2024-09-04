package com.example.rerpairrover.models

class Booking {
    var name:String = ""
    var service:String = ""
    var date:String = ""
    var time:String = ""
    var phone:String = ""
    var imageUrl:String = ""
    var id:String = ""

    constructor(name: String,service: String, date: String,time: String,phone: String, imageUrl: String, id: String) {
        this.name = name
        this.service = service
        this.date = date
        this.time = time
        this.phone = phone
        this.imageUrl = imageUrl
        this.id = id
    }

    constructor()
}