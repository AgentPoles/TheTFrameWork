package com.mycompany.myapp.thetframework;

import android.content.Intent;
import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paul on 2/12/2018.
 */
public class processall {
    int sender;
    String who;
    String body;
    String date;
    String Nname;
    String useremail;
    String username;
    String userclass;
    String coolid;
    String usernumber;
    User user;
    String Nemail;
    List<String> tobeshownquestionstrings = new ArrayList<>();
    String pathy;
    List<String> classnames;
    List<question> questionse;
    List<Answer> answeres;
    List<String> namesofupdatedclasses;
    List<String> questionssendernames = new ArrayList<>();
    List<String> answerstrings = new ArrayList<>();
    List<String>   answersendernames = new ArrayList<>();
    List<String> questioncoolids = new ArrayList<>();
    String time;
    boolean pending;
    String queid;
    String position;
    int viewpage;
    Uri pothy;
    String noanswer;
    String nocomment;
    Intent yu;
    Uri downloaduri;
    String downloadurid;
    String thumblineurid;
    String askernumber;
    String askemail;
    boolean hasImage;


    private static processall ourInstance = new processall();

    public static processall getInstance() {
        return ourInstance;
    }

    public String getQueid() {
        return queid;
    }

    public boolean isHasImage() {
        return hasImage;
    }

    public String getThumblineurid() {
        return thumblineurid;
    }

    public void setThumblineurid(String thumblineurid) {
        this.thumblineurid = thumblineurid;
    }

    public void setHasImage(boolean hasImage) {
        this.hasImage = hasImage;
    }

    public String getDownloadurid() {
        return downloadurid;
    }

    public void setDownloadurid(String downloadurid) {
        this.downloadurid = downloadurid;
    }

    public Uri getDownloaduri() {
        return downloaduri;
    }

    public void setDownloaduri(Uri downloaduri) {
        this.downloaduri = downloaduri;
    }

    public void setQueid(String queid) {
        this.queid = queid;
    }

    public String getAskemail() {
        return askemail;
    }

    public static processall getOurInstance() {
        return ourInstance;
    }

    public String getAskernumber() {
        return askernumber;
    }

    public String getBody() {
        return body;
    }

    public Intent getYu() {
        return yu;
    }

    public void setYu(Intent yu) {
        this.yu = yu;
    }

    public String getDate() {
        return date;
    }

    public String getNoanswer() {
        return noanswer;
    }

    public int getViewpage() {
        return viewpage;
    }

    public void setViewpage(int viewpage) {
        this.viewpage = viewpage;
    }

    public String getNocomment() {
        return nocomment;
    }

    public String getPosition() {
        return position;
    }

    public String getTime() {
        return time;
    }

    public void setAskemail(String askemail) {
        this.askemail = askemail;
    }

    public void setAskernumber(String askernumber) {
        this.askernumber = askernumber;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setNoanswer(String noanswer) {
        this.noanswer = noanswer;
    }

    public void setNocomment(String nocomment) {
        this.nocomment = nocomment;
    }

    public static void setOurInstance(processall ourInstance) {
        processall.ourInstance = ourInstance;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setNemail(String nemail) {
        Nemail = nemail;
    }

    public String getNname() {
        return Nname;
    }

    public void setNname(String nname) {
        Nname = nname;
    }

    public String getNemail() {
        return Nemail;
    }

    private processall() {
    }
    public void setWho(String s){
        this.who=who;

    }
    public String getWho() {
        return who;
    }

    public void setSender(int sender) {
        this.sender = sender;
    }

    public int getSender() {
        return sender;
    }

    public void setPathy(String pathy) {
        this.pathy = pathy;
    }

    public String getPathy() {
        return pathy;
    }

    public void setPending(boolean pending) {
        this.pending = pending;
    }

    public boolean isPending() {
        return pending;
    }

    public void setPothy(Uri pothy) {
        this.pothy = pothy;
    }

    public Uri getPothy() {
        return pothy;
    }

    public void setCoolid(String coolid) {
        this.coolid = coolid;
    }

    public String getCoolid() {
        return coolid;
    }

    public void setAnswersendernames(List<String> answersendernames) {
        this.answersendernames = answersendernames;
    }

    public List<String> getAnswersendernames() {
        return answersendernames;
    }

    public void setAnswerstrings(List<String> answerstrings) {
        this.answerstrings = answerstrings;
    }

    public List<String> getAnswerstrings() {
        return answerstrings;
    }

    public void setQuestionssendernames(List<String> questionssendernames) {
        this.questionssendernames = questionssendernames;
    }

    public List<String> getQuestionssendernames() {
        return questionssendernames;
    }

    public void setTobeshownquestionstrings(List<String> tobeshownquestionstrings) {
        this.tobeshownquestionstrings = tobeshownquestionstrings;
    }

    public List<String> getQuestioncoolids() {
        return questioncoolids;
    }

    public void setQuestioncoolids(List<String> questioncoolids) {
        this.questioncoolids = questioncoolids;
    }

    public List<String> getTobeshownquestionstrings() {
        return tobeshownquestionstrings;
    }
    public String getUserclass() {
        return userclass;
    }

    public String getUseremail() {
        return useremail;
    }

    public String getUsername() {
        return username;
    }

    public String getUsernumber() {
        return usernumber;
    }

    public void setUserclass(String userclass) {
        this.userclass = userclass;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUsernumber(String usernumber) {
        this.usernumber = usernumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<String> getClassnames() {
        return classnames;
    }

    public void setClassnames(List<String> classnames) {
        this.classnames = classnames;
    }

    public List<question> getQuestionse() {
        return questionse;
    }

    public void setQuestionse(List<question> questionse) {
        this.questionse = questionse;
    }

    public List<Answer> getAnsweres() {
        return answeres;
    }
    public void setAnsweres(List<Answer> answeres) {
        this.answeres = answeres;
    }

    public List<String> getNamesofupdatedclasses() {
        return namesofupdatedclasses;
    }

    public void setNamesofupdatedclasses(List<String> namesofupdatedclasses) {
        this.namesofupdatedclasses = namesofupdatedclasses;
    }

    public void addtoclassnames(String a){
        processall.getInstance().getNamesofupdatedclasses().add(a);
    }
}
