package com.farisalchaula.myapplication.server;

public class BaseURL {

    //public static  String baseUrl = "http://192.168.1.8:5050/";

    //IP wifi hape
    public static  String baseUrl = "http://192.168.43.226:5050/";

    public static  String login     = baseUrl + "user/login";
    public static  String register  = baseUrl + "user/register";
    public static  String dataArtist = baseUrl + "artist/artistdata";
    public static  String editDataArtist = baseUrl + "artist/editdata/";
    public static  String deleteData = baseUrl + "artist/delete/";
    public static  String inputData = baseUrl + "artist/input";
}
