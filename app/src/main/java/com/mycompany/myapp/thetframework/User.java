package com.mycompany.myapp.thetframework;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Paul on 1/11/2018.
 */
@Entity(tableName = "users")
public class User {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private long timemonitor;
    private String thumblineuri, downloaduri;
    private String username, password, email, mobile, address, businesscode, dateOfBirth, skill, userid;
    private int business, question, answer;
    private boolean admin;
    private String status, uriString;
    private boolean readstatus, hasimage;
    private String classe;
    @Ignore
    public User(){}
    @Ignore
    public User(String username, String password, String email,String mobile, String address ){
        this.address = address;
        this.email = email;
        this.password = password;
        this.mobile = mobile;
        this.username = username;

    }
    @Ignore
    public User(String username, String password, String email,String mobile, String classe, int question, int answer ){
        this.classe = classe;
        this.question = question;
        this.answer = answer;
        this.email = email;
        this.password = password;
        this.mobile = mobile;
        this.username = username;
    }

    public User(int id,String userid, String username, String password, String email,String mobile, String classe, int question, int answer, long timemonitor, boolean admin, String dateOfBirth, boolean readstatus, String status, String skill, boolean hasimage, String uriString, String thumblineuri, String downloaduri){

        this.status = status;
        this.classe = classe;
        this.question = question;
        this.answer = answer;
        this.email = email;
        this.readstatus = readstatus;
        this.password = password;
        this.mobile = mobile;
        this.username = username;
        this.admin = admin;
        this.id = id;
        this.skill = skill;
        this.userid = userid;
        this.uriString = uriString;
        this.dateOfBirth = dateOfBirth;
        this.timemonitor = timemonitor;
        this.hasimage =hasimage;
        this.thumblineuri = thumblineuri;
        this.downloaduri = downloaduri;
    }
    @Ignore
    public User(String userid,String username, String password, String email,String mobile, String classe, int questions, int answer, long timemonitor, boolean admin,String dateOfBirth, boolean readstatus, String status, String skill, boolean hasimage, String uriString, String thumblineuri, String downloaduri){
        this.status = status;
        this.classe = classe;
        this.question = questions;
        this.answer = answer;
        this.email = email;
        this.password = password;
        this.mobile = mobile;
        this.readstatus = readstatus;
        this.username = username;
        this.admin = admin;
        this.dateOfBirth = dateOfBirth;
        this.timemonitor = timemonitor;
        this.skill = skill;
        this.userid = userid;
        this.uriString = uriString;
        this.hasimage = hasimage;
        this.downloaduri = downloaduri;
        this.thumblineuri = thumblineuri;
    }
    @Ignore
    public User(String username, String password, String email,String mobile, String classe, int questions, int answer, long timemonitor, boolean admin, String dateOfBirth, String status){
        this.dateOfBirth = dateOfBirth;
        this.status = status;
        this.classe = classe;
        this.question = questions;
        this.answer = answer;
        this.email = email;
        this.password = password;
        this.mobile = mobile;
        this.username = username;
        this.admin = admin;
        this.dateOfBirth = null;
        this.timemonitor = timemonitor;

    }
    @Ignore
    public User(String username, String password, String email,String mobile, String classe, int questions, int answer, long timemonitor, boolean admin, String dateOfBirth ){
        this.classe = classe;
        this.question = questions;
        this.answer = answer;
        this.email = email;
        this.password = password;
        this.mobile = mobile;
        this.username = username;
        this.admin = admin;
        this.dateOfBirth = dateOfBirth;
        this.timemonitor = timemonitor;

    }
    @Ignore
    public User(String username, String password, String email,String mobile, String address, int business){
        this.address = address;
        this.email = email;
        this.password = password;
        this.mobile = mobile;
        this.username = username;
        this.business = business;
    }
//    public User( String businesscode, String username, String password, String email,String mobile, String address, int business, long timemonitor){
//        this.address = address;
//        this.email = email;
//        this.Password = password;
//        this.mobile = mobile;
//        this.username = username;
//        this.business = business;
//        this.businesscode = businesscode;
//        this.timemonitor = timemonitor;
//    }
    @Ignore
    User(String username, String email,String mobile, String address ){
        this.address = address;
        this.email = email;
        this.mobile = mobile;
        this.username = username;
    }
    @Ignore
    User(String username, String mobile, String address ){
        this.address = address;
        this.mobile = mobile;
        this.username = username;
    }

    public int getAnswer() {
        return answer;
    }

    public int getQuestion() {
        return question;
    }

    public String getClasse() {
        return classe;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public void setQuestion(int question) {
        this.question = question;
    }
    public int getBusiness() {
        return business;
    }

    public void setBusiness(int business) {
        this.business = business;
    }

    public String getBusinesscode() {
        return businesscode;
    }

    public void setBusinesscode(String businesscode) {
        this.businesscode = businesscode;
    }
    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setPassword(String password) {
        password = password;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isAdmin() {
        return admin;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void setTimemonitor(long timemonitor) {
        this.timemonitor = timemonitor;
    }
    public long getTimemonitor() {
        return timemonitor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setReadstatus(boolean readstatus) {
        this.readstatus = readstatus;
    }

    public boolean isReadstatus() {
        return readstatus;
    }

    public String getStatus() {
        return status;
    }

    public String getSkill() {
        return skill;
    }

    public String getUserid() {
        return userid;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public boolean isHasimage() {
        return hasimage;
    }

    public void setHasimage(boolean hasimage) {
        this.hasimage = hasimage;
    }

    public String getUriString() {
        return uriString;
    }

    public void setUriString(String uriString) {
        this.uriString = uriString;
    }

    public String getDownloaduri() {
        return downloaduri;
    }

    public String getThumblineuri() {
        return thumblineuri;
    }

    public void setDownloaduri(String downloaduri) {
        this.downloaduri = downloaduri;
    }

    public void setThumblineuri(String thumblineuri) {
        this.thumblineuri = thumblineuri;
    }
}

