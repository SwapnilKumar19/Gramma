package com.androiddev.specs

class User{
    var name : String? = null
    var address : String? = null
    var email : String? = null
    var uid : String? = null

    constructor(name:String?, address:String?, email:String?, uid:String?){
        this.name = name
        this.address = address
        this.email = email
        this.uid = uid
    }
}
