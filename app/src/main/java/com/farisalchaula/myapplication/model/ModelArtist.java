package com.farisalchaula.myapplication.model;

public class ModelArtist {

    String _id, artistName, artistCode, workDays, workProgress, email, commissionSheet;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getArtistCode() {
        return artistCode;
    }

    public void setArtistCode(String artistCode) {
        this.artistCode = artistCode;
    }

    public String getWorkDays() {
        return workDays;
    }

    public void setWorkDays(String workDays) {
        this.workDays = workDays;
    }

    public String getWorkProgress() {
        return workProgress;
    }

    public void setWorkProgress(String workProgress) {
        this.workProgress = workProgress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCommissionSheet() {
        return commissionSheet;
    }

    public void setCommissionSheet(String commissionSheet) {
        this.commissionSheet = commissionSheet;
    }
}
