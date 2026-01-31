package com.example.collegeappandchatbot.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserLoginResponse {

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("pk_id")
    @Expose
    private String pkId;

    @SerializedName("student_name")
    @Expose
    private String studentName;

    @SerializedName("phone_no")
    @Expose
    private String phone_no;

    @SerializedName("enrollment_no")
    @Expose
    private String enrollmentNo;

    @SerializedName("aadhar_no")
    @Expose
    private String aadharNo;

    @SerializedName("class_id")
    @Expose
    private String classId;

    @SerializedName("roll_no")
    @Expose
    private String rollNo;

    @SerializedName("grn")
    @Expose
    private String grn;

    @SerializedName("student_photo")
    @Expose
    private String studentPhoto;

    @SerializedName("gender")
    @Expose
    private String gender;

    @SerializedName("student_email")
    @Expose
    private String studentEmail;

    @SerializedName("blood_group")
    @Expose
    private String bloodGroup;

    @SerializedName("dob")
    @Expose
    private String dob;

    @SerializedName("caste")
    @Expose
    private String caste;

    @SerializedName("religion")
    @Expose
    private String religion;

    @SerializedName("nationality")
    @Expose
    private String nationality;

    @SerializedName("permanent_address")
    @Expose
    private String permanentAddress;

    @SerializedName("correspondence_address")
    @Expose
    private String correspondenceAddress;

    @SerializedName("parent_name")
    @Expose
    private String parentName;

    @SerializedName("parent_phone")
    @Expose
    private String parentPhone;

    @SerializedName("parent_email")
    @Expose
    private String parentEmail;

    @SerializedName("occupation")
    @Expose
    private String occupation;

    @SerializedName("relation")
    @Expose
    private String relation;

    @SerializedName("password")
    @Expose
    private String password;

    @SerializedName("token_id")
    @Expose
    private String tokenId;

    @SerializedName("department_id")
    @Expose
    private String departmentId;

    // Getters and Setters for all fields
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPkId() {
        return pkId;
    }

    public void setPkId(String pkId) {
        this.pkId = pkId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getEnrollmentNo() {
        return enrollmentNo;
    }

    public void setEnrollmentNo(String enrollmentNo) {
        this.enrollmentNo = enrollmentNo;
    }

    public String getAadharNo() {
        return aadharNo;
    }

    public void setAadharNo(String aadharNo) {
        this.aadharNo = aadharNo;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getGrn() {
        return grn;
    }

    public void setGrn(String grn) {
        this.grn = grn;
    }

    public String getStudentPhoto() {
        return studentPhoto;
    }

    public void setStudentPhoto(String studentPhoto) {
        this.studentPhoto = studentPhoto;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getCaste() {
        return caste;
    }

    public void setCaste(String caste) {
        this.caste = caste;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getCorrespondenceAddress() {
        return correspondenceAddress;
    }

    public void setCorrespondenceAddress(String correspondenceAddress) {
        this.correspondenceAddress = correspondenceAddress;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getParentPhone() {
        return parentPhone;
    }

    public void setParentPhone(String parentPhone) {
        this.parentPhone = parentPhone;
    }

    public String getParentEmail() {
        return parentEmail;
    }

    public void setParentEmail(String parentEmail) {
        this.parentEmail = parentEmail;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }
}
